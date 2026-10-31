/*
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
package io.fabric8.kubernetes.internal;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

import java.util.Map;

public class KubernetesDeserializerForMap extends ValueDeserializer<Map<String, KubernetesResource>> {

  private final KubernetesDeserializer kubernetesDeserializer;

  public KubernetesDeserializerForMap() {
    this.kubernetesDeserializer = new KubernetesDeserializer();
  }

  @Override
  public Map<String, KubernetesResource> deserialize(JsonParser p, DeserializationContext ctxt) {
    final JsonNode node = p.readValueAsTree();
    if (!node.isObject()) {
      throw DatabindException.from(p, "Expected map but found " + node.getNodeType());
    }
    final Map<String, KubernetesResource> ret = new java.util.LinkedHashMap<>();
    for (Map.Entry<String, JsonNode> entry : node.properties()) {
      ret.put(entry.getKey(), kubernetesDeserializer.deserialize(p, ctxt, entry.getValue()));
    }
    return ret;
  }
}
