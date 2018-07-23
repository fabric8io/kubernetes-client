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

import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.KubernetesClusterRoleBindingList;

import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleRefBuilder;
import io.fabric8.kubernetes.api.model.rbac.KubernetesSubjectBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class KubernetesClusterRoleBindingIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private KubernetesClusterRoleBinding kubernetesClusterRoleBinding;

  @Before
  public void init() {

    // Do not run tests on opeshift 3.6.0 and 3.6.1
    assumeFalse(client.getVersion().getMajor().equalsIgnoreCase("1")
      && client.getVersion().getMinor().startsWith("6"));

    kubernetesClusterRoleBinding = new KubernetesClusterRoleBindingBuilder()
      .withNewMetadata()
      .withName("read-nodes")
      .endMetadata()
      .addToSubjects(0, new KubernetesSubjectBuilder()
        .withApiGroup("rbac.authorization.k8s.io")
        .withKind("User")
        .withName("jane")
        .withNamespace("default")
        .build()
      )
      .withRoleRef(new KubernetesRoleRefBuilder()
        .withApiGroup("rbac.authorization.k8s.io")
        .withKind("ClusterRole")
        .withName("node-reader")
        .build()
      )
      .build();

    client.rbac().kubernetesClusterRoleBindings().createOrReplace(kubernetesClusterRoleBinding);
  }

  @Test
  public void get() {

    kubernetesClusterRoleBinding = client.rbac().kubernetesClusterRoleBindings().withName("read-nodes").get();

    assertNotNull(kubernetesClusterRoleBinding);
    assertEquals("ClusterRoleBinding", kubernetesClusterRoleBinding.getKind());
    assertNotNull(kubernetesClusterRoleBinding.getMetadata());
    assertEquals("read-nodes", kubernetesClusterRoleBinding.getMetadata().getName());
    assertNotNull(kubernetesClusterRoleBinding.getSubjects());
    assertEquals(1, kubernetesClusterRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", kubernetesClusterRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", kubernetesClusterRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", kubernetesClusterRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", kubernetesClusterRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(kubernetesClusterRoleBinding.getRoleRef());
    assertEquals("ClusterRole", kubernetesClusterRoleBinding.getRoleRef().getKind());
    assertEquals("node-reader", kubernetesClusterRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", kubernetesClusterRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void load() {

    KubernetesClusterRoleBinding aKubernetesClusterRoleBinding = client.rbac().kubernetesClusterRoleBindings()
      .load(getClass().getResourceAsStream("/test-kubernetesclusterrolebinding.yml")).get();
    assertNotNull(aKubernetesClusterRoleBinding);
    assertEquals("ClusterRoleBinding", aKubernetesClusterRoleBinding.getKind());
    assertNotNull(aKubernetesClusterRoleBinding.getMetadata());
    assertEquals("read-nodes", aKubernetesClusterRoleBinding.getMetadata().getName());
    assertNotNull(aKubernetesClusterRoleBinding.getSubjects());
    assertEquals(1, aKubernetesClusterRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", aKubernetesClusterRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", aKubernetesClusterRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", aKubernetesClusterRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", aKubernetesClusterRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(aKubernetesClusterRoleBinding.getRoleRef());
    assertEquals("ClusterRole", aKubernetesClusterRoleBinding.getRoleRef().getKind());
    assertEquals("node-reader", aKubernetesClusterRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", aKubernetesClusterRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void list() {

    KubernetesClusterRoleBindingList kubernetesClusterRoleBindingList = client.rbac().kubernetesClusterRoleBindings().list();
    boolean found = false;

    assertNotNull(kubernetesClusterRoleBindingList);
    assertNotNull(kubernetesClusterRoleBindingList.getItems());

    for (KubernetesClusterRoleBinding kubernetesClusterRoleBinding : kubernetesClusterRoleBindingList.getItems())  {
      if (kubernetesClusterRoleBinding.getMetadata().getName().equals("read-nodes"))  {
        assertEquals("ClusterRoleBinding", kubernetesClusterRoleBinding.getKind());
        assertNotNull(kubernetesClusterRoleBinding.getMetadata());
        assertEquals("read-nodes", kubernetesClusterRoleBinding.getMetadata().getName());
        assertNotNull(kubernetesClusterRoleBinding.getSubjects());
        assertEquals(1, kubernetesClusterRoleBinding.getSubjects().size());
        assertEquals("rbac.authorization.k8s.io", kubernetesClusterRoleBinding.getSubjects().get(0).getApiGroup());
        assertEquals("User", kubernetesClusterRoleBinding.getSubjects().get(0).getKind());
        assertEquals("jane", kubernetesClusterRoleBinding.getSubjects().get(0).getName());
        assertEquals("default", kubernetesClusterRoleBinding.getSubjects().get(0).getNamespace());
        assertNotNull(kubernetesClusterRoleBinding.getRoleRef());
        assertEquals("ClusterRole", kubernetesClusterRoleBinding.getRoleRef().getKind());
        assertEquals("node-reader", kubernetesClusterRoleBinding.getRoleRef().getName());

        found = true;
      }
    }

    assertEquals(true, found);

  }

  @Test
  public void update() {

    kubernetesClusterRoleBinding = client.rbac().kubernetesClusterRoleBindings().withName("read-nodes").edit()
      .editSubject(0).withName("jane-new").endSubject().done();

    assertNotNull(kubernetesClusterRoleBinding);
    assertEquals("ClusterRoleBinding", kubernetesClusterRoleBinding.getKind());
    assertNotNull(kubernetesClusterRoleBinding.getMetadata());
    assertEquals("read-nodes", kubernetesClusterRoleBinding.getMetadata().getName());
    assertNotNull(kubernetesClusterRoleBinding.getSubjects());
    assertEquals(1, kubernetesClusterRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", kubernetesClusterRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", kubernetesClusterRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane-new", kubernetesClusterRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", kubernetesClusterRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(kubernetesClusterRoleBinding.getRoleRef());
    assertEquals("ClusterRole", kubernetesClusterRoleBinding.getRoleRef().getKind());
    assertEquals("node-reader", kubernetesClusterRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", kubernetesClusterRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void delete() {

    KubernetesClusterRoleBindingList kubernetesClusterRoleBindingListBefore = client.rbac().kubernetesClusterRoleBindings().list();

    boolean deleted = client.rbac().kubernetesClusterRoleBindings().withName("read-nodes").delete();

    assertTrue(deleted);
    KubernetesClusterRoleBindingList kubernetesClusterRoleBindingListAfter = client.rbac().kubernetesClusterRoleBindings().list();
    assertEquals(kubernetesClusterRoleBindingListBefore.getItems().size()-1,kubernetesClusterRoleBindingListAfter.getItems().size());

  }

  @After
  public void cleanup() {
    client.rbac().kubernetesClusterRoleBindings().withName("read-nodes").delete();
  }

}
