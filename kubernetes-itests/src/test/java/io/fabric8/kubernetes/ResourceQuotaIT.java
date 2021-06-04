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
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ResourceQuotaIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ResourceQuotaIT.class.getResourceAsStream("/resourcequota-it.yml"));
  }

  @Test
  public void get() {
    ResourceQuota resourceQuota = client.resourceQuotas().inNamespace(session.getNamespace()).withName("resourcequota-get").get();
    assertThat(resourceQuota).isNotNull();
  }

  @Test
  public void list() {
    ResourceQuotaList aEndpointList = client.resourceQuotas().inNamespace(session.getNamespace()).list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ResourceQuota resourceQuota = client.resourceQuotas().inNamespace(session.getNamespace()).withName("resourcequota-update").edit(c -> new ResourceQuotaBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(resourceQuota);
    assertEquals("bar", resourceQuota.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.resourceQuotas().inNamespace(session.getNamespace()).withName("resourcequota-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ResourceQuotaIT.class.getResourceAsStream("/resourcequota-it.yml"));
  }
}

