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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class TemplateIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private Template template1;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(TemplateIT.class.getResourceAsStream("/template-it.yml"));
  }

  @Test
  public void load() {
    Template template = client.templates()
      .withParameters(Collections.singletonMap("REDIS_PASSWORD", "secret"))
      .inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-template.yml")).get();
    assertThat(template).isNotNull();
    assertEquals(1, template.getObjects().size());
  }

  @Test
  public void get() {
    template1 = client.templates().inNamespace(session.getNamespace()).withName("template-get").get();
    assertNotNull(template1);
  }

  @Test
  public void list() {
    TemplateList aList = client.templates().inNamespace(session.getNamespace()).list();
    assertThat(aList).isNotNull();
    assertTrue(aList.getItems().size() >= 1);
  }

  @Test
  public void delete() {
    ReadyEntity<Template> template1Ready = new ReadyEntity<>(Template.class, client, "template-delete", this.session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(template1Ready);
    boolean bDeleted = client.templates().inNamespace(session.getNamespace()).withName("template-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  public void testCreateWithVersionV1() {
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
    template = client.templates().inNamespace(session.getNamespace()).create(template);
    assertNotNull(template);
    assertEquals("template.openshift.io/v1", template.getApiVersion());
  }
}
