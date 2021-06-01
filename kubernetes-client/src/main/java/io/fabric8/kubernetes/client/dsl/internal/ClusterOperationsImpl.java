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

import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ClusterOperationsImpl extends OperationSupport {
  protected final String versionEndpoint;
  public static final String KUBERNETES_VERSION_ENDPOINT = "version";

  public ClusterOperationsImpl(OkHttpClient client, Config config, String item) {
    super(new OperationContext().withOkhttpClient(client).withConfig(config));
    this.versionEndpoint = item;
  }

  public VersionInfo fetchVersion() {
    try {
      Request request = getRequest(versionEndpoint);
      Response response = handleVersionGet(request);
      assertResponseCode(request, response);

      Map<String, String> myMap = new HashMap<>();

      if (response.body() != null) {
        myMap = Serialization.jsonMapper().readValue(response.body().string(), HashMap.class);
      }
      return fetchVersionInfoFromResponse(myMap);
    } catch(Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  protected Response handleVersionGet(Request request) throws IOException {
    return client.newCall(request).execute();
  }

  protected Request getRequest(String versionEndpointToBeUsed) {
    return new Request.Builder()
      .get()
      .url(URLUtils.join(config.getMasterUrl(), versionEndpointToBeUsed))
      .build();
  }

  protected static VersionInfo fetchVersionInfoFromResponse(Map<String, String> responseAsMap) throws ParseException {
    return new VersionInfo.Builder().withBuildDate(responseAsMap.get(VersionInfo.VersionKeys.BUILD_DATE))
      .withGitCommit(responseAsMap.get(VersionInfo.VersionKeys.GIT_COMMIT))
      .withGitVersion(responseAsMap.get(VersionInfo.VersionKeys.GIT_VERSION))
      .withMajor(responseAsMap.get(VersionInfo.VersionKeys.MAJOR))
      .withMinor(responseAsMap.get(VersionInfo.VersionKeys.MINOR))
      .withGitTreeState(responseAsMap.get(VersionInfo.VersionKeys.GIT_TREE_STATE))
      .withPlatform(responseAsMap.get(VersionInfo.VersionKeys.PLATFORM))
      .withGoVersion(responseAsMap.get(VersionInfo.VersionKeys.GO_VERSION))
      .withCompiler(responseAsMap.get(VersionInfo.VersionKeys.COMPILER))
      .build();
  }
 
}
