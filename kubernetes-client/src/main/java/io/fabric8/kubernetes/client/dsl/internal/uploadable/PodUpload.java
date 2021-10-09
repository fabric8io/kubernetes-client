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

import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.text.StringEscapeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.ObjIntConsumer;
import java.util.zip.GZIPOutputStream;

public class PodUpload {

  private static final int DEFAULT_BUFFER_SIZE = 8192;
  private static final String TAR_PATH_DELIMITER = "/";

  private PodUpload() {
  }

  public static boolean upload(OkHttpClient client, PodOperationContext context,
    OperationSupport operationSupport, Path pathToUpload)
    throws IOException, InterruptedException {

    if (Utils.isNotNullOrEmpty(context.getFile()) && pathToUpload.toFile().isFile()) {
      return uploadFile(client, context, operationSupport, pathToUpload);
    } else if (Utils.isNotNullOrEmpty(context.getDir()) && pathToUpload.toFile().isDirectory()) {
      return uploadDirectory(client, context, operationSupport, pathToUpload);
    }
    throw new IllegalArgumentException("Provided arguments are not valid (file, directory, path)");
  }

  private static boolean uploadFile(OkHttpClient client, PodOperationContext context,
    OperationSupport operationSupport, Path pathToUpload)
    throws IOException, InterruptedException {

    final String file = StringEscapeUtils.escapeXSI(context.getFile());
    final String directory = file.substring(0, file.lastIndexOf('/'));
    final String command = String.format(
      "mkdir -p %s && base64 -d - > %s", directory, file);
    final PodUploadWebSocketListener podUploadWebSocketListener = initWebSocket(
      buildCommandUrl(command, context, operationSupport), client);
    try (
      final FileInputStream fis = new FileInputStream(pathToUpload.toFile());
      final Base64InputStream b64In = new Base64InputStream(fis, true, 0, new byte[]{'\r', '\n'})
    ) {
      podUploadWebSocketListener.waitUntilReady(operationSupport.getConfig().getRequestConfig().getUploadConnectionTimeout());
      copy(b64In, podUploadWebSocketListener::send);
      podUploadWebSocketListener.waitUntilComplete(operationSupport.getConfig().getRequestConfig().getUploadRequestTimeout());
      return true;
    }
  }

  private static boolean uploadDirectory(OkHttpClient client, PodOperationContext context,
    OperationSupport operationSupport, Path pathToUpload)
    throws IOException, InterruptedException {

    final String command = String.format(
      "mkdir -p %1$s && base64 -d - | tar -C %1$s -xzf -", StringEscapeUtils.escapeXSI(context.getDir()));
    final PodUploadWebSocketListener podUploadWebSocketListener = initWebSocket(
      buildCommandUrl(command, context, operationSupport), client);
    try (
      final PipedOutputStream pos = new PipedOutputStream();
      final PipedInputStream pis = new PipedInputStream(pos);
      final Base64OutputStream b64Out = new Base64OutputStream(pos, true, 0, new byte[]{'\r', '\n'});
      final GZIPOutputStream gzip = new GZIPOutputStream(b64Out)

    ) {
      podUploadWebSocketListener.waitUntilReady(operationSupport.getConfig().getRequestConfig().getUploadConnectionTimeout());
      final Callable<?> readFiles = () -> {
        try (final TarArchiveOutputStream tar = new TarArchiveOutputStream(gzip)) {
          tar.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
          for (File file : pathToUpload.toFile().listFiles()) {
            addFileToTar(null, file, tar);
          }
          tar.flush();
        }
        return null;
      };
      final ExecutorService es = Executors.newSingleThreadExecutor();
      Future<?> readFilesFuture = es.submit(readFiles);
      copy(pis, podUploadWebSocketListener::send);
      podUploadWebSocketListener.waitUntilComplete(operationSupport.getConfig().getRequestConfig().getUploadRequestTimeout());
      try {
        readFilesFuture.get(100, TimeUnit.SECONDS);
        return true;
      } catch (ExecutionException ex) {
        if (ex.getCause() instanceof IOException) {
          throw (IOException) ex.getCause();
        }
        throw new IOException(ex.getMessage(), ex.getCause());
      } catch (TimeoutException e) {
        return false;
      } finally {
        es.shutdown();
      }
    }
  }

  static void copy(InputStream inputStream, ObjIntConsumer<byte[]> consumer) throws IOException {
    final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    int n;
    while (-1 != (n = inputStream.read(buffer))) {
      consumer.accept(buffer, n);
    }
  }

  private static void addFileToTar(String rootTarPath, File file, TarArchiveOutputStream tar)
    throws IOException {

    final String fileName =
      Optional.ofNullable(rootTarPath).orElse("") + TAR_PATH_DELIMITER + file.getName();
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

  private static PodUploadWebSocketListener initWebSocket(URL url, OkHttpClient client) {
    final PodUploadWebSocketListener podUploadWebSocketListener = new PodUploadWebSocketListener();
    final Request.Builder request = new Request.Builder().url(url)
      .header("Sec-WebSocket-Protocol", "v4.channel.k8s.io").get();
    final OkHttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
    clone.newWebSocket(request.build(), podUploadWebSocketListener);
    return podUploadWebSocketListener;
  }

  private static URL buildCommandUrl(String command, PodOperationContext context, OperationSupport operationSupport)
    throws UnsupportedEncodingException, MalformedURLException {

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
}
