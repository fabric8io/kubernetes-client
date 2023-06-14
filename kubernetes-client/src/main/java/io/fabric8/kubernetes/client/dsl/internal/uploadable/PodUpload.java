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
import org.apache.commons.compress.utils.CountingOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl.shellQuote;

public class PodUpload {

  private static final Logger LOG = LoggerFactory.getLogger(PodUpload.class);

  private static final String TAR_PATH_DELIMITER = "/";

  private PodUpload() {
  }

  public static boolean upload(PodOperationsImpl operation, Path pathToUpload)
      throws IOException {

    if (Utils.isNotNullOrEmpty(operation.getContext().getFile()) && pathToUpload.toFile().isFile()) {
      return uploadTar(operation, getDirectoryFromFile(operation),
          tar -> addFileToTar(new File(operation.getContext().getFile()).getName(), pathToUpload.toFile(), tar));
    } else if (Utils.isNotNullOrEmpty(operation.getContext().getDir()) && pathToUpload.toFile().isDirectory()) {
      return uploadTar(operation, operation.getContext().getDir(), tar -> {
        for (File file : pathToUpload.toFile().listFiles()) {
          addFileToTar(file.getName(), file, tar);
        }
      });
    }
    throw new IllegalArgumentException("Provided arguments are not valid (file, directory, path)");
  }

  private static String getDirectoryFromFile(PodOperationsImpl operation) {
    String file = operation.getContext().getFile();
    String directoryTrimmedFromFilePath = file.substring(0, file.lastIndexOf('/'));
    return directoryTrimmedFromFilePath.isEmpty() ? "/" : directoryTrimmedFromFilePath;
  }

  private interface UploadProcessor<T extends OutputStream> {

    void process(T out) throws IOException;

  }

  private static boolean upload(PodOperationsImpl operation, String file, UploadProcessor<OutputStream> processor)
      throws IOException {

    String command = createExecCommandForUpload(file);

    CompletableFuture<Integer> exitFuture;

    int uploadRequestTimeout = operation.getRequestConfig().getUploadRequestTimeout();
    long uploadRequestTimeoutEnd = uploadRequestTimeout < 0 ? Long.MAX_VALUE
        : uploadRequestTimeout + System.currentTimeMillis();
    long expected = 0;
    try (ExecWatch execWatch = operation.redirectingInput().terminateOnError().exec("sh", "-c", command)) {
      OutputStream out = execWatch.getInput();
      CountingOutputStream countingStream = new CountingOutputStream(out);
      processor.process(countingStream);
      out.close(); // also flushes
      expected = countingStream.getBytesWritten();
      exitFuture = execWatch.exitCode();
    }

    // enforce the timeout after we've written everything - generally this won't fail, but
    // we may have already exceeded the timeout because of how long it took to write
    if (!Utils.waitUntilReady(exitFuture, Math.max(0, uploadRequestTimeoutEnd - System.currentTimeMillis()),
        TimeUnit.MILLISECONDS)) {
      LOG.debug("failed to complete upload before timeout expired");
      return false;
    }
    Integer exitCode = exitFuture.getNow(null);
    if (exitCode != null && exitCode.intValue() != 0) {
      LOG.debug("upload process failed with exit code {}", exitCode);
      return false;
    }

    ByteArrayOutputStream byteCount = new ByteArrayOutputStream();
    try (ExecWatch countWatch = operation.writingOutput(byteCount).exec("sh", "-c",
        String.format("wc -c < %s", shellQuote(file)))) {
      CompletableFuture<Integer> countExitFuture = countWatch.exitCode();
      if (!Utils.waitUntilReady(countExitFuture, Math.max(0, uploadRequestTimeoutEnd - System.currentTimeMillis()),
          TimeUnit.MILLISECONDS) || !Integer.valueOf(0).equals(countExitFuture.getNow(null))) {
        LOG.debug("failed to validate the upload size, exit code {}", countExitFuture.getNow(null));
        return false;
      }
      String remoteSize = new String(byteCount.toByteArray(), StandardCharsets.UTF_8);
      if (!String.valueOf(expected).equals(remoteSize.trim())) {
        LOG.debug("upload file size validation failed, expected {}, but was {}", expected, remoteSize);
        return false;
      }
    }
    return true;
  }

  public static boolean uploadFileData(PodOperationsImpl operation, InputStream inputStream)
      throws IOException {
    return upload(operation, operation.getContext().getFile(), os -> InputStreamPumper.transferTo(inputStream, os::write));
  }

  private static boolean uploadTar(PodOperationsImpl operation, String directory,
      UploadProcessor<TarArchiveOutputStream> processor)
      throws IOException {

    String fileName = String.format("/tmp/fabric8-%s.tar", UUID.randomUUID());

    boolean uploaded = upload(operation, fileName, os -> {
      try (final TarArchiveOutputStream tar = new TarArchiveOutputStream(os)) {
        tar.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
        processor.process(tar);
      }
    });

    if (!uploaded) {
      // best effort delete of the failed upload
      try (ExecWatch rm = operation.writingOutput(new ByteArrayOutputStream()).exec("sh", "-c",
          String.format("rm %s", fileName))) {
        if (!Utils.waitUntilReady(rm.exitCode(), operation.getRequestConfig().getUploadRequestTimeout(), TimeUnit.MILLISECONDS)
            || !Integer.valueOf(0).equals(rm.exitCode().getNow(null))) {
          LOG.warn("delete of temporary tar file {} may not have completed", fileName);
        }
      }
      return false;
    }

    final String command = extractTarCommand(directory, fileName);

    try (ExecWatch execWatch = operation.redirectingInput().exec("sh", "-c", command)) {
      CompletableFuture<Integer> countExitFuture = execWatch.exitCode();
      // TODO: this enforcement duplicates the timeout
      return Utils.waitUntilReady(countExitFuture, operation.getRequestConfig().getUploadRequestTimeout(),
          TimeUnit.MILLISECONDS) && Integer.valueOf(0).equals(countExitFuture.getNow(null));
    }

  }

  static String extractTarCommand(String directory, String tar) {
    return String.format("mkdir -p %1$s; tar -C %1$s -xmf %2$s; e=$?; rm %2$s; exit $e", shellQuote(directory), tar);
  }

  private static void addFileToTar(String fileName, File file, TarArchiveOutputStream tar)
      throws IOException {
    tar.putArchiveEntry(new TarArchiveEntry(file, fileName));
    if (file.isFile()) {
      Files.copy(file.toPath(), tar);
      tar.closeArchiveEntry();
    } else if (file.isDirectory()) {
      tar.closeArchiveEntry();
      for (File fileInDirectory : file.listFiles()) {
        addFileToTar(fileName + TAR_PATH_DELIMITER + fileInDirectory.getName(), fileInDirectory, tar);
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
