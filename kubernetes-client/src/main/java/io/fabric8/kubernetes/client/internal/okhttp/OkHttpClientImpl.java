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

package io.fabric8.kubernetes.client.internal.okhttp;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class OkHttpClientImpl implements HttpClient {
  
  static Map<String, MediaType> MEDIA_TYPES = new HashMap<>();
  
  public static final MediaType JSON = parseMediaType("application/json");
  public static final MediaType JSON_PATCH = parseMediaType("application/json-patch+json");
  public static final MediaType STRATEGIC_MERGE_JSON_PATCH = parseMediaType("application/strategic-merge-patch+json");
  public static final MediaType JSON_MERGE_PATCH = parseMediaType("application/merge-patch+json");

  static MediaType parseMediaType(String contentType) {
    MediaType result = MediaType.parse(contentType);
    MEDIA_TYPES.put(contentType, result);
    return result;
  }
  
  static class OkHttpResponseImpl<T> implements HttpResponse<T> {
    
    private final Response response;
    private T body;
    private Class<T> type;
    
    public OkHttpResponseImpl(Response response, Class<T> type) throws IOException {
      this.response = response;
      this.type = type;
      ResponseBody responseBody = response.body();
      if (responseBody != null) {
        if (type == null) {
          responseBody.close();
        } else if (type == String.class) {
          body = (T) responseBody.string();
        } else if (type == Reader.class) {
          body = (T) responseBody.charStream();
        } else if (type != null) {
          body = (T) responseBody.byteStream();
        }
      }
    }
    
    @Override
    public int code() {
      return response.code();
    }

    @Override
    public T body() {
      return body;
    }

    @Override
    public HttpRequest request() {
      return new OkHttpRequestImpl(response.request());
    }
    
    @Override
    public Optional<HttpResponse<T>> previousResponse() {
      Response previous = response.priorResponse() != null ? response.priorResponse() : response;
      previous = previous.networkResponse() != null ? previous.networkResponse() : previous;
      try {
        return Optional.ofNullable(previous == response ? null : new OkHttpResponseImpl<>(previous, type));
      } catch (IOException e) {
        throw new IllegalArgumentException(e);
      }
    }

    @Override
    public List<String> headers(String key) {
      return response.headers(key);
    }
    
  }
  
  private final okhttp3.OkHttpClient httpClient;
  
  public OkHttpClientImpl(OkHttpClient httpClient) {
    this.httpClient = httpClient;
  }
  
  @Override
  public void close() {
    ConnectionPool connectionPool = httpClient.connectionPool();
    Dispatcher dispatcher = httpClient.dispatcher();
    ExecutorService executorService = httpClient.dispatcher() != null ? httpClient.dispatcher().executorService() : null;

    if (dispatcher != null) {
      dispatcher.cancelAll();
    }

    if (connectionPool != null) {
      connectionPool.evictAll();
    }

    if (executorService != null) {
      executorService.shutdownNow();
    }    
  }
  
  @Override
  public <T> HttpResponse<T> send(HttpRequest request, Class<T> type) throws IOException {
    return new OkHttpResponseImpl<>(httpClient.newCall(((OkHttpRequestImpl)request).getRequest()).execute(), type);
  }
  
  @Override
  public void clearPool() {
    if (httpClient.connectionPool() != null) {
      httpClient.connectionPool().evictAll();
    }
  }
  
  @Override
  public Builder newBuilder() {
    return new OkHttpClientBuilderImpl(httpClient.newBuilder());
  }
  
  @Override
  public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, Class<T> type) {
    CompletableFuture<HttpResponse<T>> future = new CompletableFuture<>();
    Call call = httpClient.newCall(((OkHttpRequestImpl)request).getRequest());
    call.enqueue(new Callback() {
      
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        future.complete(new OkHttpResponseImpl<>(response, type));
      }
      
      @Override
      public void onFailure(Call call, IOException e) {
        future.completeExceptionally(e);
      }
    });
    future.whenComplete((r, t) -> call.cancel());
    return future;
  }
  
  @Override
  public io.fabric8.kubernetes.client.http.WebSocket.Builder newWebSocketBuilder() {
    return new OkHttpWebSocketImpl.BuilderImpl(this.httpClient);
  }
  
  public okhttp3.OkHttpClient getOkHttpClient() {
    return httpClient;
  }
  
  @Override
  public HttpRequest.Builder newHttpRequestBuilder() {
    return new OkHttpRequestImpl.BuilderImpl();
  }
  
}
