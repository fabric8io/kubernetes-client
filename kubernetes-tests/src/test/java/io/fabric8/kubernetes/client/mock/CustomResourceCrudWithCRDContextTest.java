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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.mock.crd.EntandoBundleRelease;
import io.fabric8.kubernetes.client.mock.crd.EntandoBundleReleaseList;
import io.fabric8.kubernetes.client.mock.crd.EntandoBundleReleaseSpec;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient(crud = true)
class CustomResourceCrudWithCRDContextTest {


  KubernetesClient client;

  @Test
  void testCreateAndGet() {
    // Given
    KubernetesDeserializer.registerCustomKind("demo.fabric8.io/v1alpha1", "EntandoBundleRelease", EntandoBundleRelease.class);
    MixedOperation<EntandoBundleRelease, EntandoBundleReleaseList, Resource<EntandoBundleRelease>> ebrClient = client
      .customResources(EntandoBundleRelease.class, EntandoBundleReleaseList.class);

    // When
    ebrClient.inNamespace("ns1").create(getMockedEntandoBundleRelease());
    EntandoBundleRelease ebr1 = ebrClient.inNamespace("ns1").withName("ebr1").get();

    // Then
    assertNotNull(ebr1);
    assertEquals("ebr1", ebr1.getMetadata().getName());
  }

  @Test
  void testCreateAndGetWithInferredContext() {
    // Given
    KubernetesDeserializer.registerCustomKind("demo.fabric8.io/v1alpha1", "EntandoBundleRelease", EntandoBundleRelease.class);
    MixedOperation<EntandoBundleRelease, KubernetesResourceList<EntandoBundleRelease>, Resource<EntandoBundleRelease>> ebrClient = client.customResources(EntandoBundleRelease.class);

    // When
    ebrClient.inNamespace("ns1").create(getMockedEntandoBundleRelease());
    EntandoBundleRelease ebr1 = ebrClient.inNamespace("ns1").withName("ebr1").get();

    // Then
    assertNotNull(ebr1);
    assertEquals("ebr1", ebr1.getMetadata().getName());
  }


  private EntandoBundleRelease getMockedEntandoBundleRelease() {
    EntandoBundleReleaseSpec entandoBundleReleaseSpec = new EntandoBundleReleaseSpec();
    entandoBundleReleaseSpec.setDatabaseType("MySQL");
    EntandoBundleRelease entandoBundleRelease = new EntandoBundleRelease();
    entandoBundleRelease.setMetadata(new ObjectMetaBuilder()
      .withName("ebr1")
      .build());
    entandoBundleRelease.setSpec(entandoBundleReleaseSpec);
    return entandoBundleRelease;
  }
}
