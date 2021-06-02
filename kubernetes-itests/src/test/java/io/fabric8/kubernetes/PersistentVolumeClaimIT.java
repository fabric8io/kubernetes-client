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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
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
public class PersistentVolumeClaimIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(PersistentVolumeClaimIT.class.getResourceAsStream("/persistentvolumeclaims-it.yml"));
  }

  @Test
  public void get() {
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims().inNamespace(session.getNamespace()).withName("persistentvolumeclaims-get").get();
    assertThat(persistentVolumeClaim).isNotNull();
  }

  @Test
  public void list() {
    PersistentVolumeClaimList aEndpointList = client.persistentVolumeClaims().inNamespace(session.getNamespace()).list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims()
        .inNamespace(session.getNamespace())
        .withName("persistentvolumeclaims-update")
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE), new PersistentVolumeClaimBuilder()
            .withNewMetadata()
            .addToLabels("foo", "bar")
            .endMetadata()
            .build());

    assertNotNull(persistentVolumeClaim);
    assertEquals("bar", persistentVolumeClaim.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.persistentVolumeClaims().inNamespace(session.getNamespace()).withName("persistentvolumeclaims-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(PersistentVolumeClaimIT.class.getResourceAsStream("/persistentvolumeclaims-it.yml"));
  }
}
