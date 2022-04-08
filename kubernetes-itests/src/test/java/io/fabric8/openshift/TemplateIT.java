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

package io.fabric8.openshift;

import io.fabric8.commons.ReadyEntity;
import io.fabric8.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(Template.class)
class TemplateIT {

  static OpenShiftClient client;

  Namespace namespace;

  @BeforeAll
  public static void init() {
    client.load(TemplateIT.class.getResourceAsStream("/template-it.yml")).create();
  }

  @Test
  void load() {
    Template template = client.templates()
      .withParameters(Collections.singletonMap("REDIS_PASSWORD", "secret"))
      .inNamespace(namespace.getMetadata().getName())
      .load(getClass().getResourceAsStream("/test-template.yml")).get();
    assertThat(template).isNotNull();
    assertEquals(1, template.getObjects().size());
  }

  @Test
  void get() {
    Template template1 = client.templates().inNamespace(namespace.getMetadata().getName()).withName("template-get").get();
    assertNotNull(template1);
  }

  @Test
  void list() {
    TemplateList aList = client.templates().inNamespace(namespace.getMetadata().getName()).list();
    assertThat(aList).isNotNull();
    assertTrue(aList.getItems().size() >= 1);
  }

  @Test
  void delete() {
    ReadyEntity<Template> template1Ready = new ReadyEntity<>(Template.class, client, "template-delete", this.namespace.getMetadata().getName());
    await().atMost(30, TimeUnit.SECONDS).until(template1Ready);
    boolean bDeleted = client.templates().inNamespace(namespace.getMetadata().getName()).withName("template-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  void testCreateWithVersionV1() {
    // Given
    Pod pod = new PodBuilder()
      .withNewMetadata().withName("redis-master").endMetadata()
      .withNewSpec()
      .addNewContainer()
      .addNewEnv().withName("REDIS_PASSWORD").withValue("${REDIS_PASSWORD}").endEnv()
      .withImage("dockerfile/redis")
      .addNewPort()
      .withContainerPort(6379)
      .withProtocol("TCP")
      .endPort()
      .endContainer()
      .endSpec()
      .build();
    Template template =  new TemplateBuilder()
      .withNewMetadata()
      .withName("templateit-createv1")
      .addToAnnotations("description", "Description")
      .addToAnnotations("iconClass", "icon-redis")
      .addToAnnotations("tags", "database,nosql")
      .endMetadata()
      .addToObjects(pod)
      .addNewParameter()
      .withDescription("Password used for Redis authentication")
      .withFrom("[A-Z0-9]{8}")
      .withGenerate("expression")
      .withName("REDIS_PASSWORD")
      .endParameter()
      .addToLabels("redis", "master")
      .build();

    // When
    // Set v1 Api
    template.setApiVersion("v1");
    template = client.templates().inNamespace(namespace.getMetadata().getName()).create(template);
    assertNotNull(template);
    assertEquals("template.openshift.io/v1", template.getApiVersion());
  }
}
