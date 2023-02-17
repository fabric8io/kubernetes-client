/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.dsl.internal.uploadable;

import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

import static io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl.shellQuote;

public class PodUpload {

  private static final String TAR_PATH_DELIMITER = "/";

  private PodUpload() {
  }

  public static boolean upload(PodOperationsImpl operation, Path pathToUpload)
      throws IOException {

    if (Utils.isNotNullOrEmpty(operation.getContext().getFile()) && pathToUpload.toFile().isFile()) {
      return uploadFile(operation, pathToUpload);
    } else if (Utils.isNotNullOrEmpty(operation.getContext().getDir()) && pathToUpload.toFile().isDirectory()) {
      return uploadDirectory(operation, pathToUpload);
    }
    throw new IllegalArgumentException("Provided arguments are not valid (file, directory, path)");
  }

  private interface UploadProcessor {

    void process(OutputStream out) throws IOException;

  }

  private static boolean upload(PodOperationsImpl operation, String command, UploadProcessor processor) throws IOException {
    operation = operation.redirectingInput().terminateOnError();
    CompletableFuture<Integer> exitFuture;
    try (ExecWatch execWatch = operation.exec("sh", "-c", command)) {
      OutputStream out = execWatch.getInput();
      processor.process(out);
      out.close(); // also flushes
      exitFuture = execWatch.exitCode();
    }
    // TODO: should this timeout be from the start of the upload?
    if (!Utils.waitUntilReady(exitFuture, operation.getConfig().getRequestConfig().getUploadRequestTimeout(),
        TimeUnit.MILLISECONDS)) {
      return false;
    }
    Integer exitCode = exitFuture.getNow(null);
    return exitCode == null || exitCode.intValue() == 0;
  }

  public static boolean uploadFileData(PodOperationsImpl operation, InputStream inputStream)
      throws IOException {
    String command = createExecCommandForUpload(operation.getContext().getFile());

    return upload(operation, command, os -> InputStreamPumper.transferTo(inputStream, os::write));
  }

  private static boolean uploadFile(PodOperationsImpl operation, Path pathToUpload)
      throws IOException {
    try (final FileInputStream fis = new FileInputStream(pathToUpload.toFile())) {
      return uploadFileData(operation, fis);
    }
  }

  private static boolean uploadDirectory(PodOperationsImpl operation, Path pathToUpload)
      throws IOException {

    final String command = String.format(
        "mkdir -p %1$s && tar -C %1$s -xzf -", shellQuote(operation.getContext().getDir()));

    return upload(operation, command, os -> {
      try (final GZIPOutputStream gzip = new GZIPOutputStream(os);
          final TarArchiveOutputStream tar = new TarArchiveOutputStream(gzip)) {
        tar.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
        for (File file : pathToUpload.toFile().listFiles()) {
          addFileToTar(null, file, tar);
        }
        tar.flush();
      }
    });
  }

  private static void addFileToTar(String rootTarPath, File file, TarArchiveOutputStream tar)
      throws IOException {

    final String fileName = Optional.ofNullable(rootTarPath).orElse("") + TAR_PATH_DELIMITER + file.getName();
    tar.putArchiveEntry(new TarArchiveEntry(file, fileName));
    if (file.isFile()) {
      Files.copy(file.toPath(), tar);
      tar.closeArchiveEntry();
    } else if (file.isDirectory()) {
      tar.closeArchiveEntry();
      for (File fileInDirectory : file.listFiles()) {
        addFileToTar(fileName, fileInDirectory, tar);
      }
    }
  }

  static String createExecCommandForUpload(String file) {
    String directoryTrimmedFromFilePath = file.substring(0, file.lastIndexOf('/'));
    final String directory = directoryTrimmedFromFilePath.isEmpty() ? "/" : directoryTrimmedFromFilePath;
    return String.format(
        "mkdir -p %s && cat - > %s", shellQuote(directory), shellQuote(file));
  }

}
