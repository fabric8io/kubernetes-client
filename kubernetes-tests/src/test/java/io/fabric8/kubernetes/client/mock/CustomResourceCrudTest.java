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
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.mock.crd.CronTab;
import io.fabric8.kubernetes.client.mock.crd.CronTabSpec;
import io.fabric8.kubernetes.client.mock.crd.CronTabStatus;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class CustomResourceCrudTest {

  KubernetesClient client;

  private CustomResourceDefinition cronTabCrd;

  @BeforeEach
  void setUp() {
    KubernetesDeserializer.registerCustomKind("stable.example.com/v1", "CronTab", CronTab.class);
    cronTabCrd = client
        .apiextensions().v1()
        .customResourceDefinitions()
        .load(getClass().getResourceAsStream("/crontab-crd.yml"))
        .get();
    client.apiextensions().v1().customResourceDefinitions().create(cronTabCrd);
  }

  @Test
  void testCrud() {
    CronTab cronTab1 = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    CronTab cronTab2 = createCronTab("my-second-cron-object", "* * * * */4", 2, "my-second-cron-image");
    CronTab cronTab3 = createCronTab("my-third-cron-object", "* * * * */3", 1, "my-third-cron-image");

    MixedOperation<CronTab, KubernetesResourceList<CronTab>, Resource<CronTab>> cronTabClient = client
        .resources(CronTab.class);

    cronTabClient.inNamespace("test-ns").create(cronTab1);
    cronTabClient.inNamespace("test-ns").create(cronTab2);
    cronTabClient.inNamespace("test-ns").create(cronTab3);

    KubernetesResourceList<CronTab> cronTabList = cronTabClient.inNamespace("test-ns").list();
    assertNotNull(cronTabList);
    assertEquals(3, cronTabList.getItems().size());

    CronTab fromServerCronTab = cronTabClient.inNamespace("test-ns").withName("my-new-cron-object").get();
    assertNotNull(fromServerCronTab);
    assertCronTab(fromServerCronTab, "my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");

    CronTab fromServerCronTab2 = cronTabClient.inNamespace("test-ns").withName("my-second-cron-object").get();
    assertNotNull(fromServerCronTab2);
    assertCronTab(fromServerCronTab2, "my-second-cron-object", "* * * * */4", 2, "my-second-cron-image");

    CronTab fromServerCronTab3 = cronTabClient.inNamespace("test-ns").withName("my-third-cron-object").get();
    assertNotNull(fromServerCronTab3);
    assertCronTab(fromServerCronTab3, "my-third-cron-object", "* * * * */3", 1, "my-third-cron-image");

    cronTabClient.inNamespace("test-ns").withName("my-third-cron-object").delete();
    cronTabList = cronTabClient.inNamespace("test-ns").list();
    assertEquals(2, cronTabList.getItems().size());
  }

  @Test
  void testCrudWithDashSymbolInCRDName() {
    CronTab cronTab1 = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    CronTab cronTab2 = createCronTab("my-second-cron-object", "* * * * */4", 2, "my-second-cron-image");
    CronTab cronTab3 = createCronTab("my-third-cron-object", "* * * * */3", 1, "my-third-cron-image");

    MixedOperation<CronTab, KubernetesResourceList<CronTab>, Resource<CronTab>> cronTabClient = client
        .resources(CronTab.class);

    cronTabClient.inNamespace("test-ns").create(cronTab1);
    cronTabClient.inNamespace("test-ns").create(cronTab2);
    cronTabClient.inNamespace("test-ns").create(cronTab3);

    KubernetesResourceList<CronTab> cronTabList = cronTabClient.inNamespace("test-ns").list();
    assertNotNull(cronTabList);
    assertEquals(3, cronTabList.getItems().size());

    CronTab fromServerCronTab = cronTabClient.inNamespace("test-ns").withName("my-new-cron-object").get();
    assertNotNull(fromServerCronTab);
    assertCronTab(fromServerCronTab, "my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");

    CronTab fromServerCronTab2 = cronTabClient.inNamespace("test-ns").withName("my-second-cron-object").get();
    assertNotNull(fromServerCronTab2);
    assertCronTab(fromServerCronTab2, "my-second-cron-object", "* * * * */4", 2, "my-second-cron-image");

    CronTab fromServerCronTab3 = cronTabClient.inNamespace("test-ns").withName("my-third-cron-object").get();
    assertNotNull(fromServerCronTab3);
    assertCronTab(fromServerCronTab3, "my-third-cron-object", "* * * * */3", 1, "my-third-cron-image");

    cronTabClient.inNamespace("test-ns").withName("my-third-cron-object").delete();
    cronTabList = cronTabClient.inNamespace("test-ns").list();
    assertEquals(2, cronTabList.getItems().size());
  }

  @Test
  void testStatusSubresourceHandling() {
    CronTab cronTab = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    CronTabStatus status = new CronTabStatus();
    status.setReplicas(1);
    cronTab.setStatus(status);

    NonNamespaceOperation<CronTab, KubernetesResourceList<CronTab>, Resource<CronTab>> cronTabClient = client
        .resources(CronTab.class).inNamespace("test-ns");

    CronTab result = cronTabClient.create(cronTab);

    // should be null after create
    assertNull(result.getStatus());

    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");

    cronTab.getMetadata().setLabels(labels);
    cronTab.getMetadata().setResourceVersion("1");

    result = cronTabClient.replace(cronTab);

    String originalUid = result.getMetadata().getUid();

    // should be null after replace
    assertNull(result.getStatus());

    assertNotNull(cronTabClient.updateStatus(cronTab).getStatus());

    labels.put("other", "label");
    cronTab.setStatus(null);

    result = cronTabClient.replace(cronTab);

    // should retain the existing
    assertNotNull(result.getStatus());

    labels.put("another", "label");
    result = cronTabClient.withName(cronTab.getMetadata().getName()).patch(cronTab);

    // should retain the existing
    assertNotNull(result.getStatus());
    // should have accumulated all labels
    assertEquals(new HashSet<String>(Arrays.asList("app", "other", "another")), result.getMetadata().getLabels().keySet());

    assertEquals(originalUid, result.getMetadata().getUid());
  }

  @Test
  void testStatusPatch() {
    CronTab cronTab = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    CronTabStatus status = new CronTabStatus();
    status.setReplicas(1);
    cronTab.setStatus(status);

    NonNamespaceOperation<CronTab, KubernetesResourceList<CronTab>, Resource<CronTab>> cronTabClient = client
        .resources(CronTab.class).inNamespace("test-ns");

    CronTab result = cronTabClient.create(cronTab);

    // should be null after create
    assertNull(result.getStatus());

    result.setStatus(status);

    result = cronTabClient.withName(cronTab.getMetadata().getName()).patchStatus(result);
    assertNotNull(result.getStatus());
  }

  void assertCronTab(CronTab cronTab, String name, String cronTabSpec, int replicas, String image) {
    assertEquals(name, cronTab.getMetadata().getName());
    assertEquals(cronTabSpec, cronTab.getSpec().getCronSpec());
    assertEquals(replicas, cronTab.getSpec().getReplicas());
    assertEquals(image, cronTab.getSpec().getImage());
  }

  CronTab createCronTab(String name, String cronTabSpecStr, int replicas, String image) {
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
