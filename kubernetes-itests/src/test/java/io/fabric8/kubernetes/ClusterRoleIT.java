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

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.PolicyRuleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ClusterRoleIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private ClusterRole clusterRole;

  @Before
  public void init() {
    // Do not run tests on opeshift 3.6.0 and 3.6.1
    assumeFalse(client.getVersion().getMajor().equalsIgnoreCase("1")
      && client.getVersion().getMinor().startsWith("6"));

    ClusterRole kubernetesclusterRole = new ClusterRoleBuilder()
      .withNewMetadata()
      .withName("node-reader")
      .endMetadata()
      .addToRules(0, new PolicyRuleBuilder()
        .addToApiGroups(0,"")
        .addToResourceNames(0,"my-node")
        .addToResources(0,"nodes")
        .addToVerbs(0, "get")
        .addToVerbs(1, "watch")
        .addToVerbs(2, "list")
        .build()
      )
      .build();

    client.rbac().clusterRoles().createOrReplace(kubernetesclusterRole);
  }

  @Test
  public void get() {

    clusterRole = client.rbac().clusterRoles().withName("node-reader").get();

    assertNotNull(clusterRole);
    assertEquals("ClusterRole", clusterRole.getKind());
    assertNotNull(clusterRole.getMetadata());
    assertEquals("node-reader", clusterRole.getMetadata().getName());
    assertNotNull(clusterRole.getRules());
    assertEquals(1, clusterRole.getRules().size());
    assertNotNull(clusterRole.getRules().get(0).getApiGroups());
    assertEquals(1, clusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", clusterRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(clusterRole.getRules().get(0).getResourceNames());
    assertEquals(1, clusterRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-node", clusterRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(clusterRole.getRules().get(0).getResources());
    assertEquals(1, clusterRole.getRules().get(0).getResources().size());
    assertEquals("nodes", clusterRole.getRules().get(0).getResources().get(0));
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
    assertNotNull(aClusterRole.getRules().get(0).getNonResourceURLs());
    assertEquals(1, aClusterRole.getRules().get(0).getNonResourceURLs().size());
    assertEquals("/healthz", aClusterRole.getRules().get(0).getNonResourceURLs().get(0));
    assertNotNull(aClusterRole.getRules().get(0).getResourceNames());
    assertEquals(1, aClusterRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-node", aClusterRole.getRules().get(0).getResourceNames().get(0));
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
      if (clusterRole.getMetadata().getName().equals("node-reader"))  {
        assertEquals("ClusterRole", clusterRole.getKind());
        assertNotNull(clusterRole.getMetadata());
        assertEquals("node-reader", clusterRole.getMetadata().getName());
        assertNotNull(clusterRole.getRules());
        assertEquals(1, clusterRole.getRules().size());
        assertNotNull(clusterRole.getRules().get(0).getApiGroups());
        assertEquals(1, clusterRole.getRules().get(0).getApiGroups().size());
        assertEquals("", clusterRole.getRules().get(0).getApiGroups().get(0));
        assertNotNull(clusterRole.getRules().get(0).getResourceNames());
        assertEquals(1, clusterRole.getRules().get(0).getResourceNames().size());
        assertEquals("my-node", clusterRole.getRules().get(0).getResourceNames().get(0));
        assertNotNull(clusterRole.getRules().get(0).getResources());
        assertEquals(1, clusterRole.getRules().get(0).getResources().size());
        assertEquals("nodes", clusterRole.getRules().get(0).getResources().get(0));
        assertNotNull(clusterRole.getRules().get(0).getVerbs());
        assertEquals(3, clusterRole.getRules().get(0).getVerbs().size());
        assertEquals("get", clusterRole.getRules().get(0).getVerbs().get(0));
        assertEquals("watch", clusterRole.getRules().get(0).getVerbs().get(1));
        assertEquals("list", clusterRole.getRules().get(0).getVerbs().get(2));
        found = true;
      }
    }

    assertEquals(true, found);
  }

  @Test
  public void update() {

    clusterRole = client.rbac().clusterRoles().withName("node-reader").edit()
      .editRule(0).addToApiGroups(1, "extensions").endRule().done();

    assertNotNull(clusterRole);
    assertEquals("ClusterRole", clusterRole.getKind());
    assertNotNull(clusterRole.getMetadata());
    assertEquals("node-reader", clusterRole.getMetadata().getName());
    assertNotNull(clusterRole.getRules());
    assertEquals(1, clusterRole.getRules().size());
    assertNotNull(clusterRole.getRules().get(0).getApiGroups());
    assertEquals(2, clusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", clusterRole.getRules().get(0).getApiGroups().get(0));
    assertEquals("extensions", clusterRole.getRules().get(0).getApiGroups().get(1));
    assertNotNull(clusterRole.getRules().get(0).getResourceNames());
    assertEquals(1, clusterRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-node", clusterRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(clusterRole.getRules().get(0).getResources());
    assertEquals(1, clusterRole.getRules().get(0).getResources().size());
    assertEquals("nodes", clusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(clusterRole.getRules().get(0).getVerbs());
    assertEquals(3, clusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", clusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", clusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", clusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void delete() {

    ClusterRoleList clusterRoleListBefore = client.rbac().clusterRoles().list();

    boolean deleted = client.rbac().clusterRoles().withName("node-reader").delete();
    assertTrue(deleted);

    DeleteEntity<ClusterRole> deleteEntity = new DeleteEntity<>(ClusterRole.class, client, "node-reader", null);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);

    ClusterRoleList clusterRoleListAfter = client.rbac().clusterRoles().list();
    assertEquals(clusterRoleListBefore.getItems().size()-1,clusterRoleListAfter.getItems().size());
  }

  @After
  public void cleanup() {
    client.rbac().clusterRoles().withName("node-reader").delete();
    DeleteEntity<ClusterRole> deleteEntity = new DeleteEntity<>(ClusterRole.class, client, "node-reader", null);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

}
