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
import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressBuilder;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class IngressIT {

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "14");

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(IngressIT.class.getResourceAsStream("/ingress-it.yml"));
  }

  @Test
  public void load() {
    Ingress aIngress = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).load(getClass().getResourceAsStream("/test-ingress.yml")).get();
    assertThat(aIngress).isNotNull();
    assertEquals("test-multiple-paths", aIngress.getMetadata().getName());
  }

  @Test
  public void get() {
    Ingress ingress = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).withName("ingress-get").get();
    assertThat(ingress).isNotNull();
  }

  @Test
  public void list() {
    IngressList aIngressList = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).list();
    assertNotNull(aIngressList);
    assertTrue(aIngressList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    Ingress ingress = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).withName("ingress-update").edit(i -> new IngressBuilder(i)
                    .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(ingress);
    assertEquals("bar", ingress.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).withName("ingress-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(IngressIT.class.getResourceAsStream("/ingress-it.yml"));
  }
}
