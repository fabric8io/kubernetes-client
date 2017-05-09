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

import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KubernetesOperationTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testDelete() {
   server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/rc1").andReturn(200, new ReplicationControllerBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Boolean deleted = client.replicationControllers().withName("rc1").cascading(false).delete();
    assertTrue(deleted);

    deleted = client.pods().withName("pod1").cascading(false).delete();
    assertTrue(deleted);
  }

  @Test
  public void testDeleteWithAdapt() {
   server.expect().withPath("/api/v1/namespaces/test/replicationcontrollers/rc1").andReturn(200, new ReplicationControllerBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/test/buildconfigs/bc1").andReturn(200, new BuildConfigBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();

    try (KubernetesClient client = server.getKubernetesClient()) {
      Boolean deleted = client.replicationControllers().withName("rc1").cascading(false).delete();
      assertTrue(deleted);

      deleted = client.pods().withName("pod1").cascading(false).delete();
      assertTrue(deleted);

      OpenShiftClient oclient = client.adapt(OpenShiftClient.class);

      deleted = oclient.buildConfigs().withName("bc1").cascading(false).delete();
      assertTrue(deleted);

      deleted = oclient.pods().withName("pod1").cascading(false).delete();
      assertTrue(deleted);
    }
  }

}
