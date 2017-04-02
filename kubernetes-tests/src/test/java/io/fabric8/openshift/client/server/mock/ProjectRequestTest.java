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

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProjectRequestTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/oapi/v1/projectrequests").andReturn(200, new StatusBuilder().withMessage("success").build()).once();
    OpenShiftClient client = server.getOpenshiftClient();

    Status status = client.projectrequests().list();
    assertNotNull(status);
    assertEquals("success", status.getMessage());
  }



  @Test
  public void testCreate() {
    ProjectRequest req1 = new ProjectRequestBuilder().withNewMetadata().withName("req1").and().build();

   server.expect().withPath("/oapi/v1/projectrequests").andReturn(201, req1).once();

    OpenShiftClient client = server.getOpenshiftClient();

    ProjectRequest result = client.projectrequests().create(req1);
    assertNotNull(result);
    assertEquals(req1, result);
  }
}
