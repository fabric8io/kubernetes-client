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
package io.fabric8.openclustermanagement.api.model.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmRelease;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HelmReleaseTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-helmrelease.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final HelmRelease helmRelease = mapper.readValue(originalJson, HelmRelease.class);
    final String serializedJson = mapper.writeValueAsString(helmRelease);
    final HelmRelease helmReleaseFromSerializedJson = mapper.readValue(serializedJson, HelmRelease.class);

    // Then
    assertNotNull(helmRelease);
    assertNotNull(serializedJson);
    assertNotNull(helmReleaseFromSerializedJson);
    assertEquals(helmRelease.getMetadata().getName(), helmReleaseFromSerializedJson.getMetadata().getName());
    assertNotNull(helmRelease.getSpec());
    assertEquals("nginx-ingress", helmRelease.getRepo().getChartName());
    assertEquals("helmrepo", helmRelease.getRepo().getSource().getType());
    assertEquals(1, helmRelease.getRepo().getSource().getHelmRepo().getUrls().size());
    assertEquals("1.26.0", helmRelease.getRepo().getVersion());
    assertEquals(Collections.singletonMap("replicaCount", 3), helmRelease.getSpec().get("defaultBackend"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    HelmReleaseBuilder helmReleaseBuilder = new HelmReleaseBuilder()
        .withNewMetadata()
        .addToLabels("vendor", "OpenShift")
        .withName("sample_subscription")
        .addToAnnotations("apps.open-cluster-management.io/git-path", "apps/sample/")
        .addToAnnotations("apps.open-cluster-management.io/git-branch", "sample_branch")
        .endMetadata()
        .withNewRepo()
        .withChartName("nginx-ingress")
        .withNewSource()
        .withNewHelmRepo()
        .withUrls("https://kubernetes-charts.storage.googleapis.com/nginx-ingress-1.26.0.tgz")
        .endHelmRepo()
        .withType("HelmRepo")
        .endSource()
        .withVersion("1.26.0")
        .endRepo();

    // When
    HelmRelease helmRelease = helmReleaseBuilder.build();

    // Then
    assertNotNull(helmRelease);
    assertEquals("sample_subscription", helmRelease.getMetadata().getName());
    assertEquals(1, helmRelease.getMetadata().getLabels().size());
    assertEquals(2, helmRelease.getMetadata().getAnnotations().size());
    assertEquals("nginx-ingress", helmRelease.getRepo().getChartName());
    assertEquals("HelmRepo", helmRelease.getRepo().getSource().getType());
    assertEquals(1, helmRelease.getRepo().getSource().getHelmRepo().getUrls().size());
  }

}
