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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import static io.fabric8.kubernetes.client.utils.OptionalDependencyWrapper.wrapRunWithOptionalDependency;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction;
import io.fabric8.kubernetes.api.model.policy.v1beta1.EvictionBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.CopyOrReadable;
import io.fabric8.kubernetes.client.dsl.ExecListenable;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.Execable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TtyExecErrorChannelable;
import io.fabric8.kubernetes.client.dsl.TtyExecErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecOutputErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.ExecWebSocketListener;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.utils.PodOperationUtil;
import io.fabric8.kubernetes.client.dsl.internal.PortForwarderWebsocket;
import io.fabric8.kubernetes.client.dsl.internal.uploadable.PodUpload;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import io.fabric8.kubernetes.client.lib.FilenameUtils;

public class PodOperationsImpl extends HasMetadataOperation<Pod, PodList, PodResource<Pod>> implements PodResource<Pod>,CopyOrReadable<Boolean,InputStream, Boolean> {

    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final Integer DEFAULT_POD_LOG_WAIT_TIMEOUT = 5;
    private static final String[] EMPTY_COMMAND = {"/bin/sh", "-i"};

    private final String containerId;
    private final InputStream in;
    private final OutputStream out;
    private final OutputStream err;
    private final OutputStream errChannel;

    private final PipedOutputStream inPipe;
    private final PipedInputStream outPipe;
    private final PipedInputStream errPipe;
    private final PipedInputStream errChannelPipe;
    private final boolean withTTY;
    private final boolean withTerminatedStatus;
    private final boolean withTimestamps;
    private final String sinceTimestamp;
    private final Integer sinceSeconds;
    private final Integer withTailingLines;
    private final boolean withPrettyOutput;
    private final ExecListener execListener;
    private final Integer limitBytes;
    private final Integer bufferSize;
    private final PodOperationContext podOperationContext;

  public PodOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null);
  }

  public PodOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(new PodOperationContext(), new OperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public PodOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(superContext.withPlural("pods"), Pod.class, PodList.class);
    this.podOperationContext = context;
    this.containerId = context.getContainerId();
    this.in = context.getIn();
    this.inPipe = context.getInPipe();
    this.out = context.getOut();
    this.outPipe = context.getOutPipe();
    this.err = context.getErr();
    this.errPipe = context.getErrPipe();
    this.errChannel = context.getErrChannel();
    this.errChannelPipe = context.getErrChannelPipe();
    this.withTTY = context.isTty();
    this.withTerminatedStatus = context.isTerminatedStatus();
    this.withTimestamps = context.isTimestamps();
    this.sinceTimestamp = context.getSinceTimestamp();
    this.sinceSeconds = context.getSinceSeconds();
    this.withTailingLines = context.getTailingLines();
    this.withPrettyOutput = context.isPrettyOutput();
    this.execListener = context.getExecListener();
    this.limitBytes = context.getLimitBytes();
    this.bufferSize = context.getBufferSize();
  }

  @Override
  public PodOperationsImpl newInstance(OperationContext context) {
    return new PodOperationsImpl(podOperationContext, context);
  }

  public PodOperationContext getContext() {
    return podOperationContext;
  }
  protected String getLogParameters() {
    StringBuilder sb = new StringBuilder();
    sb.append("log?pretty=").append(withPrettyOutput);

    if (containerId != null && !containerId.isEmpty()) {
      sb.append("&container=").append(containerId);
    }
    if (withTerminatedStatus) {
      sb.append("&previous=true");
    }
    if (sinceSeconds != null) {
      sb.append("&sinceSeconds=").append(sinceSeconds);
    } else if (sinceTimestamp != null) {
      sb.append("&sinceTime=").append(sinceTimestamp);
    }
    if (withTailingLines != null) {
      sb.append("&tailLines=").append(withTailingLines);
    }
    if (limitBytes != null) {
      sb.append("&limitBytes=").append(limitBytes);
    }
    if (withTimestamps) {
      sb.append("&timestamps=true");
    }
    return sb.toString();
  }

  protected ResponseBody doGetLog(){
    try {
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters()));
      Request.Builder requestBuilder = new Request.Builder().get().url(url);
      Request request = requestBuilder.build();
      Response response = client.newCall(request).execute();
      ResponseBody body = response.body();
      assertResponseCode(request, response);
      return body;
    } catch (IOException ioException) {
      throw KubernetesClientException.launderThrowable(forOperationType("doGetLog"), ioException);
    }
  }

  @Override
  public String getLog() {
    try(ResponseBody body = doGetLog()) {
      return body.string();
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("getLog"), e);
    }
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return doGetLog().charStream();
  }

  @Override
  public String getLog(Boolean isPretty) {
    return new PodOperationsImpl(getContext().withPrettyOutput(isPretty), context).getLog();
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    try {
      PodOperationUtil.waitUntilReadyBeforeFetchingLogs(this, getContext().getLogWaitTimeout() != null ?
        getContext().getLogWaitTimeout() : DEFAULT_POD_LOG_WAIT_TIMEOUT);
      // Issue Pod Logs HTTP request
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters() + "&follow=true"));
      Request request = new Request.Builder().url(url).get().build();
      final LogWatchCallback callback = new LogWatchCallback(out);
      OkHttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
      clone.newCall(request).enqueue(callback);
      callback.waitUntilReady();
      return callback;
    } catch (IOException ioException) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), ioException);
    }
  }

  @Override
  public Loggable<LogWatch> withLogWaitTimeout(Integer logWaitTimeout) {
    return new PodOperationsImpl(getContext().withLogWaitTimeout(logWaitTimeout), context);
  }

  @Override
  public PortForward portForward(int port, ReadableByteChannel in, WritableByteChannel out) {
    try {
      return new PortForwarderWebsocket(client).forward(getResourceUrl(), port, in, out);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public LocalPortForward portForward(int port) {
    try {
      return new PortForwarderWebsocket(client).forward(getResourceUrl(), port);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public LocalPortForward portForward(int port, int localPort) {
    try {
      return new PortForwarderWebsocket(client).forward(getResourceUrl(), port, localPort);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public Boolean evict() {
    try {
      evictThis();
      return true;
    } catch (KubernetesClientException e) {
      if (e.getCode() != HttpURLConnection.HTTP_NOT_FOUND && e.getCode() != HTTP_TOO_MANY_REQUESTS) {
        throw e;
      }
      return false;
    }
  }

  private void evictThis() {
    try {
      if (Utils.isNullOrEmpty(getNamespace())) {
        throw new KubernetesClientException("Namespace not specified, but operation requires it.");
      }
      if (Utils.isNullOrEmpty(getName())) {
        throw new KubernetesClientException("Name not specified, but operation requires it.");
      }
      handleEvict(getResourceUrl(), getNamespace(), getName());
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(forOperationType("evict"), e);
    }
  }

  private void handleEvict(URL podUrl, String namespace, String name) throws ExecutionException, InterruptedException, IOException {
    Eviction eviction = new EvictionBuilder()
      .withNewMetadata()
      .withName(name)
      .withNamespace(namespace)
      .endMetadata()
      .withDeleteOptions(new DeleteOptions())
      .build();

    RequestBody requestBody = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(eviction));

    URL requestUrl = new URL(URLUtils.join(podUrl.toString(), "eviction"));
    Request.Builder requestBuilder = new Request.Builder().post(requestBody).url(requestUrl);
    handleResponse(requestBuilder, null, Collections.<String, String>emptyMap());
  }

  @Override
    public ContainerResource<LogWatch, InputStream, PipedOutputStream, OutputStream, PipedInputStream, String, ExecWatch, Boolean, InputStream, Boolean> inContainer(String containerId) {
        return new PodOperationsImpl(getContext().withContainerId(containerId), context);
    }

    @Override
    public ExecWatch exec(String... command) {
        String[] actualCommands = command.length >= 1 ? command : EMPTY_COMMAND;
        try {
            URL url = getURLWithCommandParams(HttpUrl.get(getResourceUrl()).newBuilder(), actualCommands);
            Request.Builder r = new Request.Builder().url(url).header("Sec-WebSocket-Protocol", "v4.channel.k8s.io").get();
            OkHttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
            final ExecWebSocketListener execWebSocketListener = new ExecWebSocketListener(getConfig(), in, out, err, errChannel, inPipe, outPipe, errPipe, errChannelPipe, execListener, bufferSize);
            clone.newWebSocket(r.build(), execWebSocketListener);
            execWebSocketListener.waitUntilReady();
            return execWebSocketListener;
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(forOperationType("exec"), t);
        }
    }

    URL getURLWithCommandParams(HttpUrl.Builder httpUrlBuilder, String[] commands) {
      httpUrlBuilder.addPathSegment("exec");

      for (String cmd : commands) {
        httpUrlBuilder.addQueryParameter("command", cmd);
      }

      if (containerId != null && !containerId.isEmpty()) {
        httpUrlBuilder.addQueryParameter("container", containerId);
      }
      if (withTTY) {
        httpUrlBuilder.addQueryParameter("tty", "true");
      }
      if (in != null || inPipe != null) {
        httpUrlBuilder.addQueryParameter("stdin", "true");
      }
      if (out != null || outPipe != null) {
        httpUrlBuilder.addQueryParameter("stdout", "true");
      }
      if (err != null || errPipe != null) {
        httpUrlBuilder.addQueryParameter("stderr", "true");
      }
      return httpUrlBuilder.build().url();
    }

    @Override
    public CopyOrReadable<Boolean, InputStream, Boolean> file(String file) {
      return new PodOperationsImpl(getContext().withFile(file), context);
    }

    @Override
    public CopyOrReadable<Boolean, InputStream, Boolean> dir(String dir) {
      return new PodOperationsImpl(getContext().withDir(dir), context);
    }

   @Override
   public Boolean copy(Path destination) {
    try {
      if (Utils.isNotNullOrEmpty(getContext().getFile())) {
        copyFile(getContext().getFile(), destination.toFile());
        return true;
      } else if (Utils.isNotNullOrEmpty(getContext().getDir())) {
        copyDir(getContext().getDir(), destination.toFile());
        return true;
      }
      throw new IllegalStateException("No file or dir has been specified");
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
   }

  @Override
  public Boolean upload(Path path) {
    return wrapRunWithOptionalDependency(() -> {
      try {
        return PodUpload.upload(client, getContext(), this, path);
      } catch (Exception ex) {
        Thread.currentThread().interrupt();
        throw KubernetesClientException.launderThrowable(ex);
      }
    }, "Base64InputStream class is provided by commons-codec, TarArchiveOutputStream is provided by commons-compress");
  }

  @Override
  public InputStream read() {
    try {
      if (Utils.isNotNullOrEmpty(getContext().getFile())) {
        return readFile(getContext().getFile());
      } else if (Utils.isNotNullOrEmpty(getContext().getDir())) {
        return readTar(getContext().getDir());
      }
      throw new IllegalStateException("No file or dir has been specified");
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private InputStream readFile(String source) {
    //Let's wrap the code to a callable inner class to avoid NoClassDef when loading this class.
    try {
      return new Callable<InputStream>() {
        @Override
        public InputStream call() {
          try {
            PipedOutputStream out = new PipedOutputStream();
            PipedInputStream in = new PipedInputStream(out, 1024);
            ExecWatch watch = writingOutput(out).usingListener(new ExecListener() {
              @Override
              public void onOpen(Response response) {

              }

              @Override
              public void onFailure(Throwable t, Response response) {

              }

              @Override
              public void onClose(int code, String reason) {
                try {
                  out.flush();
                  out.close();
                } catch (IOException e) {
                  e.printStackTrace();
                }
              }
            }).exec("sh", "-c", "cat " + source + "|" + "base64");
            return new org.apache.commons.codec.binary.Base64InputStream(in);
          } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
          }
        }
      }.call();
    } catch (NoClassDefFoundError e) {
      throw new KubernetesClientException("Base64InputStream class is provided by commons-codec, an optional dependency. To use the read/copy functionality you must explicitly add this dependency to the classpath.");
    }
  }

  //
  //
  // The copy and read utilities below have been inspired by Brendan Burns copy utilities on the official kubernetes-client.
  // More specifically: https://github.com/kubernetes-client/java/pull/375
  //

  private void copyFile(String source, File target)  {
    //Let's wrap the code to a runnable inner class to avoid NoClassDef on Option classes.
    try {
    new Runnable() {
      @Override
      public void run() {
        File destination = target;
        if (!destination.exists() && !destination.getParentFile().exists() && !destination.getParentFile().mkdirs()) {
            throw KubernetesClientException.launderThrowable(new IOException("Failed to create directory: " + destination.getParentFile()));
        }
        if (destination.isDirectory()) {
            String[] parts = source.split("\\/|\\\\");
            String filename = parts[parts.length - 1];
            destination = destination.toPath().resolve(filename).toFile();
        }
        try (InputStream is = readFile(source);) {
          Files.copy(is, destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    }.run();
    } catch (NoClassDefFoundError e) {
      throw new KubernetesClientException("Base64InputStream class is provided by commons-codec, an optional dependency. To use the read/copy functionality you must explicitly add this dependency to the classpath.");
    }
  }

  public InputStream readTar(String source) throws Exception {
    //Let's wrap the code to a callable inner class to avoid NoClassDef on Option classes.
    try {
      return new Callable<InputStream>() {
        @Override
        public InputStream call() throws Exception {
          try {
            PipedOutputStream out = new PipedOutputStream();
            PipedInputStream in = new PipedInputStream(out, 1024);
            ExecWatch watch = writingOutput(out).usingListener(new ExecListener() {
              @Override
              public void onOpen(Response response) {

              }

              @Override
              public void onFailure(Throwable t, Response response) {

              }

              @Override
              public void onClose(int code, String reason) {
                try {
                  out.flush();
                  out.close();
                } catch (IOException e) {
                  e.printStackTrace();
                }
              }
            }).exec("sh", "-c", "tar -cf - " + source + "|" + "base64");
            return new org.apache.commons.codec.binary.Base64InputStream(in);
          } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
          } catch (NoClassDefFoundError n) {
            throw KubernetesClientException.launderThrowable(n);
          }
        }
      }.call();
    }  catch (NoClassDefFoundError e) {
      throw new KubernetesClientException("Base64InputStream class is provided by commons-codec, an optional dependency. To use the read/copy functionality you must explicitly add this dependency to the classpath.");
    }
  }

  private void copyDir(String source, File target) throws Exception {
    //Let's wrap the code to a runnable inner class to avoid NoClassDef on Option classes.
    try {
    new Runnable() {
      @Override
      public void  run() {
        File destination = target;
        if (!destination.isDirectory() && !destination.mkdirs())

        {
          throw KubernetesClientException.launderThrowable(new IOException("Failed to create directory: " + destination));
        }
        try (
          InputStream is = readTar(source);
          org.apache.commons.compress.archivers.tar.TarArchiveInputStream tis = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream(is))

        {
          for (org.apache.commons.compress.archivers.ArchiveEntry entry = tis.getNextTarEntry(); entry != null; entry = tis.getNextEntry()) {
            if (tis.canReadEntryData(entry)) {
              final String normalizedEntryName = FilenameUtils.normalize(entry.getName());
              if (normalizedEntryName == null){
                throw new IOException("Tar entry '" + entry.getName() + "' has an invalid name");
              }
              File f = new File(destination, normalizedEntryName);
              if (entry.isDirectory()) {
                if (!f.isDirectory() && !f.mkdirs()) {
                  throw new IOException("Failed to create directory: " + f);
                }
              } else {
                File parent = f.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                  throw new IOException("Failed to create directory: " + f);
                }
                Files.copy(tis, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
              }
            }
          }
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    }.run();
     } catch (NoClassDefFoundError e) {
      throw new KubernetesClientException("TarArchiveInputStream class is provided by commons-compress, an optional dependency. To use the read/copy functionality you must explicitly add this dependency to the classpath.");
    }
  }

  @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> readingInput(InputStream in) {
        return new PodOperationsImpl(getContext().withIn(in), context);
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> writingInput(PipedOutputStream inPipe) {
        return new PodOperationsImpl(getContext().withInPipe(inPipe), context);
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> redirectingInput() {
        return redirectingInput(null);
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> redirectingInput(Integer bufferSize) {
        return new PodOperationsImpl(getContext().withInPipe(new PipedOutputStream()).withBufferSize(bufferSize), context);
    }

    @Override
    public TtyExecErrorable<String, OutputStream, PipedInputStream, ExecWatch> writingOutput(OutputStream out) {
        return new PodOperationsImpl(getContext().withOut(out), context);
    }

    @Override
    public TtyExecErrorable<String, OutputStream, PipedInputStream, ExecWatch> readingOutput(PipedInputStream outPipe) {
        return new PodOperationsImpl(getContext().withOutPipe(outPipe), context);
    }

    @Override
    public TtyExecErrorable<String, OutputStream, PipedInputStream, ExecWatch> redirectingOutput() {
        return readingOutput(new PipedInputStream());
    }

    @Override
    public TtyExecErrorChannelable<String, OutputStream, PipedInputStream, ExecWatch> writingError(OutputStream err) {
        return new PodOperationsImpl(getContext().withErr(err), context);
    }

    @Override
    public TtyExecErrorChannelable<String, OutputStream, PipedInputStream, ExecWatch> readingError(PipedInputStream errPipe) {
        return new PodOperationsImpl(getContext().withErrPipe(errPipe), context);
    }

    @Override
    public TtyExecErrorChannelable<String, OutputStream, PipedInputStream, ExecWatch> redirectingError() {
        return readingError(new PipedInputStream());
    }

    @Override
    public TtyExecable<String, ExecWatch> writingErrorChannel(OutputStream errChannel) {
        return new PodOperationsImpl(getContext().withErrChannel(errChannel), context);
    }

    @Override
    public TtyExecable<String, ExecWatch> readingErrorChannel(PipedInputStream errChannelPipe) {
        return new PodOperationsImpl(getContext().withErrChannelPipe(errChannelPipe), context);
    }

    @Override
    public TtyExecable<String, ExecWatch> redirectingErrorChannel() {
        return readingErrorChannel(new PipedInputStream());
    }



    @Override
    public ExecListenable<String, ExecWatch> withTTY() {
        return new PodOperationsImpl(getContext().withTty(true), context);
    }

    @Override
    public Loggable<LogWatch> withPrettyOutput() {
        return new PodOperationsImpl(getContext().withPrettyOutput(true), context);
    }


    @Override
    public PrettyLoggable<LogWatch> tailingLines(int withTailingLines) {
        return new PodOperationsImpl(getContext().withTailingLines(withTailingLines), context);
    }

    @Override
    public TailPrettyLoggable<LogWatch> sinceTime(String sinceTimestamp) {
        return new PodOperationsImpl(getContext().withSinceTimestamp(sinceTimestamp), context);
    }

    @Override
    public TailPrettyLoggable<LogWatch> sinceSeconds(int sinceSeconds) {
        return new PodOperationsImpl(getContext().withSinceSeconds(sinceSeconds), context);
    }

    @Override
    public TimeTailPrettyLoggable<LogWatch> terminated() {
        return new PodOperationsImpl(getContext().withTerminatedStatus(true), context);
    }

    @Override
    public Execable<String, ExecWatch> usingListener(ExecListener execListener) {
        return new PodOperationsImpl(getContext().withExecListener(execListener), context);
    }

    @Override
    public BytesLimitTerminateTimeTailPrettyLoggable<LogWatch> limitBytes(int limitBytes) {
        return new PodOperationsImpl(getContext().withLimitBytes(limitBytes), context);
    }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable<LogWatch> usingTimestamps() {
    return new PodOperationsImpl(getContext().withTimestamps(true), context);
  }

}

