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

import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class KubernetesOperationTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testDelete() {
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/rc1")
        .andReturn(200, new ReplicationControllerBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();

    boolean deleted = client.replicationControllers().withName("rc1").cascading(false).delete().size() == 1;
    assertTrue(deleted);

    deleted = client.pods().withName("pod1").cascading(false).delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  void testDeleteWithAdapt() {
    server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/rc1")
        .andReturn(200, new ReplicationControllerBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
    server.expect().withPath("/apis").andReturn(200, new APIGroupListBuilder()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("autoscaling.k8s.io")
        .endGroup()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("security.openshift.io")
        .endGroup()
        .build()).once();
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/test/buildconfigs/bc1")
        .andReturn(200, new BuildConfigBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();

    boolean deleted = client.replicationControllers().withName("rc1").cascading(false).delete().size() == 1;
    assertTrue(deleted);

    deleted = client.pods().withName("pod1").cascading(false).delete().size() == 1;
    assertTrue(deleted);

    OpenShiftClient oclient = client.adapt(OpenShiftClient.class);

    deleted = oclient.buildConfigs().withName("bc1").cascading(false).delete().size() == 1;
    assertTrue(deleted);

    deleted = oclient.pods().withName("pod1").cascading(false).delete().size() == 1;
    assertTrue(deleted);
  }

}
