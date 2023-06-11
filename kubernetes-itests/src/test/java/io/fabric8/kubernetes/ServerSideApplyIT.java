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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 22)
class ServerSideApplyIT {

  KubernetesClient client;

  @Test
  void testServerSideApply() {
    Service service = new ServiceBuilder()
        .withNewMetadata().withName(PatchIT.class.getSimpleName().toLowerCase() + "-svc").endMetadata()
        .withNewSpec()
        .addToSelector("app", "testapp")
        .addNewPort()
        .withProtocol("TCP")
        .withPort(80)
        .withTargetPort(new IntOrString(9376))
        .endPort()
        .endSpec()
        .build();

    Resource<Service> resource = client.services().resource(service);
    resource.delete();

    // 1st apply - create must be a server side apply - otherwise the later operations will need to force
    Service fromServer = resource.patch(PatchContext.of(PatchType.SERVER_SIDE_APPLY), service);
    assertNotNull(fromServer);
    assertEquals(1, fromServer.getSpec().getPorts().size());
    // make sure a cluster ip was assigned
    String clusterIp = fromServer.getSpec().getClusterIP();
    assertNotNull(clusterIp);

    // Modify resource
    service.getSpec().setSelector(Collections.singletonMap("app", "other"));

    // 2nd server side apply
    fromServer = client.resource(service).serverSideApply();
    assertEquals("other", fromServer.getSpec().getSelector().get("app"));
    assertEquals(clusterIp, fromServer.getSpec().getClusterIP());
  }

}
