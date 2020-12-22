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
package io.fabric8.kubernetes;

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class NamespaceIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Namespace namespace;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(NamespaceIT.class.getResourceAsStream("/namespace-it.yml"));
  }

  @Test
  public void load() {
    Namespace aNamespace = client.namespaces().load(getClass().getResourceAsStream("/test-namespace.yml")).get();

    assertThat(aNamespace).isNotNull();
    assertEquals("fabric8-test", aNamespace.getMetadata().getName());
  }

  @Test
  public void get() {
    namespace = client.namespaces().withName("namespace-get").get();
    assertThat(namespace).isNotNull();
  }

  @Test
  public void list() {
    NamespaceList aNamespaceList = client.namespaces().list();
    assertNotNull(aNamespaceList);
    assertTrue(aNamespaceList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    namespace = client.namespaces().withName("namespace-update").edit(c -> new NamespaceBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata()
      .build());

    assertNotNull(namespace);
    assertEquals("bar", namespace.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.namespaces().withName("namespace-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(NamespaceIT.class.getResourceAsStream("/namespace-it.yml"));
  }
}
