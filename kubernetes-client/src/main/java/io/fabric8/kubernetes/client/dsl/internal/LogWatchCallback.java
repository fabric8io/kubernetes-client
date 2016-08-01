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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogWatchCallback implements LogWatch, Callback, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

    private final OutputStream out;
    private final PipedInputStream output;

    private final AtomicBoolean started = new AtomicBoolean(false);
    private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private InputStreamPumper pumper;

    public LogWatchCallback(OutputStream out) {
        this.out = out != null ? out : new PipedOutputStream();
        this.output = out != null ? null : new PipedInputStream();
    }

    @Override
    public void close() {
        pumper.close();
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    public void waitUntilReady() {
        try {
            Object obj = queue.poll(10, TimeUnit.SECONDS);
            if (obj instanceof Boolean && ((Boolean) obj)) {
                return;
            } else {
                if (obj instanceof Throwable) {
                    throw (Throwable) obj;
                }
            }
        } catch (Throwable t) {
            throw KubernetesClientException.launderThrowable(t);
        }
    }

    public InputStream getOutput() {
        return output;
    }

    @Override
    public void onFailure(Call call, IOException ioe) {
        LOGGER.error("Log Callback Failure.", ioe);
        //We only need to queue startup failures.
        if (!started.get()) {
            queue.add(ioe);
        }
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (out instanceof PipedOutputStream && output != null) {
            output.connect((PipedOutputStream) out);
        }

       pumper = new InputStreamPumper(response.body().byteStream(), new io.fabric8.kubernetes.client.Callback<byte[]>(){
            @Override
            public void call(byte[] input) {
                try {
                    out.write(input);
                } catch (IOException e) {
                    throw KubernetesClientException.launderThrowable(e);
                }
            }
        });
        executorService.submit(pumper);
        started.set(true);
        queue.add(true);

    }
}
