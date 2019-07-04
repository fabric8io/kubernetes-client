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

import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleRefBuilder;
import io.fabric8.kubernetes.api.model.rbac.SubjectBuilder;
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
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RoleBindingIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private RoleBinding roleBinding;

  private String currentNamespace;

  @Before
  public void init() {

    currentNamespace = session.getNamespace();

    roleBinding = new RoleBindingBuilder()
      .withNewMetadata()
      .withName("read-jobs")
      .withLabels(Collections.singletonMap("type", "io.fabric8.roleBindingIT"))
      .endMetadata()
      .addToSubjects(0, new SubjectBuilder()
        .withApiGroup("rbac.authorization.k8s.io")
        .withKind("User")
        .withName("jane")
        .withNamespace("default")
        .build()
      )
      .withRoleRef(new RoleRefBuilder()
        .withApiGroup("rbac.authorization.k8s.io")
        .withKind("Role")
        .withName("job-reader")
        .build()
      )
      .build();

    client.rbac().roleBindings().inNamespace(currentNamespace).createOrReplace(roleBinding);
  }

  @Test
  public void get() {

    roleBinding = client.rbac().roleBindings().inNamespace(currentNamespace).withName("read-jobs").get();

    assertNotNull(roleBinding);
    assertEquals("RoleBinding", roleBinding.getKind());
    assertNotNull(roleBinding.getMetadata());
    assertEquals("read-jobs", roleBinding.getMetadata().getName());
    assertNotNull(roleBinding.getSubjects());
    assertEquals(1, roleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", roleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", roleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", roleBinding.getSubjects().get(0).getName());
    assertEquals("default", roleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(roleBinding.getRoleRef());
    assertEquals("Role", roleBinding.getRoleRef().getKind());
    assertEquals("job-reader", roleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", roleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void load() {

    RoleBinding aRoleBinding = client.rbac().roleBindings().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-kubernetesrolebinding.yml")).get();
    assertNotNull(aRoleBinding);
    assertEquals("RoleBinding", aRoleBinding.getKind());
    assertNotNull(aRoleBinding.getMetadata());
    assertEquals("read-jobs", aRoleBinding.getMetadata().getName());
    assertNotNull(aRoleBinding.getSubjects());
    assertEquals(1, aRoleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", aRoleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", aRoleBinding.getSubjects().get(0).getKind());
    assertEquals("jane", aRoleBinding.getSubjects().get(0).getName());
    assertEquals("default", aRoleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(aRoleBinding.getRoleRef());
    assertEquals("Role", aRoleBinding.getRoleRef().getKind());
    assertEquals("job-reader", aRoleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", aRoleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void list() {

    RoleBindingList roleBindingList = client.rbac().roleBindings().inNamespace(currentNamespace).withLabels(Collections.singletonMap("type", "io.fabric8.roleBindingIT")).list();

    assertNotNull(roleBindingList);
    assertNotNull(roleBindingList.getItems());
    assertEquals(1, roleBindingList.getItems().size());
    assertNotNull(roleBindingList.getItems().get(0));
    assertEquals("RoleBinding", roleBindingList.getItems().get(0).getKind());
    assertNotNull(roleBindingList.getItems().get(0).getMetadata());
    assertEquals("read-jobs", roleBindingList.getItems().get(0).getMetadata().getName());
    assertNotNull(roleBindingList.getItems().get(0).getSubjects());
    assertEquals(1, roleBindingList.getItems().get(0).getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", roleBindingList.getItems().get(0).getSubjects().get(0).getApiGroup());
    assertEquals("User", roleBindingList.getItems().get(0).getSubjects().get(0).getKind());
    assertEquals("jane", roleBindingList.getItems().get(0).getSubjects().get(0).getName());
    assertEquals("default", roleBindingList.getItems().get(0).getSubjects().get(0).getNamespace());
    assertNotNull(roleBindingList.getItems().get(0).getRoleRef());
    assertEquals("Role", roleBindingList.getItems().get(0).getRoleRef().getKind());
    assertEquals("job-reader", roleBindingList.getItems().get(0).getRoleRef().getName());

  }

  @Test
  public void update() {

    roleBinding = client.rbac().roleBindings().inNamespace(currentNamespace).withName("read-jobs").edit()
      .editSubject(0).withName("jane-new").endSubject().done();

    assertNotNull(roleBinding);
    assertEquals("RoleBinding", roleBinding.getKind());
    assertNotNull(roleBinding.getMetadata());
    assertEquals("read-jobs", roleBinding.getMetadata().getName());
    assertNotNull(roleBinding.getSubjects());
    assertEquals(1, roleBinding.getSubjects().size());
    assertEquals("rbac.authorization.k8s.io", roleBinding.getSubjects().get(0).getApiGroup());
    assertEquals("User", roleBinding.getSubjects().get(0).getKind());
    assertEquals("jane-new", roleBinding.getSubjects().get(0).getName());
    assertEquals("default", roleBinding.getSubjects().get(0).getNamespace());
    assertNotNull(roleBinding.getRoleRef());
    assertEquals("Role", roleBinding.getRoleRef().getKind());
    assertEquals("job-reader", roleBinding.getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", roleBinding.getRoleRef().getApiGroup());
  }

  @Test
  public void delete() {

    Integer initialCountBeforeDeletion = client.rbac().roleBindings().inNamespace(currentNamespace).list().getItems().size();
    boolean deleted = client.rbac().roleBindings().inNamespace(currentNamespace).withName("read-jobs").delete();

    assertTrue(deleted);

    DeleteEntity<RoleBinding> deleteEntity = new DeleteEntity<>(RoleBinding.class, client, "read-jobs", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);

    RoleBindingList roleBindingList = client.rbac().roleBindings().inNamespace(currentNamespace).list();
    assertEquals(initialCountBeforeDeletion - 1,roleBindingList.getItems().size());
  }

  @After
  public void cleanup() {
    client.rbac().roleBindings().inNamespace(currentNamespace).delete();
  }

}
