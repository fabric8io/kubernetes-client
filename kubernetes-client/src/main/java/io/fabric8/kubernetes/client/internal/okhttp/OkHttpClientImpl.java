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
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class OkHttpClientImpl implements HttpClient {
  
  static Map<String, MediaType> MEDIA_TYPES = new HashMap<>();
  
  public static final MediaType JSON = parseMediaType("application/json");
  public static final MediaType JSON_PATCH = parseMediaType("application/json-patch+json");
  public static final MediaType STRATEGIC_MERGE_JSON_PATCH = parseMediaType("application/strategic-merge-patch+json");
  public static final MediaType JSON_MERGE_PATCH = parseMediaType("application/merge-patch+json");

  public static Builder builder() {
    return new BuilderImpl(new OkHttpClient.Builder());
  }
  
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
  
  private static final class InteceptorAdapter implements Interceptor {
    private final io.fabric8.kubernetes.client.http.Interceptor interceptor;
    private final String name;

    private InteceptorAdapter(io.fabric8.kubernetes.client.http.Interceptor interceptor, String name) {
      this.interceptor = interceptor;
      this.name = name;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
      Request.Builder requestBuilder = chain.request().newBuilder();
      OkHttpRequestImpl.BuilderImpl builderImpl = new OkHttpRequestImpl.BuilderImpl(requestBuilder);
      interceptor.before(new OkHttpRequestImpl.BuilderImpl(requestBuilder), new OkHttpRequestImpl(chain.request()));
      Response response = chain.proceed(requestBuilder.build());
      if (!response.isSuccessful()) {
        boolean call = interceptor.afterFailure(builderImpl, new OkHttpResponseImpl<>(response, InputStream.class));
        if (call) {
          return chain.proceed(requestBuilder.build());
        }
      }
      return response;
    }
    
    public String getName() {
      return name;
    }
  }
  
  public static class BuilderImpl implements Builder {
    
    private boolean streaming;
    private OkHttpClient.Builder builder;

    public BuilderImpl(okhttp3.OkHttpClient.Builder newBuilder) {
      this.builder = newBuilder;
    }

    @Override
    public HttpClient build() {
      OkHttpClient client = builder.build();
      
      if (streaming) {
        // If we set the HttpLoggingInterceptor's logging level to Body (as it is by default), it does
        // not let us stream responses from the server.
        for (Interceptor i : client.networkInterceptors()) {
          if (i instanceof HttpLoggingInterceptor) {
            HttpLoggingInterceptor interceptor = (HttpLoggingInterceptor) i;
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
          }
        }
      }
      
      return new OkHttpClientImpl(client);
    }

    @Override
    public Builder readTimeout(long readTimeout, TimeUnit unit) {
      builder.readTimeout(readTimeout, unit);
      return this;
    }

    @Override
    public Builder connectTimeout(long connectTimeout, TimeUnit unit) {
      builder.connectTimeout(connectTimeout, unit);
      return this;
    }
    
    @Override
    public Builder writeTimeout(long timeout, TimeUnit timeoutUnit) {
      builder.writeTimeout(timeout, timeoutUnit);
      return this;
    }

    @Override
    public Builder forStreaming() {
      builder.cache(null);
      this.streaming = true;
      return this;
    }

    @Override
    public Builder addOrReplaceInterceptor(String name, io.fabric8.kubernetes.client.http.Interceptor interceptor) {
      List<Interceptor> interceptors = builder.interceptors();
      for (int i = 0; i < interceptors.size(); i++) {
        Interceptor exiting = interceptors.get(i);
        if (exiting instanceof InteceptorAdapter) {
          InteceptorAdapter adapter = (InteceptorAdapter)exiting;
          if (adapter.getName().equals(name)) {
            if (interceptor == null) {
              interceptors.remove(i);
            } else {
              interceptors.set(i, new InteceptorAdapter(interceptor, name));
            }
            return this;
          }
        }
      }
      if (interceptor != null) {
        builder.addInterceptor(new InteceptorAdapter(interceptor, name));
      }
      return this;
    }

    @Override
    public Builder authenticatorNone() {
      builder.authenticator(Authenticator.NONE);
      return this;
    }
    
    @Override
    public Builder sslContext(SSLContext context, TrustManager[] trustManagers) {
      X509TrustManager trustManager = null;
      if (trustManagers != null && trustManagers.length == 1) {
        trustManager = (X509TrustManager) trustManagers[0];
      }
      builder.sslSocketFactory(context.getSocketFactory(), trustManager);
      return null;
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
    return new BuilderImpl(httpClient.newBuilder());
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
