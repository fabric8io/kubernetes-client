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
package io.fabric8.openshift;

import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleBuilder;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class K8sAuthorizationOnOpenShiftIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Before
  public void initialCall() {
    client.pods().inNamespace(session.getNamespace()).list();
  }

  @Test
  public void createRoleK8s() {
    // Given
    String name = "create-role-k8s";
    Role role = new RoleBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .addNewRule()
      .withApiGroups("")
      .withResources("pods")
      .withVerbs("get", "watch", "list")
      .endRule()
      .build();

    // When
    Role createdRole = client.rbac().roles().inNamespace(session.getNamespace()).create(role);

    // Then
    assertNotNull(createdRole);
    assertNotNull(createdRole.getMetadata().getUid());
    assertEquals(name, createdRole.getMetadata().getName());
    client.rbac().roles().inNamespace(session.getNamespace()).withName(name).delete();
  }

  @Test
  public void createRoleBindingK8s() {
    // Given
    String name = "create-rolebinding-k8s";
    RoleBinding roleBinding = new RoleBindingBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .addNewSubject()
      .withKind("User")
      .withName("jane")
      .withApiGroup("rbac.authorization.k8s.io")
      .endSubject()
      .withNewRoleRef()
      .withKind("Role")
      .withName("pod-reader")
      .withApiGroup("rbac.authorization.k8s.io")
      .endRoleRef()
      .build();

    // When
    RoleBinding createdRoleBinding = client.rbac().roleBindings().inNamespace(session.getNamespace()).create(roleBinding);

    // Then
    assertNotNull(createdRoleBinding);
    assertNotNull(createdRoleBinding.getMetadata().getUid());
    assertEquals(name, createdRoleBinding.getMetadata().getName());
    client.rbac().roleBindings().inNamespace(session.getNamespace()).withName(name).delete();
  }

  @Test
  public void createClusterRoleBindingK8s() {
    // Given
    String name = "create-clusterrolebinding-k8s";
    ClusterRoleBinding clusterRoleBinding = new ClusterRoleBindingBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .addNewSubject()
      .withKind("Group")
      .withName("manager")
      .withApiGroup("rbac.authorization.k8s.io")
      .endSubject()
      .withNewRoleRef()
      .withKind("ClusterRole")
      .withName("secret-reader")
      .withApiGroup("rbac.authorization.k8s.io")
      .endRoleRef()
      .build();

    // When
    ClusterRoleBinding clusterRoleBindingCreated = client.rbac().clusterRoleBindings().create(clusterRoleBinding);

    // Then
    assertNotNull(clusterRoleBindingCreated);
    assertNotNull(clusterRoleBindingCreated.getMetadata().getUid());
    assertEquals(name, clusterRoleBindingCreated.getMetadata().getName());
    client.rbac().clusterRoleBindings().inNamespace(session.getNamespace()).withName(name).delete();
  }

  @Test
  public void createClusterRoleK8s() {
    // Given
    String name = "create-clusterrole-k8s";
    ClusterRole clusterRole = new ClusterRoleBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .addNewRule()
      .withApiGroups("")
      .withResources("pods")
      .withVerbs("get", "watch", "list")
      .endRule()
      .build();

    // When
    ClusterRole createdClusterRole = client.rbac().clusterRoles().inNamespace(session.getNamespace()).create(clusterRole);

    // Then
    assertNotNull(createdClusterRole);
    assertNotNull(createdClusterRole.getMetadata().getUid());
    assertEquals(name, createdClusterRole.getMetadata().getName());
    client.rbac().clusterRoles().inNamespace(session.getNamespace()).withName(name).delete();
  }

  @Test
  public void createLocalSubjectAccessReview() {
    // Given
    User currentUser = client.currentUser();
    String namespace = session.getNamespace();
    LocalSubjectAccessReview lsar = new LocalSubjectAccessReviewBuilder()
      .withNewMetadata().withNamespace(namespace).endMetadata()
      .withNewSpec()
      .withNewResourceAttributes()
      .withNamespace(namespace)
      .withVerb("get")
      .withGroup("apps")
      .withResource("Deployment")
      .endResourceAttributes()
      .withUser(currentUser.getMetadata().getName())
      .endSpec()
      .build();

    // When
    LocalSubjectAccessReview createdLsar = client.authorization().v1().localSubjectAccessReview().inNamespace(namespace).create(lsar);

    // Then
    assertNotNull(createdLsar);
    assertTrue(createdLsar.getStatus().getAllowed());
  }

  @Test
  public void createSubjectAccessReview() {
    // Given
    String user = client.currentUser().getMetadata().getName();
    SubjectAccessReview sar = new SubjectAccessReviewBuilder()
      .withNewSpec()
      .withNewResourceAttributes()
      .withNamespace(session.getNamespace())
      .withVerb("get")
      .withResource("pods")
      .endResourceAttributes()
      .withUser(user)
      .endSpec()
      .build();

    // When
    SubjectAccessReview createSar = client.authorization().v1().subjectAccessReview().create(sar);

    // Then
    assertNotNull(createSar);
    assertTrue(createSar.getStatus().getAllowed());
  }


}
