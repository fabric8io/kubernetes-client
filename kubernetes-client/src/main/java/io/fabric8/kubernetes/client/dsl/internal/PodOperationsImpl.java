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
import com.squareup.okhttp.ws.WebSocketCall;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.Execable;
import io.fabric8.kubernetes.client.dsl.TtyExecErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecOutputErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PodOperationsImpl extends HasMetadataOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> implements ClientPodResource<Pod, DoneablePod> {

    private static final String[] EMPTY_COMMAND = {"/bin/sh", "-i"};

    private final String containerId;
    private final InputStream in;
    private final OutputStream out;
    private final OutputStream err;
    private final boolean withTTY;

    public PodOperationsImpl(OkHttpClient client, Config config, String namespace) {
        this(client, config, null, namespace, null, true, null);
    }

    public PodOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Pod item) {
        this(client, config, apiVersion, namespace, name, cascading, item, null, null, null, null, false);
    }

    public PodOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Pod item, String containerId, InputStream in, OutputStream out, OutputStream err, boolean withTTY) {
        super(client, config, null, apiVersion, "pods", namespace, name, cascading, item);
        this.containerId = containerId;
        this.in = in;
        this.out = out;
        this.err = err;
        this.withTTY = withTTY;
    }

    @Override
    public String getLog() {
        return getLog(true);
    }

    @Override
    public String getLog(Boolean isPretty) {
        StringBuilder sb = new StringBuilder();
        sb.append("log?pretty=").append(isPretty);
        if (containerId != null && !containerId.isEmpty()) {
            sb.append("&container=").append(containerId);
        }

        try {
            URL url = new URL(URLUtils.join(getResourceUrl().toString(), sb.toString()));
            Request.Builder requestBuilder = new Request.Builder().get().url(url);
            Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();
            assertResponseCode(request, response, 200);
            return response.body().string();
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    @Override
    public String getLog(String containerId) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, withTTY).getLog(true);
    }

    @Override
    public String getLog(String containerId, Boolean isPretty) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, withTTY).getLog(isPretty);
    }

    @Override
    public ContainerResource<String, InputStream, OutputStream, OutputStream, String, Watch> inContainer(String containerId) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, withTTY);
    }

    @Override
    public TtyExecable<String, Watch> usingError(OutputStream err) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, withTTY);
    }

    @Override
    public Watch exec(String... command) {
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
        if (in != null) {
            sb.append("&stdin=true");
        }
        if (out != null) {
            sb.append("&stdout=true");
        }
        if (err != null) {
            sb.append("&stderr=true");
        }

        try {
            URL url = new URL(URLUtils.join(getResourceUrl().toString(), sb.toString()));
            Request.Builder r = new Request.Builder().url(url).get();
            OkHttpClient clone = client.clone();
            clone.setReadTimeout(0, TimeUnit.MILLISECONDS);
            WebSocketCall webSocketCall = WebSocketCall.create(clone, r.build());
            final ExecWebSocketListener execWebSocketListener = new ExecWebSocketListener(in, out, err);
            webSocketCall.enqueue(execWebSocketListener);
            return new Watch() {
                @Override
                public void close() {
                    try {
                        execWebSocketListener.close();
                    } catch (Exception e) {
                        throw KubernetesClientException.launderThrowable(e);
                    }
                }
            };
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    @Override
    public TtyExecOutputErrorable<String, OutputStream, OutputStream, Watch> usingInput(InputStream in) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, withTTY);
    }

    @Override
    public TtyExecErrorable<String, OutputStream, Watch> usingOut(OutputStream out) {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, withTTY);
    }

    @Override
    public Execable<String, Watch> withTTY() {
        return new PodOperationsImpl(client, getConfig(), apiVersion, namespace, name, isCascading(), getItem(), containerId, in, out, err, true);
    }
}

