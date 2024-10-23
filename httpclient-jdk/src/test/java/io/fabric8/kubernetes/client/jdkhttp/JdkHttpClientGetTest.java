/*
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
package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.AbstractHttpGetTest;
import io.fabric8.kubernetes.client.http.HttpClient;

import java.io.IOException;

@SuppressWarnings("java:S2187")
public class JdkHttpClientGetTest extends AbstractHttpGetTest {
  @Override
  protected HttpClient.Factory getHttpClientFactory() {
    return new JdkHttpClientFactory() {
      @Override
      protected void additionalConfig(java.net.http.HttpClient.Builder builder) {
        // Otherwise HTTP/2 is used by default which breaks the test that checks the request line
        builder.version(java.net.http.HttpClient.Version.HTTP_1_1);
      }
    };
  }

  @Override
  protected Class<? extends Exception> getConnectionFailedExceptionType() {
    return IOException.class;
  }
}
