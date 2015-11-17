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

import com.squareup.okhttp.Response;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ExecWebSocketListener implements WebSocketListener, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecWebSocketListener.class);

    private final InputStream in;
    private final OutputStream out;
    private final OutputStream err;

    private final AtomicReference<WebSocket> webSocketcRef = new AtomicReference<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final InputStreamPumper pumper = new InputStreamPumper();

    public ExecWebSocketListener(InputStream in, OutputStream out, OutputStream err) {
        this.in = in;
        this.out = out;
        this.err = err;
    }

    @Override
    public void close() throws Exception {
        pumper.close();
        executorService.shutdown();
        if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocketcRef.set(webSocket);
        executorService.submit(pumper);
    }

    @Override
    public void onFailure(IOException ioe, Response response) {
        LOGGER.error(response != null ? response.message() : "Exec Failure.", ioe);
    }

    @Override
    public void onMessage(BufferedSource bufferedSource, WebSocket.PayloadType payloadType) throws IOException {
        try {
            byte streamID = bufferedSource.readByte();
            ByteString byteString = bufferedSource.readByteString();
            if (byteString.size() > 0) {
                switch (streamID) {
                    case 1:
                        if (out != null) {
                            out.write(byteString.toByteArray());
                        }
                        break;
                    case 2:
                        if (err != null) {
                            err.write(byteString.toByteArray());
                        }
                        break;
                    case 3:
                        if (err != null) {
                            err.write(byteString.toByteArray());
                        }
                        break;
                    default:
                        throw new IOException("Unknown stream ID " + streamID);
                }
            }
        } finally {
            bufferedSource.close();
        }
    }

    @Override
    public void onPong(Buffer buffer) {
        LOGGER.debug("Exec Web Socket: On Pong");
    }

    @Override
    public void onClose(int i, String s) {
        LOGGER.debug("Exec Web Socket: On Close");
    }

    private void send(byte[] bytes) throws IOException {
        if (bytes.length > 0) {
            WebSocket ws = webSocketcRef.get();
            if (ws != null) {

                try (BufferedSink sink = ws.newMessageSink(WebSocket.PayloadType.BINARY)) {
                    sink.write(new byte[]{0});
                    sink.write(bytes);
                    sink.flush();
                }
            }
        }
    }

    private void send(String msg) throws IOException {
        send(msg.getBytes());
    }

    private class InputStreamPumper implements Runnable, Closeable {

        private boolean keepReading = true;
        @Override
        public void run() {
            try (InputStreamReader reader = new InputStreamReader(in);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                while (keepReading && !Thread.currentThread().isInterrupted() && (line = bufferedReader.readLine()) != null) {
                    send(line + "\n");
                }
            } catch (IOException e) {
                LOGGER.error("Error while pumping stream.", e);
            }
        }

        public void close() {
            keepReading = false;
        }
    }
 }
