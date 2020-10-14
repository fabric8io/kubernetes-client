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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ConditionalIgnore;
import io.fabric8.commons.ConditionalIgnoreRule;
import io.fabric8.commons.K8sVersionLessThan_1_14;
import io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class IngressIT {
  @Rule
  public ConditionalIgnoreRule rule = new ConditionalIgnoreRule();

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Ingress ingress;

  @BeforeClass
  public static void init() {
    // Ignore if Kubernetes version < 1.14
    if (new K8sVersionLessThan_1_14().isSatisfied()) {
      return;
    }
    ClusterEntity.apply(IngressIT.class.getResourceAsStream("/ingress-it.yml"));
  }

  @Test
  @ConditionalIgnore(condition = K8sVersionLessThan_1_14.class)
  public void load() {
    Ingress aIngress = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).load(getClass().getResourceAsStream("/test-ingress.yml")).get();
    assertThat(aIngress).isNotNull();
    assertEquals("test-multiple-paths", aIngress.getMetadata().getName());
  }

  @Test
  @ConditionalIgnore(condition = K8sVersionLessThan_1_14.class)
  public void get() {
    ingress = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).withName("ingress-get").get();
    assertThat(ingress).isNotNull();
  }

  @Test
  @ConditionalIgnore(condition = K8sVersionLessThan_1_14.class)
  public void list() {
    IngressList aIngressList = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).list();
    assertNotNull(aIngressList);
    assertTrue(aIngressList.getItems().size() >= 1);
  }

  @Test
  @ConditionalIgnore(condition = K8sVersionLessThan_1_14.class)
  public void update() {
    ingress = client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).withName("ingress-update").edit()
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().done();

    assertNotNull(ingress);
    assertEquals("bar", ingress.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  @ConditionalIgnore(condition = K8sVersionLessThan_1_14.class)
  public void delete() {
    assertTrue(client.network().v1beta1().ingresses().inNamespace(session.getNamespace()).withName("ingress-delete").delete());
  }

  @AfterClass
  @ConditionalIgnore(condition = K8sVersionLessThan_1_14.class)
  public static void cleanup() {
    ClusterEntity.remove(IngressIT.class.getResourceAsStream("/ingress-it.yml"));
  }
}
