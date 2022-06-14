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

import io.fabric8.openshift.api.model.config.v1.FeatureGate;
import io.fabric8.openshift.api.model.config.v1.FeatureGateBuilder;
import io.fabric8.openshift.api.model.config.v1.FeatureGateList;
import io.fabric8.openshift.api.model.config.v1.FeatureGateListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class FeatureGateTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    FeatureGate featureGate = getFeatureGate();
    server.expect().post()
        .withPath("/apis/config.openshift.io/v1/featuregates")
        .andReturn(HttpURLConnection.HTTP_OK, featureGate)
        .once();

    // When
    featureGate = client.config().featureGates().create(featureGate);

    // Then
    assertNotNull(featureGate);
    assertEquals("foo", featureGate.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/config.openshift.io/v1/featuregates/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getFeatureGate())
        .once();

    // When
    FeatureGate f = client.config().featureGates().withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/config.openshift.io/v1/featuregates")
        .andReturn(HttpURLConnection.HTTP_OK, new FeatureGateListBuilder().withItems(getFeatureGate()).build())
        .once();

    // When
    FeatureGateList fgList = client.config().featureGates().list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/config.openshift.io/v1/featuregates/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getFeatureGate())
        .once();

    // When
    boolean deleted = client.config().featureGates().withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private FeatureGate getFeatureGate() {
    return new FeatureGateBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .build();
  }
}
