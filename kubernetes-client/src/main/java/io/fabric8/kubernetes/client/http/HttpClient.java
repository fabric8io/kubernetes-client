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

package io.fabric8.kubernetes.client.http;

import io.fabric8.kubernetes.client.Config;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public interface HttpClient {
  
  public interface Factory {
      
    HttpClient createHttpClient(Config config);

  }
  
  public interface Builder {

    HttpClient build();

    Builder readTimeout(long readTimeout, TimeUnit unit);

    Builder connectTimeout(long connectTimeout, TimeUnit unit);
    
    Builder forStreaming();

    Builder writeTimeout(long timeout, TimeUnit timeoutUnit);
    
    Builder addOrReplaceInterceptor(String name, Interceptor interceptor);
    
    Builder authenticatorNone();
  }

  void close();
  
  Builder newBuilder();
  
  /**
   * Send a request an wait for the result
   * @param <T> return type
   * @param request
   * @param type one of InputStream, Reader, String
   * @return
   * @throws IOException
   */
  <T> HttpResponse<T> send(HttpRequest request, Class<T> type) throws IOException;
  
  /**
   * Send an async request
   * @param <T> return type
   * @param request
   * @param type one of InputStream, Reader, String
   * @return
   */
  <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, Class<T> type);

  void clearPool();
  
  WebSocket.Builder newWebSocketBuilder();
  
  HttpRequest.Builder newHttpRequestBuilder();

}
