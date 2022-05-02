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

package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectBuilder;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.api.model.ProjectListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ProjectTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/project.openshift.io/v1/projects").andReturn(200, new ProjectListBuilder()
        .addNewItem().and()
        .addNewItem().and().build()).once();

    ProjectList projectList = client.projects().list();
    assertNotNull(projectList);
    assertEquals(2, projectList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/project.openshift.io/v1/projects/project1").andReturn(200, new ProjectBuilder()
        .withNewMetadata().withName("project1").endMetadata()
        .build()).once();

    server.expect().withPath("/apis/project.openshift.io/v1/projects/project2").andReturn(200, new ProjectBuilder()
        .withNewMetadata().withName("project2").endMetadata()
        .build()).once();

    Project project = client.projects().withName("project1").get();
    assertNotNull(project);
    assertEquals("project1", project.getMetadata().getName());

    project = client.projects().withName("project2").get();
    assertNotNull(project);
    assertEquals("project2", project.getMetadata().getName());

    project = client.projects().withName("project3").get();
    assertNull(project);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/apis/project.openshift.io/v1/projects/project1").andReturn(200, new ProjectBuilder().build())
        .once();
    server.expect().withPath("/apis/project.openshift.io/v1/projects/project2").andReturn(200, new ProjectBuilder().build())
        .once();

    boolean deleted = client.projects().withName("project1").delete().size() == 1;

    deleted = client.projects().withName("project2").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.projects().withName("project3").delete().size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testCreateProjectAndRoleBindings() {
    // Given
    String name = "test-project";
    String displayName = "test-project";
    String description = "test project";
    String requestingUser = "request-user";
    String adminUser = "admin-user";
    server.expect().post().withPath("/apis/project.openshift.io/v1/projects")
        .andReturn(HttpURLConnection.HTTP_CREATED, new ProjectBuilder()
            .withNewMetadata()
            .addToAnnotations("openshift.io/description", description)
            .addToAnnotations("openshift.io/display-name", displayName)
            .addToAnnotations("openshift.io/requester", requestingUser)
            .withName("test-project")
            .endMetadata()
            .build())
        .once();
    server.expect().post().withPath("/apis/rbac.authorization.k8s.io/v1/namespaces/test-project/rolebindings")
        .andReturn(HttpURLConnection.HTTP_CREATED, new RoleBindingBuilder()
            .withNewMetadata()
            .addToAnnotations("openshift.io/description",
                "Allows all pods in this namespace to pull images from this namespace.  It is auto-managed by a controller; remove subjects to disable.")
            .withName("system:image-pullers")
            .withNamespace(name)
            .endMetadata()
            .withNewRoleRef()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("ClusterRole")
            .withName("system:image-puller")
            .endRoleRef()
            .addNewSubject()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("Group")
            .withName("system:serviceaccounts:" + name)
            .endSubject()
            .build())
        .once();
    server.expect().post().withPath("/apis/rbac.authorization.k8s.io/v1/namespaces/test-project/rolebindings")
        .andReturn(HttpURLConnection.HTTP_CREATED, new RoleBindingBuilder()
            .withNewMetadata()
            .addToAnnotations("openshift.io/description", "Allows builds in this namespace to push images to" +
                "this namespace.  It is auto-managed by a controller; remove subjects to disable.")
            .withName("system:image-builders")
            .withNamespace(name)
            .endMetadata()
            .withNewRoleRef()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("ClusterRole")
            .withName("system:image-builder")
            .endRoleRef()
            .addNewSubject()
            .withKind("ServiceAccount")
            .withName("builder")
            .withNamespace(name)
            .endSubject()
            .build())
        .once();
    server.expect().post().withPath("/apis/rbac.authorization.k8s.io/v1/namespaces/test-project/rolebindings")
        .andReturn(HttpURLConnection.HTTP_CREATED, new RoleBindingBuilder()
            .withNewMetadata()
            .addToAnnotations("openshift.io/description", " Allows deploymentconfigs in this namespace to rollout" +
                " pods in this namespace.  It is auto-managed by a controller; remove subjects" +
                " to disable.")
            .withName("system:deployers")
            .withNamespace(name)
            .endMetadata()
            .withNewRoleRef()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("ClusterRole")
            .withName("system:deployer")
            .endRoleRef()
            .addNewSubject()
            .withKind("ServiceAccount")
            .withName("deployer")
            .withNamespace(name)
            .endSubject()
            .build())
        .once();
    server.expect().post().withPath("/apis/rbac.authorization.k8s.io/v1/namespaces/test-project/rolebindings")
        .andReturn(HttpURLConnection.HTTP_CREATED, new RoleBindingBuilder()
            .withNewMetadata()
            .withName("admin")
            .withNamespace(name)
            .endMetadata()
            .withNewRoleRef()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("ClusterRole")
            .withName("admin")
            .endRoleRef()
            .addNewSubject()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("User")
            .withName(adminUser)
            .endSubject()
            .build())
        .once();

    // When
    List<HasMetadata> result = client.projects().createProjectAndRoleBindings(name, description, displayName, adminUser,
        requestingUser);

    // Then
    assertNotNull(result);
    assertEquals(5, result.size());
  }
}
