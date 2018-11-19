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

import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBindingBuilder;
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

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class KubernetesRoleBindingIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private KubernetesRoleBinding kubernetesRoleBinding;

  private String currentNamespace;

  @Before
  public void init() {

    currentNamespace = session.getNamespace();

    kubernetesRoleBinding = new KubernetesRoleBindingBuilder()
      .withNewMetadata()
      .withName("read-jobs")
      .withLabels(Collections.singletonMap("type", "io.fabric8.kubernetesRoleBindingIT"))
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
        .withKind("Role")
        .withName("job-reader")
        .build()
      )
      .build();

    client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).createOrReplace(kubernetesRoleBinding);
  }

  @Test
  public void get() {

    kubernetesRoleBinding = client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).withName("read-jobs").get();

    assertNotNull(kubernetesRoleBinding);
    assertEquals("RoleBinding", kubernetesRoleBinding.getKind());
    assertNotNull(kubernetesRoleBinding.getMetadata());
    assertEquals("read-jobs", kubernetesRoleBinding.getMetadata().getName());
    assertNotNull(kubernetesRoleBinding.getSubjects());
    assertEquals(1, kubernetesRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", kubernetesRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", kubernetesRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", kubernetesRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", kubernetesRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(kubernetesRoleBinding.getRoleRef());
    assertEquals("Role", kubernetesRoleBinding.getRoleRef().getKind());
    assertEquals("job-reader", kubernetesRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", kubernetesRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void load() {

    KubernetesRoleBinding aKubernetesRoleBinding = client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-kubernetesrolebinding.yml")).get();
    assertNotNull(aKubernetesRoleBinding);
    assertEquals("RoleBinding", aKubernetesRoleBinding.getKind());
    assertNotNull(aKubernetesRoleBinding.getMetadata());
    assertEquals("read-jobs", aKubernetesRoleBinding.getMetadata().getName());
    assertNotNull(aKubernetesRoleBinding.getSubjects());
    assertEquals(1, aKubernetesRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", aKubernetesRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", aKubernetesRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", aKubernetesRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", aKubernetesRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(aKubernetesRoleBinding.getRoleRef());
    assertEquals("Role", aKubernetesRoleBinding.getRoleRef().getKind());
    assertEquals("job-reader", aKubernetesRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", aKubernetesRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void list() {

    KubernetesRoleBindingList kubernetesRoleBindingList = client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).withLabels(Collections.singletonMap("type", "io.fabric8.kubernetesRoleBindingIT")).list();

    assertNotNull(kubernetesRoleBindingList);
    assertNotNull(kubernetesRoleBindingList.getItems());
    assertEquals(1, kubernetesRoleBindingList.getItems().size());
    assertNotNull(kubernetesRoleBindingList.getItems().get(0));
    assertEquals("RoleBinding", kubernetesRoleBindingList.getItems().get(0).getKind());
    assertNotNull(kubernetesRoleBindingList.getItems().get(0).getMetadata());
    assertEquals("read-jobs", kubernetesRoleBindingList.getItems().get(0).getMetadata().getName());
    assertNotNull(kubernetesRoleBindingList.getItems().get(0).getSubjects());
    assertEquals(1, kubernetesRoleBindingList.getItems().get(0).getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", kubernetesRoleBindingList.getItems().get(0).getSubjects().get(0).getApiGroup());
    assertEquals("User", kubernetesRoleBindingList.getItems().get(0).getSubjects().get(0).getKind());
    assertEquals("jane", kubernetesRoleBindingList.getItems().get(0).getSubjects().get(0).getName());
    assertEquals("default", kubernetesRoleBindingList.getItems().get(0).getSubjects().get(0).getNamespace());
    assertNotNull(kubernetesRoleBindingList.getItems().get(0).getRoleRef());
    assertEquals("Role", kubernetesRoleBindingList.getItems().get(0).getRoleRef().getKind());
    assertEquals("job-reader", kubernetesRoleBindingList.getItems().get(0).getRoleRef().getName());

  }

  @Test
  public void update() {

    kubernetesRoleBinding = client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).withName("read-jobs").edit()
      .editSubject(0).withName("jane-new").endSubject().done();

    assertNotNull(kubernetesRoleBinding);
    assertEquals("RoleBinding", kubernetesRoleBinding.getKind());
    assertNotNull(kubernetesRoleBinding.getMetadata());
    assertEquals("read-jobs", kubernetesRoleBinding.getMetadata().getName());
    assertNotNull(kubernetesRoleBinding.getSubjects());
    assertEquals(1, kubernetesRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", kubernetesRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", kubernetesRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane-new", kubernetesRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", kubernetesRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(kubernetesRoleBinding.getRoleRef());
    assertEquals("Role", kubernetesRoleBinding.getRoleRef().getKind());
    assertEquals("job-reader", kubernetesRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", kubernetesRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void delete() {

    boolean deleted = client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).delete();

    assertTrue(deleted);
    KubernetesRoleBindingList kubernetesRoleBindingList = client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).list();
    assertEquals(0,kubernetesRoleBindingList.getItems().size());
  }

  @After
  public void cleanup() {
    client.rbac().kubernetesRoleBindings().inNamespace(currentNamespace).delete();
  }

}
