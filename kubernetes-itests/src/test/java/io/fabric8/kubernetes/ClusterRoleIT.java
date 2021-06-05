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

import java.util.concurrent.TimeUnit;

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ClusterRoleIT {

  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ClusterRoleIT.class.getResourceAsStream("/clusterrole-it.yml"));
  }

  @Test
  public void get() {

    ClusterRole clusterRole = client.rbac().clusterRoles().withName("node-reader-get").get();

    assertNotNull(clusterRole);
    assertEquals("ClusterRole", clusterRole.getKind());
    assertNotNull(clusterRole.getMetadata());
    assertEquals("node-reader-get", clusterRole.getMetadata().getName());
    assertNotNull(clusterRole.getRules());
    assertEquals(1, clusterRole.getRules().size());
    assertNotNull(clusterRole.getRules().get(0).getApiGroups());
    assertEquals(1, clusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", clusterRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(clusterRole.getRules().get(0).getResourceNames());
    assertNotNull(clusterRole.getRules().get(0).getResources());
    assertEquals(1, clusterRole.getRules().get(0).getResources().size());
    assertEquals("secrets", clusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(clusterRole.getRules().get(0).getVerbs());
    assertEquals(3, clusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", clusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", clusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", clusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void load() {

    ClusterRole aClusterRole = client.rbac().clusterRoles()
      .load(getClass().getResourceAsStream("/test-kubernetesclusterrole.yml")).get();

    assertNotNull(aClusterRole);
    assertEquals("ClusterRole", aClusterRole.getKind());
    assertNotNull(aClusterRole.getMetadata());
    assertEquals("node-reader", aClusterRole.getMetadata().getName());
    assertNotNull(aClusterRole.getRules());
    assertEquals(1, aClusterRole.getRules().size());
    assertNotNull(aClusterRole.getRules().get(0).getApiGroups());
    assertEquals(1, aClusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", aClusterRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(aClusterRole.getRules().get(0).getResourceNames());
    assertNotNull(aClusterRole.getRules().get(0).getResources());
    assertEquals(1, aClusterRole.getRules().get(0).getResources().size());
    assertEquals("nodes", aClusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(aClusterRole.getRules().get(0).getVerbs());
    assertEquals(3, aClusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", aClusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", aClusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", aClusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void list() {

    ClusterRoleList clusterRoleList = client.rbac().clusterRoles().list();
    boolean found = false;

    assertNotNull(clusterRoleList);
    assertNotNull(clusterRoleList.getItems());

    for (ClusterRole clusterRole : clusterRoleList.getItems())  {
      if (clusterRole.getMetadata().getName().equals("node-reader-list"))  {
        assertEquals("ClusterRole", clusterRole.getKind());
        assertNotNull(clusterRole.getMetadata());
        assertEquals("node-reader-list", clusterRole.getMetadata().getName());
        assertNotNull(clusterRole.getRules());
        assertEquals(1, clusterRole.getRules().size());
        assertNotNull(clusterRole.getRules().get(0).getApiGroups());
        assertEquals(1, clusterRole.getRules().get(0).getApiGroups().size());
        assertEquals("", clusterRole.getRules().get(0).getApiGroups().get(0));
        assertNotNull(clusterRole.getRules().get(0).getResourceNames());
        assertNotNull(clusterRole.getRules().get(0).getResources());
        assertEquals(1, clusterRole.getRules().get(0).getResources().size());
        assertEquals("secrets", clusterRole.getRules().get(0).getResources().get(0));
        assertNotNull(clusterRole.getRules().get(0).getVerbs());
        assertEquals(3, clusterRole.getRules().get(0).getVerbs().size());
        assertEquals("get", clusterRole.getRules().get(0).getVerbs().get(0));
        assertEquals("watch", clusterRole.getRules().get(0).getVerbs().get(1));
        assertEquals("list", clusterRole.getRules().get(0).getVerbs().get(2));
        found = true;
      }
    }

    assertTrue(found);
  }

  @Test
  public void update() {

    ClusterRole clusterRole = client.rbac().clusterRoles().withName("node-reader-update").edit(c -> new ClusterRoleBuilder(c)
                        .editRule(0).addToApiGroups(1, "extensions").endRule().build());

    assertNotNull(clusterRole);
    assertEquals("ClusterRole", clusterRole.getKind());
    assertNotNull(clusterRole.getMetadata());
    assertEquals("node-reader-update", clusterRole.getMetadata().getName());
    assertNotNull(clusterRole.getRules());
    assertEquals(1, clusterRole.getRules().size());
    assertNotNull(clusterRole.getRules().get(0).getApiGroups());
    assertEquals(2, clusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", clusterRole.getRules().get(0).getApiGroups().get(0));
    assertEquals("extensions", clusterRole.getRules().get(0).getApiGroups().get(1));
    assertNotNull(clusterRole.getRules().get(0).getResourceNames());
    assertNotNull(clusterRole.getRules().get(0).getResources());
    assertEquals(1, clusterRole.getRules().get(0).getResources().size());
    assertEquals("secrets", clusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(clusterRole.getRules().get(0).getVerbs());
    assertEquals(3, clusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", clusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", clusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", clusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void delete() {

    ClusterRoleList clusterRoleListBefore = client.rbac().clusterRoles().list();

    boolean deleted = client.rbac().clusterRoles().withName("node-reader-delete").delete();
    assertTrue(deleted);

    DeleteEntity<ClusterRole> deleteEntity = new DeleteEntity<>(ClusterRole.class, client, "node-reader", null);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);

    ClusterRoleList clusterRoleListAfter = client.rbac().clusterRoles().list();
    assertEquals(clusterRoleListBefore.getItems().size()-1,clusterRoleListAfter.getItems().size());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ClusterRoleBindingIT.class.getResourceAsStream("/clusterrole-it.yml"));
  }

}
