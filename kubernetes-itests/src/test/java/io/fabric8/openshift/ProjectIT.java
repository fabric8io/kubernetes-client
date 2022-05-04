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

import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(Project.class)
class ProjectIT {

  OpenShiftClient client;

  @Test
  void testCreateReadDelete() {
    // Given
    String name = "projectit-createreaddelete";
    Project project = new ProjectBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .build();

    // Create
    Project createdProject = client.projects().createOrReplace(project);
    assertNotNull(createdProject);

    // Read
    Project projectFromServer = client.projects().withName(name).get();
    assertNotNull(projectFromServer);
    assertEquals(name, projectFromServer.getMetadata().getName());

    // Delete
    assertTrue(client.projects().withName(name).delete().size() == 1);
  }

  @Test
  void createProjectAlongWithRoleBindings() {
    // Given
    String name = "projectit-createrolebindings";
    String displayName = "ProjectIT CreateRoleBindings";
    String description = "test project description";
    String requestingUser = "request-user";
    String adminUser = "admin-user";

    // When
    List<HasMetadata> itemsCreated = client.projects().createProjectAndRoleBindings(name, description, displayName, adminUser,
        requestingUser);

    // Then
    Project createdProject = client.projects().withName(name).get();
    assertEquals(5, itemsCreated.size());
    assertNotNull(createdProject);
    assertEquals(name, createdProject.getMetadata().getName());
    assertEquals(displayName, createdProject.getMetadata().getAnnotations().get("openshift.io/display-name"));
    assertEquals(description, createdProject.getMetadata().getAnnotations().get("openshift.io/description"));
    assertEquals(requestingUser, createdProject.getMetadata().getAnnotations().get("openshift.io/requester"));
    assertTrue(client.projects().withName(name).delete().size() == 1);
  }
}
