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
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.Subscription;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SubscriptionTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-subscription.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Subscription subscription = mapper.readValue(originalJson, Subscription.class);
    final String serializedJson = mapper.writeValueAsString(subscription);
    final Subscription subscriptionFromSerializedJson = mapper.readValue(serializedJson, Subscription.class);

    // Then
    assertNotNull(subscription);
    assertNotNull(serializedJson);
    assertNotNull(subscriptionFromSerializedJson);
    assertEquals(subscription.getMetadata().getName(), subscriptionFromSerializedJson.getMetadata().getName());
    assertEquals("channel_namespace/sample_channel", subscription.getSpec().getChannel());
    assertEquals(1, subscription.getSpec().getPackageOverrides().size());
    assertEquals(1, subscription.getSpec().getPackageOverrides().get(0).getPackageOverrides().size());
    assertEquals("PlacementRule", subscription.getSpec().getPlacement().getPlacementRef().getKind());
    assertEquals("demo-clusters", subscription.getSpec().getPlacement().getPlacementRef().getName());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    SubscriptionBuilder subscriptionBuilder = new SubscriptionBuilder()
        .withNewMetadata()
        .addToLabels("vendor", "OpenShift")
        .withName("sample_subscription")
        .addToAnnotations("apps.open-cluster-management.io/git-path", "apps/sample/")
        .addToAnnotations("apps.open-cluster-management.io/git-branch", "sample_branch")
        .endMetadata()
        .withNewSpec()
        .withChannel("channel_namespace/sample_channel")
        .addNewPackageOverride()
        .withPackageName("my-sample-application")
        .withPackageAlias("the-sample-app")
        .endPackageOverride()
        .endSpec();

    // When
    Subscription subscription = subscriptionBuilder.build();

    // Then
    assertNotNull(subscription);
    assertEquals("sample_subscription", subscription.getMetadata().getName());
    assertEquals(1, subscription.getMetadata().getLabels().size());
    assertEquals(2, subscription.getMetadata().getAnnotations().size());
    assertEquals("channel_namespace/sample_channel", subscription.getSpec().getChannel());
    assertEquals(1, subscription.getSpec().getPackageOverrides().size());
  }
}
