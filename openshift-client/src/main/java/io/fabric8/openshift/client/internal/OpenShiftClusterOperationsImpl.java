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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.internal.ClusterOperationsImpl;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.api.model.ClusterVersion;
import io.fabric8.openshift.api.model.ClusterVersionList;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;
import java.text.ParseException;

public class OpenShiftClusterOperationsImpl extends ClusterOperationsImpl {
  public static final String OPENSHIFT_VERSION_ENDPOINT = "version/openshift";
  public static final String OPENSHIFT4_VERSION_ENDPOINT = "apis/config.openshift.io/v1/clusterversions";

  public OpenShiftClusterOperationsImpl(OkHttpClient client, Config config, String item) {
    super(client, config, item);
  }

  @Override
  public VersionInfo fetchVersion() {
    try {
      // Try to get version using OpenShift 3 URLs.
      // Method will throw Exception if it failed
      return super.fetchVersion();
    } catch (KubernetesClientException | NullPointerException exception) {
      try {
        // Handle Openshift 4 version case
        return fetchOpenshift4Version();
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
  }

  private VersionInfo fetchOpenshift4Version() throws IOException, ParseException {
    Response response = handleVersionGet(getRequest(OPENSHIFT4_VERSION_ENDPOINT));
    if (response.isSuccessful() && response.body() != null) {
      ClusterVersionList clusterVersionList = Serialization.jsonMapper().readValue(response.body().string(), ClusterVersionList.class);
      if (!clusterVersionList.getItems().isEmpty()) {
        return parseVersionInfoFromClusterVersion(clusterVersionList.getItems().get(0));
      }
    }
    return null;
  }

  private static VersionInfo parseVersionInfoFromClusterVersion(ClusterVersion clusterVersion) throws ParseException {
    String[] versionParts = clusterVersion.getStatus().getDesired().getVersion().split("\\.");
    VersionInfo.Builder versionInfoBuilder = new VersionInfo.Builder();
    if (versionParts.length > 2) {
      versionInfoBuilder.withMajor(versionParts[0]);
      versionInfoBuilder.withMinor(versionParts[1] + "." + versionParts[2]);
    }
    versionInfoBuilder.withBuildDate(clusterVersion.getMetadata().getCreationTimestamp());
    return versionInfoBuilder.build();
  }
}
