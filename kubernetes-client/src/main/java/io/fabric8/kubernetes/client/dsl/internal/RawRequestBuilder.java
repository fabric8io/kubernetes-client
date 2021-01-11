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
package io.fabric8.kubernetes.client.dsl.internal;

import okhttp3.HttpUrl;
import okhttp3.Request;

class RawRequestBuilder implements AbstractWatchManager.RequestBuilder {
  private final HttpUrl.Builder watchUrlBuilder;
  
  public RawRequestBuilder(HttpUrl.Builder watchUrlBuilder) {
    this.watchUrlBuilder = watchUrlBuilder;
  }
  
  @Override
  public Request build(String resourceVersion) {
    if (resourceVersion != null) {
      watchUrlBuilder.removeAllQueryParameters("resourceVersion");
      watchUrlBuilder.addQueryParameter("resourceVersion", resourceVersion);
    }
    HttpUrl watchUrl = watchUrlBuilder.build();
    String origin = watchUrl.url().getProtocol() + "://" + watchUrl.url().getHost();
    if (watchUrl.url().getPort() != -1) {
      origin += ":" + watchUrl.url().getPort();
    }
    
    return new Request.Builder()
      .get()
      .url(watchUrl)
      .addHeader("Origin", origin)
      .build();
  }
}
