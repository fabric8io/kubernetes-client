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
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class ClusterOperationsImpl extends OperationSupport {
  private String versionEndpoint;

  public ClusterOperationsImpl(OkHttpClient client, Config config, String item) {
    super(client, config, null, null, null, null, null);
    this.versionEndpoint = item;
  }

  public VersionInfo fetchVersion() {
    ResponseBody body = null;
    try {
      Request.Builder requestBuilder = new Request.Builder()
        .get()
        .url(config.getMasterUrl() + versionEndpoint);
      Response response = client.newCall(requestBuilder.build()).execute();      
      ObjectMapper objectMapper = new ObjectMapper();
      body = response.body();
      Map<String, String> myMap = objectMapper.readValue(body.string(), HashMap.class);
      return new VersionInfo(myMap);
    } catch(Exception e) {
      KubernetesClientException.launderThrowable(e);
    } finally {
      if (body != null) {
        body.close();
      }
    }
    return null;
  }
}
