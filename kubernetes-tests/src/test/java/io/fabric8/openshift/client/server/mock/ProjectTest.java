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

import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectBuilder;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.api.model.ProjectListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ProjectTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/oapi/v1/projects").andReturn(200, new ProjectListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();


    OpenShiftClient client = server.getOpenshiftClient();

    ProjectList projectList = client.projects().list();
    assertNotNull(projectList);
    assertEquals(2, projectList.getItems().size());
  }


  @Test
  public void testGet() {
   server.expect().withPath("/oapi/v1/projects/project1").andReturn(200, new ProjectBuilder()
      .withNewMetadata().withName("project1").endMetadata()
      .build()).once();

   server.expect().withPath("/oapi/v1/projects/project2").andReturn(200, new ProjectBuilder()
      .withNewMetadata().withName("project2").endMetadata()
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

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
  public void testDelete() {
   server.expect().withPath("/oapi/v1/projects/project1").andReturn(200, new ProjectBuilder().build()).once();
   server.expect().withPath("/oapi/v1/projects/project2").andReturn( 200, new ProjectBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Boolean deleted = client.projects().withName("project1").delete();
    assertNotNull(deleted);

    deleted = client.projects().withName("project2").delete();
    assertTrue(deleted);

    deleted = client.projects().withName("project3").delete();
    assertFalse(deleted);
  }
}
