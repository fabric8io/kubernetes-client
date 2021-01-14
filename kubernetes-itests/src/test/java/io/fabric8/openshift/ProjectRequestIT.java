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

import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class ProjectRequestIT {
  @ArquillianResource
  OpenShiftClient client;

  @Test
  public void create() {
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
    Resource<Project> projectOp = client.projects().withName(name);
    await().atMost(1, TimeUnit.SECONDS).until(() -> projectOp.get() != null);
    Project createdProject = projectOp.get();
    assertNotNull(createdProject);
    assertEquals(name, createdProject.getMetadata().getName());
    assertEquals("Testing", createdProject.getMetadata().getAnnotations().get("openshift.io/description"));
    assertEquals("ProjectRequestIT Create", createdProject.getMetadata().getAnnotations().get("openshift.io/display-name"));
    assertTrue(client.projects().withName(name).delete());
  }
}
