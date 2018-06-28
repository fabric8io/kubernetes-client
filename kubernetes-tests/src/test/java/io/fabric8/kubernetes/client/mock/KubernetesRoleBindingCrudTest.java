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

import io.fabric8.kubernetes.api.model.rbac.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class KubernetesRoleBindingCrudTest {

  private static final Logger logger = LoggerFactory.getLogger(KubernetesRoleBindingCrudTest.class);

  @Rule
  public KubernetesServer kubernetesServer = new KubernetesServer(true,true);

  @Test
  public void crudTest() {

    KubernetesClient client = kubernetesServer.getClient();

    KubernetesRoleBinding kubernetesRoleBinding = new KubernetesRoleBindingBuilder()
      .withNewMetadata()
        .withName("read-jobs")
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

    //test of creation
    kubernetesRoleBinding = client.rbac().kubernetesRoleBindings().create(kubernetesRoleBinding);

    assertNotNull(kubernetesRoleBinding);
    assertEquals("RoleBinding", kubernetesRoleBinding.getKind());
    assertEquals("rbac.authorization.k8s.io/v1", kubernetesRoleBinding.getApiVersion());
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

    //test of list
    KubernetesRoleBindingList kubernetesRoleBindingList = client.rbac().kubernetesRoleBindings().list();

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
    kubernetesRoleBinding = client.rbac().kubernetesRoleBindings().withName("read-jobs").edit()
      .editSubject(0).withName("jane-new").endSubject().done();

    assertNotNull(kubernetesRoleBinding);
    assertEquals("RoleBinding", kubernetesRoleBinding.getKind());
    assertEquals("rbac.authorization.k8s.io/v1", kubernetesRoleBinding.getApiVersion());
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

    //test of deletion
    boolean deleted = client.rbac().kubernetesRoleBindings().delete();

    assertTrue(deleted);
    kubernetesRoleBindingList = client.rbac().kubernetesRoleBindings().list();
    assertEquals(0,kubernetesRoleBindingList.getItems().size());

  }
}
