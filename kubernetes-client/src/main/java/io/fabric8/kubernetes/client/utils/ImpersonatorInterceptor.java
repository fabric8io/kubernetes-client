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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;

public class ImpersonatorInterceptor implements Interceptor {
  private final Config config;
  public ImpersonatorInterceptor(Config config) {
    this.config = config;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    RequestConfig requestConfig = config.getRequestConfig();
    if (isNotNullOrEmpty(requestConfig.getImpersonateUsername())) {
      Request.Builder requestBuilder = chain.request().newBuilder();

      requestBuilder.addHeader("Impersonate-User", requestConfig.getImpersonateUsername());

      if (isNotNullOrEmpty(requestConfig.getImpersonateGroup())) {
        requestBuilder.addHeader("Impersonate-Group", requestConfig.getImpersonateGroup());
      }

      if (isNotNullOrEmpty(requestConfig.getImpersonateExtras())) {
        for (Map.Entry<String, String> entry : requestConfig.getImpersonateExtras().entrySet()) {
          requestBuilder.addHeader("Impersonate-Extra-" + entry.getKey(), entry.getValue());
        }
      }

      request = requestBuilder.build();
    }
    return chain.proceed(request);
  }
}
