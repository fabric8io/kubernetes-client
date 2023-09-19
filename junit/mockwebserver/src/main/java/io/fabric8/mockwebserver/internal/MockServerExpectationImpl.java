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

package io.fabric8.mockwebserver.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.MockServerException;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.DelayPathable;
import io.fabric8.mockwebserver.dsl.Function;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.dsl.MockServerExpectation;
import io.fabric8.mockwebserver.dsl.Pathable;
import io.fabric8.mockwebserver.dsl.ReturnOrWebsocketable;
import io.fabric8.mockwebserver.dsl.TimesOnceableOrHttpHeaderable;
import io.fabric8.mockwebserver.dsl.WebSocketSessionBuilder;
import io.fabric8.mockwebserver.utils.BodyProvider;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import io.fabric8.mockwebserver.utils.ResponseProviders;
import okhttp3.Headers;
import okhttp3.mockwebserver.RecordedRequest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockServerExpectationImpl implements MockServerExpectation {

  private final Context context;
  private final HttpMethod method;
  private final String path;
  private final ResponseProvider<String> bodyProvider;
  private final ResponseProvider<List<String>> chunksProvider;
  private final long delay;
  private final TimeUnit delayUnit;
  private final int times;

  private final Map<ServerRequest, Queue<ServerResponse>> responses;

  public MockServerExpectationImpl(Map<ServerRequest, Queue<ServerResponse>> responses, Context context) {
    this(context, HttpMethod.ANY, null, 200, null, null, 0, TimeUnit.SECONDS, 1, responses);
  }

  public MockServerExpectationImpl(Context context, HttpMethod method, String path, int statusCode, String body,
      String[] chunks, long delay, TimeUnit delayUnit, int times, Map<ServerRequest, Queue<ServerResponse>> responses) {
    this(context, method, path, ResponseProviders.of(statusCode, body), ResponseProviders.ofAll(statusCode, chunks), delay,
        delayUnit, times, responses);
  }

  public MockServerExpectationImpl(Context context, HttpMethod method, String path, ResponseProvider<String> bodyProvider,
      ResponseProvider<List<String>> chunksProvider, long delay, TimeUnit delayUnit, int times,
      Map<ServerRequest, Queue<ServerResponse>> responses) {
    this.context = context;
    this.method = method;
    this.path = path;
    this.bodyProvider = bodyProvider;
    this.chunksProvider = chunksProvider;
    this.delay = delay;
    this.delayUnit = delayUnit;
    this.times = times;
    this.responses = responses;
  }

  @Override
  public DelayPathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> any() {
    return new MockServerExpectationImpl(context, HttpMethod.ANY, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public DelayPathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> post() {
    return new MockServerExpectationImpl(context, HttpMethod.POST, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public DelayPathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> get() {
    return new MockServerExpectationImpl(context, HttpMethod.GET, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public DelayPathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> put() {
    return new MockServerExpectationImpl(context, HttpMethod.PUT, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public DelayPathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> delete() {
    return new MockServerExpectationImpl(context, HttpMethod.DELETE, path, bodyProvider, chunksProvider, delay, delayUnit,
        times, responses);
  }

  @Override
  public DelayPathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> patch() {
    return new MockServerExpectationImpl(context, HttpMethod.PATCH, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>> withPath(String path) {
    return new MockServerExpectationImpl(context, method, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> andReturn(int statusCode, Object content) {
    return new MockServerExpectationImpl(context, method, path, ResponseProviders.of(statusCode, toString(content)),
        chunksProvider, delay, delayUnit, times, responses);
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> andReply(int statusCode, BodyProvider<Object> content) {
    return andReply(ResponseProviders.of(statusCode, content));
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> andReply(ResponseProvider<Object> content) {
    return new MockServerExpectationImpl(context, method, path, toString(content), chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> andReturnChunked(int statusCode, Object... contents) {
    return new MockServerExpectationImpl(context, method, path, bodyProvider,
        ResponseProviders.of(statusCode, toString(contents)), delay, delayUnit, times, responses);
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> andReplyChunked(int statusCode, BodyProvider<List<Object>> contents) {
    return andReplyChunked(ResponseProviders.of(statusCode, contents));
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> andReplyChunked(ResponseProvider<List<Object>> contents) {
    return new MockServerExpectationImpl(context, method, path, bodyProvider, listToString(contents), delay, delayUnit, times,
        responses);
  }

  @Override
  public Void always() {
    enqueue(new SimpleRequest(method, path), createResponse(true, delay, delayUnit));
    return null;//Void
  }

  @Override
  public Void once() {
    enqueue(new SimpleRequest(method, path), createResponse(false, delay, delayUnit));
    return null;//Void
  }

  @Override
  public Void times(int times) {
    for (int i = 0; i < times; i++) {
      once();
    }
    return null;//Void
  }

  @Override
  public Pathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> delay(long delay, TimeUnit delayUnit) {
    return new MockServerExpectationImpl(context, method, path, bodyProvider, chunksProvider, delay, delayUnit, times,
        responses);
  }

  @Override
  public Pathable<ReturnOrWebsocketable<TimesOnceableOrHttpHeaderable<Void>>> delay(long delayInMilliseconds) {
    return new MockServerExpectationImpl(context, method, path, bodyProvider, chunksProvider, delayInMilliseconds,
        TimeUnit.MILLISECONDS, times, responses);
  }

  @Override
  public WebSocketSessionBuilder<TimesOnceableOrHttpHeaderable<Void>> andUpgradeToWebSocket() {
    return new InlineWebSocketSessionBuilder<>(context, new WebSocketSessionConverter(this));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public WebSocketSessionBuilder<TimesOnceableOrHttpHeaderable<Void>> andUpgradeToWebSocket(ScheduledExecutorService executor) {
    return new InlineWebSocketSessionBuilder<>(context, new WebSocketSessionConverter(this));
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> withHeader(String header) {
    bodyProvider.setHeaders(bodyProvider.getHeaders().newBuilder().add(header).build());
    return new MockServerExpectationImpl(context, method, path, bodyProvider, chunksProvider, delay, TimeUnit.MILLISECONDS,
        times, responses);
  }

  @Override
  public TimesOnceableOrHttpHeaderable<Void> withHeader(String name, String value) {
    bodyProvider.setHeaders(bodyProvider.getHeaders().newBuilder().add(name, value).build());
    return new MockServerExpectationImpl(context, method, path, bodyProvider, chunksProvider, delay, TimeUnit.MILLISECONDS,
        times, responses);
  }

  private void enqueue(ServerRequest req, ServerResponse resp) {
    responses.computeIfAbsent(req, k -> new ArrayDeque<>()).add(resp);
  }

  private ServerResponse createResponse(boolean repeatable, long delay, TimeUnit delayUnit) {
    if (chunksProvider != null) {
      return new ChunkedResponse(repeatable, delay, delayUnit, chunksProvider);
    } else {
      return new SimpleResponse(repeatable, bodyProvider, null, delay, delayUnit);
    }
  }

  private ResponseProvider<String> toString(final ResponseProvider<Object> provider) {
    return new ResponseProvider<String>() {
      @Override
      public String getBody(RecordedRequest request) {
        Object object = provider.getBody(request);
        return MockServerExpectationImpl.this.toString(object);
      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        return provider.getStatusCode(request);
      }

      @Override
      public Headers getHeaders() {
        return provider.getHeaders();
      }

      @Override
      public void setHeaders(Headers headers) {
        provider.setHeaders(headers);
      }
    };
  }

  private ResponseProvider<List<String>> listToString(final ResponseProvider<List<Object>> provider) {
    return new ResponseProvider<List<String>>() {
      @Override
      public List<String> getBody(RecordedRequest request) {
        List<Object> objects = provider.getBody(request);
        List<String> strings = new ArrayList<>(objects.size());
        for (Object o : objects) {
          strings.add(MockServerExpectationImpl.this.toString(o));
        }
        return strings;
      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        return provider.getStatusCode(request);
      }

      @Override
      public Headers getHeaders() {
        return provider.getHeaders();
      }

      @Override
      public void setHeaders(Headers headers) {
        provider.setHeaders(headers);
      }
    };
  }

  private String toString(Object object) {
    if (object instanceof String) {
      return (String) object;
    } else {
      try {
        return context.getMapper().writeValueAsString(object);
      } catch (JsonProcessingException e) {
        throw new MockServerException("Exception when mapping Object to String", e);
      }
    }
  }

  private List<String> toString(Object[] object) {
    return Stream.of(object)
        .map(this::toString)
        .collect(Collectors.toList());
  }

  private static final class WebSocketSessionConverter
      implements Function<WebSocketSession, TimesOnceableOrHttpHeaderable<Void>> {

    private final MockServerExpectationImpl mse;

    public WebSocketSessionConverter(MockServerExpectationImpl mse) {
      this.mse = mse;
    }

    @Override
    public TimesOnceableOrHttpHeaderable<Void> apply(final WebSocketSession webSocketSession) {
      final Map<String, String> headers = new HashMap<>();
      headers.put("Upgrade", "websocket");
      headers.put("Connection", "Upgrade");

      return new TimesOnceableOrHttpHeaderable<Void>() {
        @Override
        public Void always() {
          mse.enqueue(new SimpleRequest(mse.method, mse.path),
              new SimpleResponse(true, ResponseProviders.of(101, "", headers), webSocketSession));
          return null;//Void
        }

        @Override
        public Void once() {
          mse.enqueue(new SimpleRequest(mse.method, mse.path),
              new SimpleResponse(false, ResponseProviders.of(101, "", headers), webSocketSession));
          return null;//Void
        }

        @Override
        public Void times(int times) {
          for (int i = 0; i < times; i++) {
            once();
          }
          return null;//Void
        }

        @Override
        public TimesOnceableOrHttpHeaderable<Void> withHeader(String header) {
          headers.put(header, "");
          return this;//Void
        }

        @Override
        public TimesOnceableOrHttpHeaderable<Void> withHeader(String name, String value) {
          headers.put(name, value);
          return this;//Void
        }
      };
    }
  }
}
