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

package io.fabric8.kubernetes.server.mock;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import io.fabric8.kubernetes.client.KubernetesClientException;
import okio.Buffer;
import okio.ByteString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class WebSocketSession implements WebSocketListener {

    private final WebSocketMessage[] open;
    private final WebSocketMessage failure;
    private final Exception cause;

    private final Map<Object, Queue<WebSocketMessage>> requestEvents = new HashMap<>();
    private final List<WebSocketMessage> timedEvents = new ArrayList<>();

    private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    public WebSocketSession(WebSocketMessage[] open, WebSocketMessage failure, Exception cause) {
        this.open = open;
        this.failure = failure;
        this.cause = cause;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocketRef.set(webSocket);
        //Schedule all timed events
        for (WebSocketMessage msg : open) {
            send(msg);
        }

        for (WebSocketMessage msg : timedEvents) {
            send(msg);
        }

        checkIfShouldClose();
    }

    @Override
    public void onFailure(IOException e, Response response) {
    }

    @Override
    public void onMessage(ResponseBody message) throws IOException {
        String in = read(message);
        Queue<WebSocketMessage> queue = requestEvents.get(in);
        if (queue != null && !queue.isEmpty()) {
            WebSocketMessage msg = queue.peek();
            send(msg);
            if (msg.isToBeRemoved()) {
                queue.remove();
            }
            checkIfShouldClose();
        } else {
            webSocketRef.get().close(0, "Unexpected message:" + in);
        }
    }

    @Override
    public void onPong(Buffer payload) {

    }

    @Override
    public void onClose(int code, String reason) {

    }

    public Map<Object, Queue<WebSocketMessage>> getRequestEvents() {
        return requestEvents;
    }

    public List<WebSocketMessage> getTimedEvents() {
        return timedEvents;
    }


    private void checkIfShouldClose() {
        if (requestEvents.isEmpty()) {
            try {
                executor.shutdown();
                if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    webSocketRef.get().close(1000, "Closing...");
                } else {
                    executor.shutdownNow();
                    webSocketRef.get().close(1000, "Closing...");
                }
            } catch (Throwable t) {
                throw KubernetesClientException.launderThrowable(t);
            }
        }
    }

    private void send(final WebSocketMessage message) {
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    WebSocket ws = webSocketRef.get();
                    if (ws != null) {
                        ws.sendMessage(RequestBody.create(WebSocket.BINARY, message.getBytes()));
                    }
                } catch (IOException e) {
                    throw KubernetesClientException.launderThrowable(e);
                }
            }
        }, message.getDelay(), TimeUnit.MILLISECONDS);
    }

    private String read(ResponseBody message) throws IOException {
        try {
            byte streamID = message.source().readByte();
            ByteString byteString = message.source().readByteString();
            if (byteString.size() > 0) {
                switch (streamID) {
                    case 1:
                    case 2:
                    case 3:
                        return byteString.toString();
                    default:
                        throw new IOException("Unknown stream ID " + streamID);
                }
            }
        } finally {
            message.close();
        }
        throw new IllegalArgumentException("Not a string message");
    }
}
