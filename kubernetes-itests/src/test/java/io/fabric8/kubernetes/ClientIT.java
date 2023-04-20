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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientIT {

  KubernetesClient client;

  @Test
  void getRaw() {
    String node = client.nodes().list().getItems().stream().map(n -> n.getMetadata().getName()).findFirst().orElse("minikube");
    String result = client.raw(String.format("/api/v1/nodes/%s/proxy/stats/summary", node));
    assertTrue(Serialization.unmarshal(result, Map.class).containsKey("node"));
  }

  @Test
  void postRaw() {
    String result = client.raw(String.format("/api/v1/namespaces/%s/configmaps", client.getNamespace()), "POST",
        new ConfigMapBuilder().withNewMetadata().withName("test").endMetadata().build());
    assertEquals("test", Serialization.unmarshal(result, ConfigMap.class).getMetadata().getName());
  }

}
