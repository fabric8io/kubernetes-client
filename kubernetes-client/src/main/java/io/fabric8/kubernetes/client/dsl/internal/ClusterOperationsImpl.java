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
import io.fabric8.kubernetes.client.Version;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.api.model.ClusterVersionList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ClusterOperationsImpl extends OperationSupport {
  private String versionEndpoint;
  public static final String KUBERNETES_VERSION_ENDPOINT = "version";
  public static final String OPENSHIFT_VERSION_ENDPOINT = "version/openshift";
  public static final String OPENSHIFT4_VERSION_ENDPOINT = "apis/config.openshift.io/v1/clusterversions";
  public static final ObjectMapper objectMapper = new ObjectMapper();

  public ClusterOperationsImpl(OkHttpClient client, Config config, String item) {
    super(new OperationContext().withOkhttpClient(client).withConfig(config));
    this.versionEndpoint = item;
  }

  public VersionInfo fetchVersion() {
    try {
      Response response = handleVersionGet(versionEndpoint);
      // Handle Openshift 4 version case
      if (HttpURLConnection.HTTP_NOT_FOUND == response.code() && versionEndpoint.equals(OPENSHIFT_VERSION_ENDPOINT)) {
        response.close();
        return fetchOpenshift4Version();
      }

      Map<String, String> myMap = objectMapper.readValue(response.body().string(), HashMap.class);
      return fetchVersionInfoFromResponse(myMap);
    } catch(Exception e) {
      KubernetesClientException.launderThrowable(e);
    }
    return null;
  }

  private Response handleVersionGet(String versionEndpointToBeUsed) throws IOException {
    Request.Builder requestBuilder = new Request.Builder()
      .get()
      .url(URLUtils.join(config.getMasterUrl(), versionEndpointToBeUsed));
    return client.newCall(requestBuilder.build()).execute();
  }

  private VersionInfo fetchOpenshift4Version() throws IOException, ParseException {
    Response response = handleVersionGet(OPENSHIFT4_VERSION_ENDPOINT);
    if (response.isSuccessful() && response.body() != null) {
      ClusterVersionList clusterVersionList = objectMapper.readValue(response.body().string(), ClusterVersionList.class);
      if (!clusterVersionList.getItems().isEmpty()) {
        return VersionInfo.parseVersionInfoFromClusterVersion(clusterVersionList.getItems().get(0));
      }
    }
    return null;
  }

  private VersionInfo fetchVersionInfoFromResponse(Map<String, String> responseAsMap) throws ParseException {
    return new VersionInfo.Builder().withBuildDate(responseAsMap.get(VersionInfo.VERSION_KEYS.BUILD_DATE))
      .withGitCommit(responseAsMap.get(VersionInfo.VERSION_KEYS.GIT_COMMIT))
      .withGitVersion(responseAsMap.get(VersionInfo.VERSION_KEYS.GIT_VERSION))
      .withMajor(responseAsMap.get(VersionInfo.VERSION_KEYS.MAJOR))
      .withMinor(responseAsMap.get(VersionInfo.VERSION_KEYS.MINOR))
      .withGitTreeState(responseAsMap.get(VersionInfo.VERSION_KEYS.GIT_TREE_STATE))
      .withPlatform(responseAsMap.get(VersionInfo.VERSION_KEYS.PLATFORM))
      .withGoVersion(responseAsMap.get(VersionInfo.VERSION_KEYS.GO_VERSION))
      .withCompiler(responseAsMap.get(VersionInfo.VERSION_KEYS.COMPILER))
      .build();
  }
}
