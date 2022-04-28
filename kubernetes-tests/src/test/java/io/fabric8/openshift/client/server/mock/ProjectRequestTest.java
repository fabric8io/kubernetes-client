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

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class ProjectRequestTest {

  KubernetesMockServer server;
  OpenShiftClient client;

  @Test
  void testCreate() {
    ProjectRequest req1 = new ProjectRequestBuilder().withApiVersion("project.openshift.io/v1")
        .withNewMetadata()
        .withName("req1")
        .and()
        .build();

    server.expect().withPath("/apis/project.openshift.io/v1/projectrequests").andReturn(201, req1).once();

    ProjectRequest result = client.projectrequests().create(req1);
    assertNotNull(result);
    assertEquals(req1, result);
  }
}
