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

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ServerSideApplyIT {

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "22");

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testServerSideApply() {
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

    Resource<Service> resource = client.services().inNamespace(session.getNamespace()).withItem(service);
    resource.delete();

    // 1st apply - create must be a server side apply - otherwise the later operations will need to force
    service = resource.patch(PatchContext.of(PatchType.SERVER_SIDE_APPLY), service);
    assertNotNull(service);
    assertEquals(1, service.getSpec().getPorts().size());
    // make sure a cluster ip was assigned
    String clusterIp = service.getSpec().getClusterIP();
    assertNotNull(clusterIp);

    // Modify resource
    service.getSpec().setSelector(Collections.singletonMap("app", "other"));

    // 2nd server side apply
    service = resource.patch(PatchContext.of(PatchType.SERVER_SIDE_APPLY), service);
    assertEquals("other", service.getSpec().getSelector().get("app"));
    assertEquals(clusterIp, service.getSpec().getClusterIP());
  }

}
