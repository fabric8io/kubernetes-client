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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class ClusterOperationsImpl extends OperationSupport {
  private String versionEndpoint;

  public ClusterOperationsImpl(OkHttpClient client, Config config, String item) {
    super(new OperationContext().withOkhttpClient(client).withConfig(config));
    this.versionEndpoint = item;
  }

  public VersionInfo fetchVersion() {
    try {
      Request.Builder requestBuilder = new Request.Builder()
        .get()
        .url(URLUtils.join(config.getMasterUrl(), versionEndpoint));
      Response response = client.newCall(requestBuilder.build()).execute();
      ObjectMapper objectMapper = new ObjectMapper();
      Map<String, String> myMap = objectMapper.readValue(response.body().string(), HashMap.class);
      return new VersionInfo(myMap);
    } catch(Exception e) {
      KubernetesClientException.launderThrowable(e);
    }
    return null;
  }
}
