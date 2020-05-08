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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.JSONSchemaProps;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.mock.crd.CronTabSpec;
import io.fabric8.kubernetes.client.mock.crd.DoneableCronTab;
import io.fabric8.kubernetes.client.mock.crd.CronTab;
import io.fabric8.kubernetes.client.mock.crd.CronTabList;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@EnableRuleMigrationSupport
public class CustomResourceCrudTest {
  @Rule
  public KubernetesServer kubernetesServer = new KubernetesServer(true,true);

  private MixedOperation<CronTab, CronTabList, DoneableCronTab, Resource<CronTab, DoneableCronTab>> podSetClient;

  @Test
  public void testCrud() throws IOException {
    CronTab cronTab1 = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    CronTab cronTab2 = createCronTab("my-second-cron-object", "* * * * */4", 2, "my-second-cron-image");
    CronTab cronTab3 = createCronTab("my-third-cron-object", "* * * * */3", 1, "my-third-cron-image");
    KubernetesClient client = kubernetesServer.getClient();

    KubernetesDeserializer.registerCustomKind("stable.example.com/v1", "CronTab", CronTab.class);
    CustomResourceDefinition cronTabCrd = client.customResourceDefinitions().load(getClass().getResourceAsStream("/crontab-crd.yml")).get();
    client.customResourceDefinitions().create(cronTabCrd);

    CustomResourceDefinitionContext crdContext = CustomResourceDefinitionContext.fromCrd(cronTabCrd);
    MixedOperation<CronTab, CronTabList, DoneableCronTab, Resource<CronTab, DoneableCronTab>> cronTabClient = client
      .customResources(crdContext, CronTab.class, CronTabList.class, DoneableCronTab.class);

    cronTabClient.inNamespace("test-ns").create(cronTab1);
    cronTabClient.inNamespace("test-ns").create(cronTab2);
    cronTabClient.inNamespace("test-ns").create(cronTab3);

    CronTabList cronTabList = cronTabClient.inNamespace("test-ns").list();
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
  public void testCrudWithDashSymbolInCRDName() throws IOException {
    CronTab cronTab1 = createCronTab("my-new-cron-object", "* * * * */5", 3, "my-awesome-cron-image");
    CronTab cronTab2 = createCronTab("my-second-cron-object", "* * * * */4", 2, "my-second-cron-image");
    CronTab cronTab3 = createCronTab("my-third-cron-object", "* * * * */3", 1, "my-third-cron-image");
    KubernetesClient client = kubernetesServer.getClient();

    KubernetesDeserializer.registerCustomKind("stable.example.com/v1", "CronTab", CronTab.class);
    CustomResourceDefinition cronTabCrd = cronTabCRDWithDashSymbolName();
    client.customResourceDefinitions().create(cronTabCrd);

    MixedOperation<CronTab, CronTabList, DoneableCronTab, Resource<CronTab, DoneableCronTab>> cronTabClient = client
      .customResources(cronTabCrd, CronTab.class, CronTabList.class, DoneableCronTab.class);

    cronTabClient.inNamespace("test-ns").create(cronTab1);
    cronTabClient.inNamespace("test-ns").create(cronTab2);
    cronTabClient.inNamespace("test-ns").create(cronTab3);

    CronTabList cronTabList = cronTabClient.inNamespace("test-ns").list();
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

  public void assertCronTab(CronTab cronTab, String name, String cronTabSpec, int replicas, String image) {
    assertEquals(name, cronTab.getMetadata().getName());
    assertEquals(cronTabSpec, cronTab.getSpec().getCronSpec());
    assertEquals(replicas, cronTab.getSpec().getReplicas());
    assertEquals(image, cronTab.getSpec().getImage());
  }

  public CronTab createCronTab(String name, String cronTabSpecStr, int replicas, String image) {
    CronTab cronTab = new CronTab();
    cronTab.setMetadata(new ObjectMetaBuilder().withName(name).build());
    CronTabSpec cronTabSpec = new CronTabSpec();
    cronTabSpec.setCronSpec(cronTabSpecStr);
    cronTabSpec.setImage(image);
    cronTabSpec.setReplicas(replicas);
    cronTab.setSpec(cronTabSpec);
    return cronTab;
  }

  public CustomResourceDefinition cronTabCRDWithDashSymbolName() throws IOException {
      return new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1beta1")
      .withNewMetadata().withName("crontabs.stable.example.com")
      .endMetadata()
      .withNewSpec()
      .withNewNames()
      .withKind("CronTab")
      .withPlural("cron-tabs")
      .withSingular("cron-tab")
      .endNames()
      .withGroup("stable.example.com")
      .withVersion("v1")
      .withScope("Namespaced")
      .withNewValidation()
      .withNewOpenAPIV3SchemaLike(readSchema())
      .endOpenAPIV3Schema()
      .endValidation()
      .endSpec()
      .build();

  }

  private JSONSchemaProps readSchema() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    final URL resource = getClass().getResource("/test-crd-validation-schema.json");

    final JSONSchemaProps jsonSchemaProps = mapper.readValue(resource, JSONSchemaProps.class);
    return jsonSchemaProps;
  }
}
