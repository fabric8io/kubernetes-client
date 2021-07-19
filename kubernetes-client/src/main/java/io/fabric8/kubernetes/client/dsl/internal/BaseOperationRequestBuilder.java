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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.Request;

class BaseOperationRequestBuilder<T extends HasMetadata, L extends KubernetesResourceList<T>> {
  private final URL requestUrl;
  private final BaseOperation<T, L, ?> baseOperation;
  private final ListOptions listOptions;

  public BaseOperationRequestBuilder(BaseOperation<T, L, ?> baseOperation, ListOptions listOptions) throws MalformedURLException {
    this.baseOperation = baseOperation;
    this.requestUrl = baseOperation.getNamespacedUrl();
    this.listOptions = listOptions;
  }
  
  public BaseOperation<T, L, ?> getBaseOperation() {
    return baseOperation;
  }
  
  public Request build(final String resourceVersion) {
    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(requestUrl).newBuilder();

    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (Utils.isNotNullOrEmpty(labelQueryParam)) {
      httpUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
    }

    String fieldQueryString = baseOperation.getFieldQueryParam();
    String name = baseOperation.getName();

    if (name != null && name.length() > 0) {
      if (fieldQueryString.length() > 0) {
        fieldQueryString += ",";
      }
      fieldQueryString += "metadata.name=" + name;
    }
    if (Utils.isNotNullOrEmpty(fieldQueryString)) {
      httpUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
    }

    listOptions.setResourceVersion(resourceVersion);
    HttpClientUtils.appendListOptionParams(httpUrlBuilder, listOptions);

    String origin = requestUrl.getProtocol() + "://" + requestUrl.getHost();
    if (requestUrl.getPort() != -1) {
      origin += ":" + requestUrl.getPort();
    }

    Request.Builder requestBuilder = new Request.Builder()
      .get()
      .url(httpUrlBuilder.build())
      .addHeader("Origin", origin);

    Config config = baseOperation.getConfig();
    if (Objects.nonNull(config)) {
      Map<String, String> customHeaders = config.getCustomHeaders();
      if (Objects.nonNull(customHeaders) && !customHeaders.isEmpty()) {
        for (String key : customHeaders.keySet()) {
          requestBuilder.addHeader(key, customHeaders.get(key));
        }
      }
    }

    return requestBuilder.build();
  }
}
