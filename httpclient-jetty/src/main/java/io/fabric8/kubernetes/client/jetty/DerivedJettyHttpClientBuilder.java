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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.Interceptor;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public abstract class DerivedJettyHttpClientBuilder<T extends HttpClient.DerivedClientBuilder>
    implements HttpClient.DerivedClientBuilder {

  final JettyHttpClientFactory factory;
  Duration readTimeout = Duration.ZERO;
  Duration writeTimeout = Duration.ZERO;
  final Map<String, Interceptor> interceptors;

  DerivedJettyHttpClientBuilder(JettyHttpClientFactory factory) {
    this.factory = factory;
    interceptors = new LinkedHashMap<>();
  }

  @Override
  public final T readTimeout(long readTimeout, TimeUnit unit) {
    this.readTimeout = Duration.ofNanos(unit.toNanos(readTimeout));
    return (T) this;
  }

  @Override
  public T writeTimeout(long writeTimeout, TimeUnit unit) {
    this.writeTimeout = Duration.ofNanos(unit.toNanos(writeTimeout));
    return (T) this;
  }

  @Override
  public T forStreaming() {
    // NO OP
    return (T) this;
  }

  @Override
  public T authenticatorNone() {
    // NO OP
    return (T) this;
  }

  @Override
  public T addOrReplaceInterceptor(String name, Interceptor interceptor) {
    interceptors.put(name, interceptor);
    return (T) this;
  }
}
