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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.builder.Function;

import java.util.ArrayDeque;
import java.util.Queue;

public class InlineWebSocketSessionBuilder<T> implements WebSocketSessionBuilder<T>,
        EventDoneable<T> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public InlineWebSocketSessionBuilder(Function<WebSocketSession, T> function) {
        this.function = function;
    }

    private Function<WebSocketSession, T> function;
    private WebSocketSession session;

    @Override
    public EventDoneable<T> open(Object... response) {
        this.session = new WebSocketSession(toWebSocketMessages(response), null, null);
        return this;
    }


    @Override
    public T failure(Object response, Exception e) {
        return function.apply(new WebSocketSession(null, toWebSocketMessage(response), e));
    }

    @Override
    public T done() {
        return function.apply(session);
    }

    @Override
    public Emitable<Timeable<EventDoneable<T>>> expect(final Object in) {
        return new Emitable<Timeable<EventDoneable<T>>>() {
            @Override
            public Timeable<EventDoneable<T>> andEmit(final Object event) {
                return new Timeable<EventDoneable<T>>() {
                    @Override
                    public EventDoneable<T> always() {
                        enqueue(in, toWebSocketMessage(event, false));
                        return InlineWebSocketSessionBuilder.this;
                    }

                    @Override
                    public EventDoneable<T> once() {
                        enqueue(in, toWebSocketMessage(event, true));
                        return InlineWebSocketSessionBuilder.this;
                    }

                    @Override
                    public EventDoneable<T> times(int times) {
                        for (int i = 0; i < times; i++) {
                            enqueue(in, toWebSocketMessage(event, true));
                        }
                        return InlineWebSocketSessionBuilder.this;
                    }
                };
            }
        };
    }

    @Override
    public Emitable<EventDoneable<T>> waitFor(final long millis) {
        return new Emitable<EventDoneable<T>>() {
            @Override
            public EventDoneable<T> andEmit(Object event) {
                session.getTimedEvents().add(toWebSocketMessage(event));
                return InlineWebSocketSessionBuilder.this;
            }
        };
    }

    private WebSocketMessage[] toWebSocketMessages(Object... content) {
        WebSocketMessage[] response = new WebSocketMessage[content.length];
        for (int i=0;i<content.length;i++) {
            response[i] = toWebSocketMessage(content[i]);
        }
        return response;
    }

    private WebSocketMessage toWebSocketMessage(Object content) {
        return toWebSocketMessage(0L, content, true);
    }

    private WebSocketMessage toWebSocketMessage(Long delay, Object content) {
        return toWebSocketMessage(delay, content, true);
    }

    private WebSocketMessage toWebSocketMessage(Object content, Boolean toBeRemoved) {
        return toWebSocketMessage(0L, content, toBeRemoved);
    }

    private WebSocketMessage toWebSocketMessage(Long delay, Object content, Boolean toBeRemoved) {
        if (content instanceof String) {
            return new WebSocketMessage(delay, (String) content, toBeRemoved);
        } else if (content instanceof WebSocketMessage) {
            return (WebSocketMessage) content;
        } else {
            try {
                return toWebSocketMessage(delay, MAPPER.writeValueAsString(content), toBeRemoved);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void enqueue(Object req, WebSocketMessage resp) {
        Queue<WebSocketMessage> queuedResponses = session.getRequestEvents().get(req);
        if (queuedResponses == null) {
            queuedResponses = new ArrayDeque<>();
            session.getRequestEvents().put(req, queuedResponses);
        }
        queuedResponses.add(resp);
    }

}
