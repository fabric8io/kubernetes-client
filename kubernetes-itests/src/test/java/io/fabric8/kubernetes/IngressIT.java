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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1.IngressBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
@LoadKubernetesManifests("/ingress-it.yml")
class IngressIT {

  KubernetesClient client;

  @Test
  void load() {
    Ingress aIngress = client.network().v1().ingresses().load(getClass().getResourceAsStream("/test-ingress.yml")).item();
    assertThat(aIngress).isNotNull();
    assertEquals("test-multiple-paths", aIngress.getMetadata().getName());
  }

  @Test
  void get() {
    Ingress ingress = client.network().v1().ingresses().withName("ingress-get").get();
    assertThat(ingress).isNotNull();
  }

  @Test
  void list() {
    IngressList aIngressList = client.network().v1().ingresses().list();
    assertNotNull(aIngressList);
    assertTrue(aIngressList.getItems().size() >= 1);
  }

  @Test
  void update() {
    Ingress ingress = client.network().v1().ingresses().withName("ingress-update").edit(i -> new IngressBuilder(i)
        .editMetadata().withResourceVersion(null).addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(ingress);
    assertEquals("bar", ingress.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  void delete() {
    assertTrue(client.network().v1().ingresses().withName("ingress-delete").delete().size() == 1);
  }

}
