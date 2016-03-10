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
package io.fabric8.kubernetes.client.dsl.internal;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocketCall;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.ExecListenable;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.Execable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TtyExecErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecOutputErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PodOperationsImpl extends HasMetadataOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> implements ClientPodResource<Pod, DoneablePod> {

    private static final String[] EMPTY_COMMAND = {"/bin/sh", "-i"};

    private final String containerId;
    private final InputStream in;
    private final OutputStream out;
    private final OutputStream err;

    private final PipedOutputStream inPipe;
    private final PipedInputStream outPipe;
    private final PipedInputStream errPipe;
    private final boolean withTTY;
    private final boolean withTerminatedStatus;
    private final boolean withTimestamps;
    private final String sinceTimestamp;
    private final Integer sinceSeconds;
    private final Integer withTailingLines;
    private final boolean withPrettyOutput;
    private final ExecListener execListener;


    public PodOperationsImpl(OkHttpClient client, Config config, String namespace) {
        this(client, config, null, namespace, null, true, null, null, false, -1);
    }

    public PodOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Pod item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds) {
        this(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds,
             null, null, null, null, null, null, null, false, false, false, null, null, null, false, null);
    }

    public PodOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Pod item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, String containerId, InputStream in, PipedOutputStream inPipe, OutputStream out, PipedInputStream outPipe, OutputStream err, PipedInputStream errPipe, boolean withTTY, boolean withTerminatedStatus, boolean withTimestamps, String sinceTimestamp, Integer sinceSeconds, Integer withTailingLines, boolean withPrettyOutput, ExecListener execListener) {
        super(client, config, null, apiVersion, "pods", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds);
        this.containerId = containerId;
        this.in = in;
        this.inPipe = inPipe;
        this.out = out;
        this.outPipe = outPipe;
        this.err = err;
        this.errPipe = errPipe;
        this.withTTY = withTTY;
        this.withTerminatedStatus = withTerminatedStatus;
        this.withTimestamps = withTimestamps;
        this.sinceTimestamp = sinceTimestamp;
        this.sinceSeconds = sinceSeconds;
        this.withTailingLines = withTailingLines;
        this.withPrettyOutput = withPrettyOutput;
        this.execListener = execListener;
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
        return sb.toString();
    }

    @Override
    public String getLog() {
        try {
            URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters()));
            Request.Builder requestBuilder = new Request.Builder().get().url(url);
            Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();
            try (ResponseBody body = response.body()) {
              assertResponseCode(request, response, 200);
              return body.string();
            }
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    @Override
    public String getLog(Boolean isPretty) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, isPretty, execListener).getLog();
    }

    @Override
    public LogWatch watchLog() {
        return watchLog(null);
    }

    @Override
    public LogWatch watchLog(OutputStream out) {
        try {
            URL url = new URL(URLUtils.join(getResourceUrl().toString(), getLogParameters() + "&follow=true"));
            Request request = new Request.Builder().url(url).get().build();
            final LogWatchCallback callback = new LogWatchCallback(out);
            client.newCall(request).enqueue(callback);
            callback.waitUntilReady();
            return callback;
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    @Override
    public String getLog(String containerId) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener).getLog();
    }

    @Override
    public String getLog(String containerId, Boolean isPretty) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, isPretty, execListener).getLog();
    }

    @Override
    public ContainerResource<String, LogWatch, InputStream, PipedOutputStream, OutputStream, PipedInputStream, String, ExecWatch> inContainer(String containerId) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public ExecWatch exec(String... command) {
        StringBuilder sb = new StringBuilder();
        String[] actualCommands = command.length >= 1 ? command : EMPTY_COMMAND;

        sb.append("exec?command=");

        boolean first = true;
        for (String cmd : actualCommands) {
            if (first) {
                first = false;
            } else {
                sb.append("&command=");
            }
            sb.append(cmd);
        }

        if (containerId != null && !containerId.isEmpty()) {
            sb.append("&container=").append(containerId);
        }
        if (withTTY) {
            sb.append("&tty=true");
        }
        if (in != null || inPipe != null) {
            sb.append("&stdin=true");
        }
        if (out != null || outPipe != null) {
            sb.append("&stdout=true");
        }
        if (err != null || errPipe != null) {
            sb.append("&stderr=true");
        }

        try {
            URL url = new URL(URLUtils.join(getResourceUrl().toString(), sb.toString()));
            Request.Builder r = new Request.Builder().url(url).get();
            OkHttpClient clone = client.clone();
            clone.setReadTimeout(0, TimeUnit.MILLISECONDS);
            WebSocketCall webSocketCall = WebSocketCall.create(clone, r.build());
            final ExecWebSocketListener execWebSocketListener = new ExecWebSocketListener(in, out, err, inPipe, outPipe, errPipe, execListener);
            webSocketCall.enqueue(execWebSocketListener);
            execWebSocketListener.waitUntilReady();
            return execWebSocketListener;
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> readingInput(InputStream in) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> writingInput(PipedOutputStream inPipe) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, ExecWatch> redirectingInput() {
        return writingInput(new PipedOutputStream());
    }

    @Override
    public TtyExecErrorable<String, OutputStream, PipedInputStream, ExecWatch> writingOutput(OutputStream out) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TtyExecErrorable<String, OutputStream, PipedInputStream, ExecWatch> readingOutput(PipedInputStream outPipe) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TtyExecErrorable<String, OutputStream, PipedInputStream, ExecWatch> redirectingOutput() {
        return readingOutput(new PipedInputStream());
    }

    @Override
    public TtyExecable<String, ExecWatch> writingError(OutputStream err) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TtyExecable<String, ExecWatch> readingError(PipedInputStream errPipe) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, withTTY, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TtyExecable<String, ExecWatch> redirectingError() {
        return readingError(new PipedInputStream());
    }


    @Override
    public ExecListenable<String, ExecWatch> withTTY() {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public Loggable<String, LogWatch> withPrettyOutput() {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, true, execListener);
    }


    @Override
    public PrettyLoggable<String, LogWatch> tailingLines(int withTailingLines) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TailPrettyLoggable<String, LogWatch> sinceTime(String sinceTimestamp) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TailPrettyLoggable<String, LogWatch> sinceSeconds(int sinceSeconds) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, withTerminatedStatus, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public TimeTailPrettyLoggable<String, LogWatch> terminated() {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, true, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }

    @Override
    public Execable<String, ExecWatch> usingListener(ExecListener execListener) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), getResourceVersion(), getReloadingFromServer(), getGracePeriodSeconds(), containerId, in, inPipe, out, outPipe, err, errPipe, true, true, withTimestamps, sinceTimestamp, sinceSeconds, withTailingLines, withPrettyOutput, execListener);
    }
}

