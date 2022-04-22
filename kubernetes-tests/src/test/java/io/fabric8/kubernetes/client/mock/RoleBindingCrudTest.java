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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.RoleRefBuilder;
import io.fabric8.kubernetes.api.model.rbac.SubjectBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
public class RoleBindingCrudTest {

  private static final Logger logger = LoggerFactory.getLogger(RoleBindingCrudTest.class);

  KubernetesClient client;

  @Test
  public void crudTest() {

    RoleBinding roleBinding = new RoleBindingBuilder()
        .withNewMetadata()
        .withName("read-jobs")
        .endMetadata()
        .addToSubjects(0, new SubjectBuilder()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("User")
            .withName("jane")
            .withNamespace("default")
            .build())
        .withRoleRef(new RoleRefBuilder()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("Role")
            .withName("job-reader")
            .build())
        .build();

    //test of creation
    roleBinding = client.rbac().roleBindings().create(roleBinding);

    assertNotNull(roleBinding);
    assertEquals("RoleBinding", roleBinding.getKind());
    assertEquals("rbac.authorization.k8s.io/v1", roleBinding.getApiVersion());
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

    //test of list
    RoleBindingList kubernetesRoleBindingList = client.rbac().roleBindings().list();

    assertNotNull(kubernetesRoleBindingList);
    assertNotNull(kubernetesRoleBindingList.getItems());
    assertEquals(1, kubernetesRoleBindingList.getItems().size());
    assertNotNull(kubernetesRoleBindingList.getItems().get(0));
    assertEquals("RoleBinding", kubernetesRoleBindingList.getItems().get(0).getKind());
    assertEquals("rbac.authorization.k8s.io/v1", kubernetesRoleBindingList.getItems().get(0).getApiVersion());
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
    assertEquals("rbac.authorization.k8s.io", kubernetesRoleBindingList.getItems().get(0).getRoleRef().getApiGroup());

    //test of updation
    roleBinding = client.rbac().roleBindings().withName("read-jobs").edit(r -> new RoleBindingBuilder(r)
        .editSubject(0).withName("jane-new").endSubject().build());

    assertNotNull(roleBinding);
    assertEquals("RoleBinding", roleBinding.getKind());
    assertEquals("rbac.authorization.k8s.io/v1", roleBinding.getApiVersion());
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

    //test of deletion
    boolean deleted = client.rbac().roleBindings().delete().size() == 1;

    assertTrue(deleted);
    kubernetesRoleBindingList = client.rbac().roleBindings().list();
    assertEquals(0, kubernetesRoleBindingList.getItems().size());

  }
}
