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
import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceBuilder;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@LoadKubernetesManifests("/apiservice-it.yml")
@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 16)
class APIServiceIT {

  KubernetesClient client;

  @BeforeEach
  void ensureExists() {
    Awaitility.await().atMost(30, TimeUnit.SECONDS)
        .until(() -> client.apiServices().withName("v1.tests.example.com").get() != null);
  }

  @Test
  void get() {
    APIService result = client.apiServices().withName("v1.tests.example.com").get();
    assertThat(result)
        .hasFieldOrPropertyWithValue("spec.group", "tests.example.com")
        .hasFieldOrPropertyWithValue("spec.version", "v1");
  }

  @Test
  void list() {
    APIServiceList result = client.apiServices().list();
    assertThat(result).extracting(APIServiceList::getItems)
        .asInstanceOf(InstanceOfAssertFactories.list(APIService.class))
        .anyMatch(t -> t.getMetadata().getName().equals("v1.tests.example.com"));
  }

  @Test
  void update() {
    APIService result = client.apiServices().withName("v1.tests.example.com")
        .edit(c -> new APIServiceBuilder(c)
            .editOrNewMetadata().withResourceVersion(null).addToAnnotations("foo", "bar").endMetadata()
            .build());
    assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.annotations.foo", "bar")
        .hasFieldOrPropertyWithValue("spec.group", "tests.example.com")
        .hasFieldOrPropertyWithValue("spec.version", "v1");
  }

  @Test
  @Disabled(value = "https://github.com/fabric8io/kubernetes-client/issues/3668")
  void delete() {
    assertThat(client.apiServices().withName("v1beta1.delete.fabric8.io").delete().size() == 1).isTrue();
  }
}
