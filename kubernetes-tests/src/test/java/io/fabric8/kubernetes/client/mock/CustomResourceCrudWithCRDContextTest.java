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

import com.fasterxml.jackson.core.type.TypeReference;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.internal.SerializationUtils;
import io.fabric8.kubernetes.client.mock.crd.CronTab;
import io.fabric8.kubernetes.client.mock.crd.CronTabSpec;
import io.fabric8.kubernetes.client.mock.crd.CronTabStatus;
import io.fabric8.kubernetes.client.mock.crd.EntandoBundleRelease;
import io.fabric8.kubernetes.client.mock.crd.EntandoBundleReleaseList;
import io.fabric8.kubernetes.client.mock.crd.EntandoBundleReleaseSpec;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

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

  @Test
  void testUpdateStatusSubresource() throws IOException {
    CustomResourceDefinitionContext context = setupCronTabContext();

    CronTab cronTab1 = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    client.customResource(context).inNamespace("test-ns").create(asMap(cronTab1));

    cronTab1.setStatus(new CronTabStatus());
    cronTab1.getStatus().setReplicas(12);
    client.customResource(context).inNamespace("test-ns").updateStatus(asMap(cronTab1));

    CronTab cronTabUpdated = Serialization.jsonMapper().convertValue(
            client.customResource(context).inNamespace("test-ns").withName("my-new-cron-object").get(),
            CronTab.class);
    assertCronTab(cronTabUpdated, "my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    assertEquals(12, cronTabUpdated.getStatus().getReplicas());
  }

  @Test
  public void testUpdateStatusSubresource() throws IOException {
    CustomResourceDefinitionContext context = setupCronTabContext();

    CronTab cronTab1 = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    client.customResource(context).inNamespace("test-ns").create(asMap(cronTab1));

    cronTab1.setStatus(new CronTabStatus());
    cronTab1.getStatus().setReplicas(12);
    client.customResource(context).inNamespace("test-ns").updateStatus(asMap(cronTab1));

    CronTab cronTabUpdated = Serialization.jsonMapper().convertValue(
            client.customResource(context).inNamespace("test-ns").withName("my-new-cron-object").get(),
            CronTab.class);
    assertCronTab(cronTabUpdated, "my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    assertEquals(12, cronTabUpdated.getStatus().getReplicas());
  }

  void assertCronTab(CronTab cronTab, String name, String cronTabSpec, int replicas, String image) {
    assertEquals(name, cronTab.getMetadata().getName());
    assertEquals(cronTabSpec, cronTab.getSpec().getCronSpec());
    assertEquals(replicas, cronTab.getSpec().getReplicas());
    assertEquals(image, cronTab.getSpec().getImage());
  }

  private CustomResourceDefinitionContext setupCronTabContext() {
    KubernetesDeserializer.registerCustomKind("stable.example.com/v1", "CronTab", CronTab.class);
    CustomResourceDefinition cronTabCrd = client
            .apiextensions().v1beta1()
            .customResourceDefinitions()
            .load(getClass().getResourceAsStream("/crontab-crd.yml"))
            .get();
    client.apiextensions().v1beta1().customResourceDefinitions().create(cronTabCrd);

    CustomResourceDefinitionContext context =
            new CustomResourceDefinitionContext.Builder()
                    .withGroup("stable.example.com")
                    .withPlural("crontabs")
                    .withScope("Namespaced")
                    .withVersion("v1")
                    .withKind("CronTab")
                    .build();
    return context;
  }

  private Map<String, Object> asMap(CronTab cronTab1) {
    return SerializationUtils.getMapper().convertValue(cronTab1, new TypeReference<Map<String, Object>>() {
    });
  }

  private CronTab createCronTab(String name, String cronTabSpecStr, int replicas, String image) {
    CronTab cronTab = new CronTab();
    cronTab.setMetadata(new ObjectMetaBuilder().withName(name).build());
    CronTabSpec cronTabSpec = new CronTabSpec();
    cronTabSpec.setCronSpec(cronTabSpecStr);
    cronTabSpec.setImage(image);
    cronTabSpec.setReplicas(replicas);
    cronTab.setSpec(cronTabSpec);
    return cronTab;
  }
}
