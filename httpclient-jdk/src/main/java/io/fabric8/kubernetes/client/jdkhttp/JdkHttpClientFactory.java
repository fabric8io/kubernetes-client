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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpClient.Builder;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;

public class JdkHttpClientFactory implements HttpClient.Factory {

  @Override
  public HttpClient createHttpClient(Config config) {
    JdkHttpClientBuilderImpl builderWrapper = new JdkHttpClientBuilderImpl(this);

    HttpClientUtils.applyCommonConfiguration(config, builderWrapper, this);

    return builderWrapper.build();
  }

  @Override
  public Builder newBuilder() {
    return new JdkHttpClientBuilderImpl(this);
  }

  protected void additionalConfig(java.net.http.HttpClient.Builder builder) {

  }

  protected java.net.http.HttpClient.Builder createNewHttpClientBuilder() {
    return java.net.http.HttpClient.newBuilder();
  }

  /**
   * Cleanup hook called by {@link HttpClient#close()}
   * @param jdkHttpClientImpl
   */
  protected void closeHttpClient(JdkHttpClientImpl jdkHttpClientImpl) {

  }

}
