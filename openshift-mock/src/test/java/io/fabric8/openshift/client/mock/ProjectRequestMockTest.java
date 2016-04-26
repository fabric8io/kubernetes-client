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

package io.fabric8.openshift.client.mock;


import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import org.junit.Assert;
import org.junit.Test;

public class ProjectRequestMockTest {

  @Test
  public void testCreate() {
    ProjectRequest req1 = new ProjectRequestBuilder().withNewMetadata().withName("req1").and().build();

    OpenShiftMockClient mock = new OpenShiftMockClient();


    mock.projectrequests().create(req1).andReturn(req1).anyTimes();

    NamespacedOpenShiftClient client = mock.replay();
    ProjectRequest response = client.projectrequests().create(req1);
    Assert.assertEquals(req1, response);
  }

  @Test
  public void testList() {
    Status status = new StatusBuilder().withMessage("success").build();

    OpenShiftMockClient mock = new OpenShiftMockClient();

    mock.projectrequests().list().andReturn(status).anyTimes();

    NamespacedOpenShiftClient client = mock.replay();
    Status response = client.projectrequests().list();
    Assert.assertNotNull(response);
    Assert.assertEquals("success", response.getMessage());
  }
}
