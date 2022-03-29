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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.internal.Base64;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPOutputStream;

import static io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl.shellQuote;

public class PodUpload {

  private static final String TAR_PATH_DELIMITER = "/";

  private PodUpload() {
  }

  public static boolean upload(HttpClient client, PodOperationContext context,
      OperationSupport operationSupport, Path pathToUpload)
      throws IOException, InterruptedException {

    if (Utils.isNotNullOrEmpty(context.getFile()) && pathToUpload.toFile().isFile()) {
      return uploadFile(client, context, operationSupport, pathToUpload);
    } else if (Utils.isNotNullOrEmpty(context.getDir()) && pathToUpload.toFile().isDirectory()) {
      return uploadDirectory(client, context, operationSupport, pathToUpload);
    }
    throw new IllegalArgumentException("Provided arguments are not valid (file, directory, path)");
  }

  public static boolean uploadFileData(HttpClient client, PodOperationContext context,
      OperationSupport operationSupport, InputStream inputStream)
      throws IOException, InterruptedException {
    final PodUploadWebSocketListener podUploadWebSocketListener = initWebSocket(
        buildCommandUrl(createExecCommandForUpload(context), context, operationSupport), client);
    try (
        final Base64.InputStream b64In = new Base64.InputStream(inputStream, Base64.ENCODE)) {
      podUploadWebSocketListener.waitUntilReady(operationSupport.getConfig().getRequestConfig().getUploadConnectionTimeout());
      InputStreamPumper.transferTo(b64In, podUploadWebSocketListener::send);
      podUploadWebSocketListener.waitUntilComplete(operationSupport.getConfig().getRequestConfig().getUploadRequestTimeout());
      return true;
    }
  }

  private static boolean uploadFile(HttpClient client, PodOperationContext context,
      OperationSupport operationSupport, Path pathToUpload)
      throws IOException, InterruptedException {
    try (final FileInputStream fis = new FileInputStream(pathToUpload.toFile())) {
      return uploadFileData(client, context, operationSupport, fis);
    }
  }

  private static boolean uploadDirectory(HttpClient client, PodOperationContext context,
      OperationSupport operationSupport, Path pathToUpload)
      throws IOException, InterruptedException {

    final String command = String.format(
        "mkdir -p %1$s && base64 -d - | tar -C %1$s -xzf -", shellQuote(context.getDir()));
    final PodUploadWebSocketListener podUploadWebSocketListener = initWebSocket(
        buildCommandUrl(command, context, operationSupport), client);
    try (
        final java.io.OutputStream os = InputStreamPumper.writableOutputStream(podUploadWebSocketListener::send);
        final Base64.OutputStream b64Out = new Base64.OutputStream(os, Base64.ENCODE);
        final GZIPOutputStream gzip = new GZIPOutputStream(b64Out)) {
      podUploadWebSocketListener.waitUntilReady(operationSupport.getConfig().getRequestConfig().getUploadConnectionTimeout());
      try (final TarArchiveOutputStream tar = new TarArchiveOutputStream(gzip)) {
        tar.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
        for (File file : pathToUpload.toFile().listFiles()) {
          addFileToTar(null, file, tar);
        }
        tar.flush();
      }
      podUploadWebSocketListener.waitUntilComplete(operationSupport.getConfig().getRequestConfig().getUploadRequestTimeout());
    } catch (KubernetesClientException ex) {
      if (ex.getCause() instanceof TimeoutException) {
        return false;
      }
      throw ex;
    }
    return true;
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

  private static PodUploadWebSocketListener initWebSocket(URL url, HttpClient client) {
    final PodUploadWebSocketListener podUploadWebSocketListener = new PodUploadWebSocketListener();
    final HttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
    CompletableFuture<WebSocket> startedFuture = clone.newWebSocketBuilder()
        .subprotocol("v4.channel.k8s.io")
        .uri(URI.create(url.toString()))
        .buildAsync(podUploadWebSocketListener);
    startedFuture.whenComplete((w, t) -> {
      if (t != null) {
        podUploadWebSocketListener.onError(w, t);
      }
    });
    return podUploadWebSocketListener;
  }

  private static URL buildCommandUrl(String command, PodOperationContext context, OperationSupport operationSupport)
      throws MalformedURLException {

    final StringBuilder commandBuilder = new StringBuilder();
    commandBuilder.append("exec?");
    commandBuilder.append("command=sh&command=-c");
    commandBuilder.append("&command=");
    commandBuilder.append(URLUtils.encodeToUTF(command));
    if (context.getContainerId() != null && !context.getContainerId().isEmpty()) {
      commandBuilder.append("&container=").append(context.getContainerId());
    }
    commandBuilder.append("&stdin=true");
    commandBuilder.append("&stderr=true");
    return new URL(
        URLUtils.join(operationSupport.getResourceUrl().toString(), commandBuilder.toString()));
  }

  static String createExecCommandForUpload(PodOperationContext context) {
    final String file = context.getFile();
    String directoryTrimmedFromFilePath = file.substring(0, file.lastIndexOf('/'));
    final String directory = directoryTrimmedFromFilePath.isEmpty() ? "/" : directoryTrimmedFromFilePath;
    return String.format(
        "mkdir -p %s && base64 -d - > %s", shellQuote(directory), shellQuote(file));
  }
}
