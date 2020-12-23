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
import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ClusterRoleBindingIT {

  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ClusterRoleBindingIT.class.getResourceAsStream("/clusterrolebinding-it.yml"));
  }

  @Test
  public void get() {

    ClusterRoleBinding clusterRoleBinding = client.rbac().clusterRoleBindings().withName("read-nodes-get").get();

    assertNotNull(clusterRoleBinding);
    assertEquals("ClusterRoleBinding", clusterRoleBinding.getKind());
    assertNotNull(clusterRoleBinding.getMetadata());
    assertEquals("read-nodes-get", clusterRoleBinding.getMetadata().getName());
    assertNotNull(clusterRoleBinding.getSubjects());
    assertEquals(1, clusterRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", clusterRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", clusterRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", clusterRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", clusterRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(clusterRoleBinding.getRoleRef());
    assertEquals("ClusterRole", clusterRoleBinding.getRoleRef().getKind());
    assertEquals("secret-reader", clusterRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", clusterRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void load() {

    ClusterRoleBinding aClusterRoleBinding = client.rbac().clusterRoleBindings()
      .load(getClass().getResourceAsStream("/test-kubernetesclusterrolebinding.yml")).get();
    assertNotNull(aClusterRoleBinding);
    assertEquals("ClusterRoleBinding", aClusterRoleBinding.getKind());
    assertNotNull(aClusterRoleBinding.getMetadata());
    assertEquals("read-nodes", aClusterRoleBinding.getMetadata().getName());
    assertNotNull(aClusterRoleBinding.getSubjects());
    assertEquals(1, aClusterRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", aClusterRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", aClusterRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", aClusterRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", aClusterRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(aClusterRoleBinding.getRoleRef());
    assertEquals("ClusterRole", aClusterRoleBinding.getRoleRef().getKind());
    assertEquals("node-reader", aClusterRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", aClusterRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void list() {

    ClusterRoleBindingList clusterRoleBindingList = client.rbac().clusterRoleBindings().list();
    boolean found = false;

    assertNotNull(clusterRoleBindingList);
    assertNotNull(clusterRoleBindingList.getItems());

    for (ClusterRoleBinding clusterRoleBinding : clusterRoleBindingList.getItems())  {
      if (clusterRoleBinding.getMetadata().getName().equals("read-nodes-list"))  {
        assertEquals("ClusterRoleBinding", clusterRoleBinding.getKind());
        assertNotNull(clusterRoleBinding.getMetadata());
        assertEquals("read-nodes-list", clusterRoleBinding.getMetadata().getName());
        assertNotNull(clusterRoleBinding.getSubjects());
        assertEquals(1, clusterRoleBinding.getSubjects().size());
        assertEquals("rbac.authorization.k8s.io", clusterRoleBinding.getSubjects().get(0).getApiGroup());
        assertEquals("User", clusterRoleBinding.getSubjects().get(0).getKind());
        assertEquals("jane", clusterRoleBinding.getSubjects().get(0).getName());
        assertEquals("default", clusterRoleBinding.getSubjects().get(0).getNamespace());
        assertNotNull(clusterRoleBinding.getRoleRef());
        assertEquals("ClusterRole", clusterRoleBinding.getRoleRef().getKind());
        assertEquals("secret-reader", clusterRoleBinding.getRoleRef().getName());

        found = true;
      }
    }

    assertTrue(found);
  }

  @Test
  public void update() {

    ClusterRoleBinding clusterRoleBinding = client.rbac().clusterRoleBindings().withName("read-nodes-update").edit(c -> new ClusterRoleBindingBuilder(c)
                               .editSubject(0).withName("jane-new").endSubject().build());

    assertNotNull(clusterRoleBinding);
    assertEquals("ClusterRoleBinding", clusterRoleBinding.getKind());
    assertNotNull(clusterRoleBinding.getMetadata());
    assertEquals("read-nodes-update", clusterRoleBinding.getMetadata().getName());
    assertNotNull(clusterRoleBinding.getSubjects());
    assertEquals(1, clusterRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", clusterRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", clusterRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane-new", clusterRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", clusterRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(clusterRoleBinding.getRoleRef());
    assertEquals("ClusterRole", clusterRoleBinding.getRoleRef().getKind());
    assertEquals("secret-reader", clusterRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", clusterRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void delete() {
    ClusterRoleBindingList clusterRoleBindingListBefore = client.rbac().clusterRoleBindings().list();

    boolean deleted = client.rbac().clusterRoleBindings().withName("read-nodes-delete").delete();
    assertTrue(deleted);

    DeleteEntity<ClusterRoleBinding> clusterRoleBindingDeleteEntity = new DeleteEntity<>(ClusterRoleBinding.class, client, "read-nodes", null);
    await().atMost(30, TimeUnit.SECONDS).until(clusterRoleBindingDeleteEntity);

    ClusterRoleBindingList clusterRoleBindingListAfter = client.rbac().clusterRoleBindings().list();
    assertEquals(clusterRoleBindingListBefore.getItems().size()-1,clusterRoleBindingListAfter.getItems().size());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ClusterRoleBindingIT.class.getResourceAsStream("/clusterrolebinding-it.yml"));
  }
}
