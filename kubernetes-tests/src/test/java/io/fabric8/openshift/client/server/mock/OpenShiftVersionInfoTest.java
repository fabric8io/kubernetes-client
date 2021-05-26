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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableOpenShiftMockClient
class OpenShiftVersionInfoTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testClusterVersioningOpenshift3() throws ParseException {
    // Given
    server.expect().withPath("/version/openshift").andReturn(200, "{\"major\":\"3\",\"minor\":\"11+\"," +
      "\"gitVersion\":\"v3.11.154\",\"gitCommit\":\"7a097ad820\",\"gitTreeState\":\"\"," +
      "\"buildDate\":\"2019-10-31T21:06:55Z\",\"goVersion\":\"\",\"compiler\":\"\"," +
      "\"platform\":\"\"}").always();

    assertEquals("v3.11.154", client.getVersion().getGitVersion());
    assertEquals("7a097ad820", client.getVersion().getGitCommit());
    assertEquals("3", client.getVersion().getMajor());
    assertEquals("11+", client.getVersion().getMinor());
    assertEquals(119, client.getVersion().getBuildDate().getYear());
    assertEquals(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse("2019-10-31T21:06:55Z").getTime(), client.getVersion().getBuildDate().getTime());
  }

  @Test
  void testClusterVersioningOpenshift4() {
    server.expect().get().withPath("/openshift/version").andReturn(404, "").always();

    server.expect().get().withPath("/apis/config.openshift.io/v1/clusterversions").andReturn(200, "{" +
      "  \"apiVersion\": \"config.openshift.io/v1\"," +
      "  \"items\": [" +
      "    {" +
      "      \"apiVersion\": \"config.openshift.io/v1\"," +
      "      \"kind\": \"ClusterVersion\"," +
      "      \"metadata\": {" +
      "        \"creationTimestamp\": \"2020-01-30T04:05:33Z\"," +
      "        \"generation\": 2," +
      "        \"name\": \"version\"," +
      "        \"resourceVersion\": \"44758\"," +
      "        \"selfLink\": \"/apis/config.openshift.io/v1/clusterversions/version\"," +
      "        \"uid\": \"c301755d-4315-11ea-9872-52540022f9dd\"" +
      "      }," +
      "      \"spec\": {" +
      "        \"channel\": \"stable-4.2\"," +
      "        \"clusterID\": \"c92835a5-395d-4448-840d-6a223f9a02c7\"," +
      "        \"upstream\": \"https://api.openshift.com/api/upgrades_info/v1/graph\"" +
      "      }," +
      "      \"status\": {" +
      "        \"availableUpdates\": [" +
      "          {" +
      "            \"force\": false," +
      "            \"image\": \"quay.io/openshift-release-dev/ocp-release@sha256:e5a6e348721c38a78d9299284fbb5c60fb340135a86b674b038500bf190ad514\"," +
      "            \"version\": \"4.2.16\"" +
      "          }" +
      "        ]," +
      "        \"conditions\": [" +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:05:35Z\"," +
      "            \"status\": \"False\"," +
      "            \"type\": \"Available\"" +
      "          }," +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:31:38Z\"," +
      "            \"message\": \"Cluster operator monitoring is still updating\"," +
      "            \"reason\": \"ClusterOperatorNotAvailable\"," +
      "            \"status\": \"True\"," +
      "            \"type\": \"Failing\"" +
      "          }," +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:05:35Z\"," +
      "            \"message\": \"Unable to apply 4.2.14: the cluster operator monitoring has not yet successfully rolled out\"," +
      "            \"reason\": \"ClusterOperatorNotAvailable\"," +
      "            \"status\": \"True\"," +
      "            \"type\": \"Progressing\"" +
      "          }," +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:05:36Z\"," +
      "            \"status\": \"True\"," +
      "            \"type\": \"RetrievedUpdates\"" +
      "          }" +
      "        ]," +
      "        \"desired\": {" +
      "          \"force\": false," +
      "          \"image\": \"quay.io/openshift-release-dev/ocp-release@sha256:3fabe939da31f9a31f509251b9f73d321e367aba2d09ff392c2f452f6433a95a\"," +
      "          \"version\": \"4.2.14\"" +
      "        }," +
      "        \"history\": [" +
      "          {" +
      "            \"completionTime\": null," +
      "            \"image\": \"quay.io/openshift-release-dev/ocp-release@sha256:3fabe939da31f9a31f509251b9f73d321e367aba2d09ff392c2f452f6433a95a\"," +
      "            \"startedTime\": \"2020-01-30T04:05:35Z\"," +
      "            \"state\": \"Partial\"," +
      "            \"verified\": false," +
      "            \"version\": \"4.2.14\"" +
      "          }" +
      "        ]," +
      "        \"observedGeneration\": 1," +
      "        \"versionHash\": \"kEuk9MZ8sK4=\"" +
      "      }" +
      "    }" +
      "  ]," +
      "  \"kind\": \"ClusterVersionList\"," +
      "  \"metadata\": {" +
      "    \"continue\": \"\"," +
      "    \"resourceVersion\": \"62446\"," +
      "    \"selfLink\": \"/apis/config.openshift.io/v1/clusterversions\"" +
      "  }" +
      "}").once();


    VersionInfo versionInfo = client.getVersion();
    assertEquals("4", versionInfo.getMajor());
    assertEquals("2.14", versionInfo.getMinor());
  }

  @Test
  void testClusterVersioningOpenshift4Unreleased() {
    server.expect().get().withPath("/openshift/version").andReturn(404, "").always();

    server.expect().get().withPath("/apis/config.openshift.io/v1/clusterversions").andReturn(200, "{" +
      "  \"apiVersion\": \"config.openshift.io/v1\"," +
      "  \"items\": [" +
      "    {" +
      "      \"apiVersion\": \"config.openshift.io/v1\"," +
      "      \"kind\": \"ClusterVersion\"," +
      "      \"metadata\": {" +
      "        \"creationTimestamp\": \"2020-01-30T04:05:33Z\"," +
      "        \"generation\": 2," +
      "        \"name\": \"version\"," +
      "        \"resourceVersion\": \"44758\"," +
      "        \"selfLink\": \"/apis/config.openshift.io/v1/clusterversions/version\"," +
      "        \"uid\": \"c301755d-4315-11ea-9872-52540022f9dd\"" +
      "      }," +
      "      \"spec\": {" +
      "        \"channel\": \"stable-4.2\"," +
      "        \"clusterID\": \"c92835a5-395d-4448-840d-6a223f9a02c7\"," +
      "        \"upstream\": \"https://api.openshift.com/api/upgrades_info/v1/graph\"" +
      "      }," +
      "      \"status\": {" +
      "        \"availableUpdates\": [" +
      "          {" +
      "            \"force\": false," +
      "            \"image\": \"quay.io/openshift-release-dev/ocp-release@sha256:e5a6e348721c38a78d9299284fbb5c60fb340135a86b674b038500bf190ad514\"," +
      "            \"version\": \"4.2.16\"" +
      "          }" +
      "        ]," +
      "        \"conditions\": [" +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:05:35Z\"," +
      "            \"status\": \"False\"," +
      "            \"type\": \"Available\"" +
      "          }," +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:31:38Z\"," +
      "            \"message\": \"Cluster operator monitoring is still updating\"," +
      "            \"reason\": \"ClusterOperatorNotAvailable\"," +
      "            \"status\": \"True\"," +
      "            \"type\": \"Failing\"" +
      "          }," +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:05:35Z\"," +
      "            \"message\": \"Unable to apply 4.2.14: the cluster operator monitoring has not yet successfully rolled out\"," +
      "            \"reason\": \"ClusterOperatorNotAvailable\"," +
      "            \"status\": \"True\"," +
      "            \"type\": \"Progressing\"" +
      "          }," +
      "          {" +
      "            \"lastTransitionTime\": \"2020-01-30T04:05:36Z\"," +
      "            \"status\": \"True\"," +
      "            \"type\": \"RetrievedUpdates\"" +
      "          }" +
      "        ]," +
      "        \"desired\": {" +
      "          \"force\": false," +
      "          \"image\": \"quay.io/openshift-release-dev/ocp-release@sha256:3fabe939da31f9a31f509251b9f73d321e367aba2d09ff392c2f452f6433a95a\"," +
      "          \"version\": \"4.8.0-0.nightly-2021-05-26-071911\"" +
      "        }," +
      "        \"history\": [" +
      "          {" +
      "            \"completionTime\": null," +
      "            \"image\": \"quay.io/openshift-release-dev/ocp-release@sha256:3fabe939da31f9a31f509251b9f73d321e367aba2d09ff392c2f452f6433a95a\"," +
      "            \"startedTime\": \"2020-01-30T04:05:35Z\"," +
      "            \"state\": \"Partial\"," +
      "            \"verified\": false," +
      "            \"version\": \"4.8.0-0.nightly-2021-05-26-071911\"" +
      "          }" +
      "        ]," +
      "        \"observedGeneration\": 1," +
      "        \"versionHash\": \"kEuk9MZ8sK4=\"" +
      "      }" +
      "    }" +
      "  ]," +
      "  \"kind\": \"ClusterVersionList\"," +
      "  \"metadata\": {" +
      "    \"continue\": \"\"," +
      "    \"resourceVersion\": \"62446\"," +
      "    \"selfLink\": \"/apis/config.openshift.io/v1/clusterversions\"" +
      "  }" +
      "}").once();


    VersionInfo versionInfo = client.getVersion();
    assertEquals("4", versionInfo.getMajor());
    assertEquals("8.0-0", versionInfo.getMinor());
  }
}
