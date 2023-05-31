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
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RequireK8sSupport(ProjectRequest.class)
class ProjectRequestIT {

  OpenShiftClient client;

  @Test
  void create() throws Exception {
    // Given
    String name = "projectrequestit-create";
    ProjectRequest projectRequest = new ProjectRequestBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withDisplayName("ProjectRequestIT Create")
        .withDescription("Testing")
        .build();

    // When
    client.projectrequests().create(projectRequest);

    // Then
    try {
      client.projects()
          .withName(name)
          .informOnCondition(pl -> pl.stream().anyMatch(p -> p.getMetadata().getName().equals(name)))
          .get(30, TimeUnit.SECONDS);
    } catch (TimeoutException e) {
      System.out.println("Waited for project to be created, but it might not have been or the project watch is suspect");
    }
    final Project createdProject = client.projects().withName(name).get();
    assertNotNull(createdProject);
    assertEquals(name, createdProject.getMetadata().getName());
    assertEquals("Testing", createdProject.getMetadata().getAnnotations().get("openshift.io/description"));
    assertEquals("ProjectRequestIT Create", createdProject.getMetadata().getAnnotations().get("openshift.io/display-name"));
    assertEquals(1, client.projects().withName(name).delete().size());
  }
}
