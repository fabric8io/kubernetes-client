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

import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;
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
class ClusterRoleBindingCrudTest {

  private static final Logger logger = LoggerFactory.getLogger(ClusterRoleBindingCrudTest.class);

  KubernetesClient client;

  @Test
  void crudTest() {

    ClusterRoleBinding kubernetesClusterRoleBinding = new ClusterRoleBindingBuilder()
        .withNewMetadata()
        .withName("read-nodes")
        .endMetadata()
        .addToSubjects(0, new SubjectBuilder()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("User")
            .withName("jane")
            .withNamespace("default")
            .build())
        .withRoleRef(new RoleRefBuilder()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("ClusterRole")
            .withName("node-reader")
            .build())
        .build();

    //test of creation
    kubernetesClusterRoleBinding = client.rbac().clusterRoleBindings().create(kubernetesClusterRoleBinding);

    assertNotNull(kubernetesClusterRoleBinding);
    assertEquals("ClusterRoleBinding", kubernetesClusterRoleBinding.getKind());
    assertEquals("rbac.authorization.k8s.io/v1", kubernetesClusterRoleBinding.getApiVersion());
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

    //test of list
    ClusterRoleBindingList kubernetesClusterRoleBindingList = client.rbac().clusterRoleBindings().list();

    assertNotNull(kubernetesClusterRoleBindingList);
    assertNotNull(kubernetesClusterRoleBindingList.getItems());
    assertEquals(1, kubernetesClusterRoleBindingList.getItems().size());
    assertNotNull(kubernetesClusterRoleBindingList.getItems().get(0));
    assertEquals("ClusterRoleBinding", kubernetesClusterRoleBindingList.getItems().get(0).getKind());
    assertEquals("rbac.authorization.k8s.io/v1", kubernetesClusterRoleBindingList.getItems().get(0).getApiVersion());
    assertNotNull(kubernetesClusterRoleBindingList.getItems().get(0).getMetadata());
    assertEquals("read-nodes", kubernetesClusterRoleBindingList.getItems().get(0).getMetadata().getName());
    assertNotNull(kubernetesClusterRoleBindingList.getItems().get(0).getSubjects());
    assertEquals(1, kubernetesClusterRoleBindingList.getItems().get(0).getSubjects().size());
    assertEquals("rbac.authorization.k8s.io",
        kubernetesClusterRoleBindingList.getItems().get(0).getSubjects().get(0).getApiGroup());
    assertEquals("User", kubernetesClusterRoleBindingList.getItems().get(0).getSubjects().get(0).getKind());
    assertEquals("jane", kubernetesClusterRoleBindingList.getItems().get(0).getSubjects().get(0).getName());
    assertEquals("default", kubernetesClusterRoleBindingList.getItems().get(0).getSubjects().get(0).getNamespace());
    assertNotNull(kubernetesClusterRoleBindingList.getItems().get(0).getRoleRef());
    assertEquals("ClusterRole", kubernetesClusterRoleBindingList.getItems().get(0).getRoleRef().getKind());
    assertEquals("node-reader", kubernetesClusterRoleBindingList.getItems().get(0).getRoleRef().getName());
    assertEquals("rbac.authorization.k8s.io", kubernetesClusterRoleBindingList.getItems().get(0).getRoleRef().getApiGroup());

    //test of updation
    kubernetesClusterRoleBinding = client.rbac().clusterRoleBindings().withName("read-nodes")
        .edit(c -> new ClusterRoleBindingBuilder(c)
            .editSubject(0).withName("jane-new").endSubject().build());

    assertNotNull(kubernetesClusterRoleBinding);
    assertEquals("ClusterRoleBinding", kubernetesClusterRoleBinding.getKind());
    assertEquals("rbac.authorization.k8s.io/v1", kubernetesClusterRoleBinding.getApiVersion());
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

    //test of deletion
    boolean deleted = client.rbac().clusterRoleBindings().delete().size() == 1;

    assertTrue(deleted);
    kubernetesClusterRoleBindingList = client.rbac().clusterRoleBindings().list();
    assertEquals(0, kubernetesClusterRoleBindingList.getItems().size());

  }
}
