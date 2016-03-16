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


import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import java.util.Map;
import java.util.Queue;

public class MockDispatcher extends Dispatcher {

    private final Map<ServerRequest, Queue<ServerResponse>> responses;

    public MockDispatcher(Map<ServerRequest, Queue<ServerResponse>> responses) {
        this.responses = responses;
    }

    @Override
    public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
        String method = request.getMethod();
        String path = request.getPath();
        ServerRequest key = new ServerRequest(method, path);
        ServerRequest keyForAnyMethod = new ServerRequest(path);
        if (responses.containsKey(key)) {
            Queue<ServerResponse> queue = responses.get(key);
            return handleResponse(queue.peek(), queue);
        } else if (responses.containsKey(keyForAnyMethod)) {
            Queue<ServerResponse> queue = responses.get(keyForAnyMethod);
            return handleResponse(queue.peek(), queue);
        }
        return new MockResponse().setResponseCode(404);
    }

    private MockResponse handleResponse(ServerResponse response, Queue<ServerResponse> queue) {
        if (response == null) {
            return new MockResponse().setResponseCode(404);
        } else if (response.isToBeRemoved()) {
            queue.remove();
        }
        MockResponse mockResponse = new MockResponse();
        if (response.getWebSocketSession() != null) {
            mockResponse.withWebSocketUpgrade(response.getWebSocketSession());
        } else {
            mockResponse.setBody(response.getBody());
            mockResponse.setResponseCode(response.getCode());
        }
        return mockResponse;
    }

}
