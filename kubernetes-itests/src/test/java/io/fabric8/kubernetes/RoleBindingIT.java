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
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RoleBindingIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(RoleBindingIT.class.getResourceAsStream("/rolebinding-it.yml"));
  }

  @Test
  public void get() {

    RoleBinding roleBinding = client.rbac().roleBindings().inNamespace(session.getNamespace()).withName("rb-get").get();

    assertNotNull(roleBinding);
    assertEquals("RoleBinding", roleBinding.getKind());
    assertNotNull(roleBinding.getMetadata());
    assertEquals("rb-get", roleBinding.getMetadata().getName());
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

    RoleBinding aRoleBinding = client.rbac().roleBindings().inNamespace(session.getNamespace())
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

    RoleBindingList roleBindingList = client.rbac().roleBindings().inNamespace(session.getNamespace()).withLabels(Collections.singletonMap("type", "io.fabric8.roleBindingIT")).list();

    assertNotNull(roleBindingList);
    assertNotNull(roleBindingList.getItems());
    assertEquals(1, roleBindingList.getItems().size());
    assertNotNull(roleBindingList.getItems().get(0));
    assertEquals("RoleBinding", roleBindingList.getItems().get(0).getKind());
    assertNotNull(roleBindingList.getItems().get(0).getMetadata());
    assertEquals("rb-list", roleBindingList.getItems().get(0).getMetadata().getName());
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

    RoleBinding roleBinding = client.rbac().roleBindings().inNamespace(session.getNamespace()).withName("rb-update").edit(r -> new RoleBindingBuilder(r)
                        .editSubject(0).withName("jane-new").endSubject().build());

    assertNotNull(roleBinding);
    assertEquals("RoleBinding", roleBinding.getKind());
    assertNotNull(roleBinding.getMetadata());
    assertEquals("rb-update", roleBinding.getMetadata().getName());
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

    int initialCountBeforeDeletion = client.rbac().roleBindings().inNamespace(session.getNamespace()).list().getItems().size();
    boolean deleted = client.rbac().roleBindings().inNamespace(session.getNamespace()).withName("rb-delete").delete();

    assertTrue(deleted);

    DeleteEntity<RoleBinding> deleteEntity = new DeleteEntity<>(RoleBinding.class, client, "read-jobs", session.getNamespace());
    await().atMost(60, TimeUnit.SECONDS).until(deleteEntity);

    RoleBindingList roleBindingList = client.rbac().roleBindings().inNamespace(session.getNamespace()).list();
    assertEquals(initialCountBeforeDeletion - 1,roleBindingList.getItems().size());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(RoleBindingIT.class.getResourceAsStream("/rolebinding-it.yml"));
  }
}
