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
import io.fabric8.openshift.api.model.config.v1.ClusterVersionBuilder;
import io.fabric8.openshift.api.model.config.v1.ClusterVersionList;
import io.fabric8.openshift.api.model.config.v1.ClusterVersionListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
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
    assertEquals(new SimpleDateFormat(VersionInfo.VersionKeys.BUILD_DATE_FORMAT).parse("2019-10-31T21:06:55Z").getTime(),
        client.getVersion().getBuildDate().getTime());
  }

  @Test
  void testClusterVersioningOpenshift4() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/clusterversions")
        .andReturn(HttpURLConnection.HTTP_OK, createClusterVersionListWithVersion("4.2.14"))
        .once();

    // When
    VersionInfo versionInfo = client.getVersion();

    // Then
    assertEquals("4", versionInfo.getMajor());
    assertEquals("2.14", versionInfo.getMinor());
  }

  @Test
  void testClusterVersioningOpenshift4Unreleased() {
    // When
    server.expect().get().withPath("/apis/config.openshift.io/v1/clusterversions")
        .andReturn(HttpURLConnection.HTTP_OK, createClusterVersionListWithVersion("4.8.0-0.nightly-2021-05-26-071911"))
        .once();

    // When
    VersionInfo versionInfo = client.getVersion();

    // Then
    assertEquals("4", versionInfo.getMajor());
    assertEquals("8.0-0", versionInfo.getMinor());
  }

  private ClusterVersionList createClusterVersionListWithVersion(String openShiftVersion) {
    return new ClusterVersionListBuilder()
        .addToItems(new ClusterVersionBuilder()
            .withNewMetadata().withName("version").endMetadata()
            .withNewStatus()
            .withNewDesired()
            .withVersion(openShiftVersion)
            .endDesired()
            .endStatus()
            .build())
        .build();
  }

}
