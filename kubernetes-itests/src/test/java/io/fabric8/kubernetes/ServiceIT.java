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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ServiceIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testLoad() {
    String currentNamespace = session.getNamespace();
    Service aService = client.services().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-service.yml")).get();
    assertThat(aService).isNotNull();
    assertEquals("my-service", aService.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    String currentNamespace = session.getNamespace();
    Service svc1 = new ServiceBuilder()
      .withNewMetadata().withName("svc1").endMetadata()
      .withNewSpec().withSelector(Collections.singletonMap("app", "MyApp")).addNewPort().withName("http").withProtocol("TCP").withPort(80).withTargetPort(new IntOrString(9376)).endPort().endSpec()
      .build();
    Service svc2 = new ServiceBuilder()
      .withNewMetadata().withName("svc2").endMetadata()
      .withNewSpec().withType("ExternalName").withExternalName("my.database.example.com").endSpec()
      .build();

    client.services().inNamespace(currentNamespace).create(svc1);
    client.services().inNamespace(currentNamespace).create(svc2);

    ServiceList aServiceList = client.services().inNamespace(currentNamespace).list();
    assertThat(aServiceList).isNotNull();
    assertEquals(2, aServiceList.getItems().size());

    svc1 = client.services().inNamespace(currentNamespace).withName("svc1").edit()
      .editSpec().addNewPort().withName("https").withProtocol("TCP").withPort(443).withTargetPort(new IntOrString(9377)).endPort().endSpec()
      .done();
    assertThat(svc1).isNotNull();
    assertEquals(2, svc1.getSpec().getPorts().size());

    boolean bDeleted = client.services().inNamespace(currentNamespace).withName("svc2").delete();
    assertTrue(bDeleted);
  }
}
