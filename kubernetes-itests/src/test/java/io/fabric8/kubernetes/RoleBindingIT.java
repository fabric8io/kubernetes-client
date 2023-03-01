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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/rolebinding-it.yml")
class RoleBindingIT {

  KubernetesClient client;

  Namespace namespace;

  @Test
  void get() {

    RoleBinding roleBinding = client.rbac().roleBindings().withName("rb-get").get();

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
  void load() {

    RoleBinding aRoleBinding = client.rbac().roleBindings()
        .load(getClass().getResourceAsStream("/test-kubernetesrolebinding.yml")).item();
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
  void list() {

    RoleBindingList roleBindingList = client.rbac().roleBindings()
        .withLabels(Collections.singletonMap("type", "io.fabric8.roleBindingIT")).list();

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
  void update() {

    RoleBinding roleBinding = client.rbac().roleBindings().withName("rb-update").edit(r -> new RoleBindingBuilder(r)
        .editMetadata().withResourceVersion(null).endMetadata()
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
  void delete() {
    boolean deleted = client.rbac().roleBindings().withName("rb-delete").delete().size() == 1;

    assertTrue(deleted);

    client.rbac().roleBindings().withName("rb-delete")
        .waitUntilCondition(rb -> rb == null || rb.getMetadata().getDeletionTimestamp() != null, 30, TimeUnit.SECONDS);
  }

}
