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

import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRole;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleList;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.KubernetesPolicyRuleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class KubernetesClusterRoleIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private KubernetesClusterRole kubernetesClusterRole;

  @Before
  public void init() {
    // Do not run tests on opeshift 3.6.0 and 3.6.1
    assumeFalse(client.getVersion().getMajor().equalsIgnoreCase("1")
      && client.getVersion().getMinor().startsWith("6"));

    KubernetesClusterRole kubernetesclusterRole = new KubernetesClusterRoleBuilder()
      .withNewMetadata()
      .withName("node-reader")
      .endMetadata()
      .addToRules(0, new KubernetesPolicyRuleBuilder()
        .addToApiGroups(0,"")
        .addToResourceNames(0,"my-node")
        .addToResources(0,"nodes")
        .addToVerbs(0, "get")
        .addToVerbs(1, "watch")
        .addToVerbs(2, "list")
        .build()
      )
      .build();

    client.rbac().kubernetesClusterRoles().createOrReplace(kubernetesclusterRole);
  }

  @Test
  public void get() {

    kubernetesClusterRole = client.rbac().kubernetesClusterRoles().withName("node-reader").get();

    assertNotNull(kubernetesClusterRole);
    assertEquals("ClusterRole", kubernetesClusterRole.getKind());
    assertNotNull(kubernetesClusterRole.getMetadata());
    assertEquals("node-reader", kubernetesClusterRole.getMetadata().getName());
    assertNotNull(kubernetesClusterRole.getRules());
    assertEquals(1, kubernetesClusterRole.getRules().size());
    assertNotNull(kubernetesClusterRole.getRules().get(0).getApiGroups());
    assertEquals(1, kubernetesClusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", kubernetesClusterRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(kubernetesClusterRole.getRules().get(0).getResourceNames());
    assertEquals(1, kubernetesClusterRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-node", kubernetesClusterRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(kubernetesClusterRole.getRules().get(0).getResources());
    assertEquals(1, kubernetesClusterRole.getRules().get(0).getResources().size());
    assertEquals("nodes", kubernetesClusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(kubernetesClusterRole.getRules().get(0).getVerbs());
    assertEquals(3, kubernetesClusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", kubernetesClusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", kubernetesClusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", kubernetesClusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void load() {

    KubernetesClusterRole aKubernetesClusterRole = client.rbac().kubernetesClusterRoles()
      .load(getClass().getResourceAsStream("/test-kubernetesclusterrole.yml")).get();

    assertNotNull(aKubernetesClusterRole);
    assertEquals("ClusterRole", aKubernetesClusterRole.getKind());
    assertNotNull(aKubernetesClusterRole.getMetadata());
    assertEquals("node-reader", aKubernetesClusterRole.getMetadata().getName());
    assertNotNull(aKubernetesClusterRole.getRules());
    assertEquals(1, aKubernetesClusterRole.getRules().size());
    assertNotNull(aKubernetesClusterRole.getRules().get(0).getApiGroups());
    assertEquals(1, aKubernetesClusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", aKubernetesClusterRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(aKubernetesClusterRole.getRules().get(0).getNonResourceURLs());
    assertEquals(1, aKubernetesClusterRole.getRules().get(0).getNonResourceURLs().size());
    assertEquals("/healthz", aKubernetesClusterRole.getRules().get(0).getNonResourceURLs().get(0));
    assertNotNull(aKubernetesClusterRole.getRules().get(0).getResourceNames());
    assertEquals(1, aKubernetesClusterRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-node", aKubernetesClusterRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(aKubernetesClusterRole.getRules().get(0).getResources());
    assertEquals(1, aKubernetesClusterRole.getRules().get(0).getResources().size());
    assertEquals("nodes", aKubernetesClusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(aKubernetesClusterRole.getRules().get(0).getVerbs());
    assertEquals(3, aKubernetesClusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", aKubernetesClusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", aKubernetesClusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", aKubernetesClusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void list() {

    KubernetesClusterRoleList kubernetesClusterRoleList = client.rbac().kubernetesClusterRoles().list();
    boolean found = false;

    assertNotNull(kubernetesClusterRoleList);
    assertNotNull(kubernetesClusterRoleList.getItems());

    for (KubernetesClusterRole kubernetesClusterRole : kubernetesClusterRoleList.getItems())  {
      if (kubernetesClusterRole.getMetadata().getName().equals("node-reader"))  {
        assertEquals("ClusterRole", kubernetesClusterRole.getKind());
        assertNotNull(kubernetesClusterRole.getMetadata());
        assertEquals("node-reader", kubernetesClusterRole.getMetadata().getName());
        assertNotNull(kubernetesClusterRole.getRules());
        assertEquals(1, kubernetesClusterRole.getRules().size());
        assertNotNull(kubernetesClusterRole.getRules().get(0).getApiGroups());
        assertEquals(1, kubernetesClusterRole.getRules().get(0).getApiGroups().size());
        assertEquals("", kubernetesClusterRole.getRules().get(0).getApiGroups().get(0));
        assertNotNull(kubernetesClusterRole.getRules().get(0).getResourceNames());
        assertEquals(1, kubernetesClusterRole.getRules().get(0).getResourceNames().size());
        assertEquals("my-node", kubernetesClusterRole.getRules().get(0).getResourceNames().get(0));
        assertNotNull(kubernetesClusterRole.getRules().get(0).getResources());
        assertEquals(1, kubernetesClusterRole.getRules().get(0).getResources().size());
        assertEquals("nodes", kubernetesClusterRole.getRules().get(0).getResources().get(0));
        assertNotNull(kubernetesClusterRole.getRules().get(0).getVerbs());
        assertEquals(3, kubernetesClusterRole.getRules().get(0).getVerbs().size());
        assertEquals("get", kubernetesClusterRole.getRules().get(0).getVerbs().get(0));
        assertEquals("watch", kubernetesClusterRole.getRules().get(0).getVerbs().get(1));
        assertEquals("list", kubernetesClusterRole.getRules().get(0).getVerbs().get(2));
        found = true;
      }
    }

    assertEquals(true, found);
  }

  @Test
  public void update() {

    kubernetesClusterRole = client.rbac().kubernetesClusterRoles().withName("node-reader").edit()
      .editRule(0).addToApiGroups(1, "extensions").endRule().done();

    assertNotNull(kubernetesClusterRole);
    assertEquals("ClusterRole", kubernetesClusterRole.getKind());
    assertNotNull(kubernetesClusterRole.getMetadata());
    assertEquals("node-reader", kubernetesClusterRole.getMetadata().getName());
    assertNotNull(kubernetesClusterRole.getRules());
    assertEquals(1, kubernetesClusterRole.getRules().size());
    assertNotNull(kubernetesClusterRole.getRules().get(0).getApiGroups());
    assertEquals(2, kubernetesClusterRole.getRules().get(0).getApiGroups().size());
    assertEquals("", kubernetesClusterRole.getRules().get(0).getApiGroups().get(0));
    assertEquals("extensions", kubernetesClusterRole.getRules().get(0).getApiGroups().get(1));
    assertNotNull(kubernetesClusterRole.getRules().get(0).getResourceNames());
    assertEquals(1, kubernetesClusterRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-node", kubernetesClusterRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(kubernetesClusterRole.getRules().get(0).getResources());
    assertEquals(1, kubernetesClusterRole.getRules().get(0).getResources().size());
    assertEquals("nodes", kubernetesClusterRole.getRules().get(0).getResources().get(0));
    assertNotNull(kubernetesClusterRole.getRules().get(0).getVerbs());
    assertEquals(3, kubernetesClusterRole.getRules().get(0).getVerbs().size());
    assertEquals("get", kubernetesClusterRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", kubernetesClusterRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", kubernetesClusterRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void delete() {

    KubernetesClusterRoleList kubernetesClusterRoleListBefore = client.rbac().kubernetesClusterRoles().list();

    boolean deleted = client.rbac().kubernetesClusterRoles().withName("node-reader").delete();

    assertTrue(deleted);
    KubernetesClusterRoleList kubernetesClusterRoleListAfter = client.rbac().kubernetesClusterRoles().list();
    assertEquals(kubernetesClusterRoleListBefore.getItems().size()-1,kubernetesClusterRoleListAfter.getItems().size());
  }

  @After
  public void cleanup() {
    client.rbac().kubernetesClusterRoles().withName("node-reader").delete();
  }

}
