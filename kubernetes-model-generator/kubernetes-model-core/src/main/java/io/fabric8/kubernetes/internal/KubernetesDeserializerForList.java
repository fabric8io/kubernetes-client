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

import java.util.ArrayList;
import java.util.List;

public class KubernetesDeserializerForList extends ValueDeserializer<List<KubernetesResource>> {

  private final KubernetesDeserializer kubernetesDeserializer;

  public KubernetesDeserializerForList() {
    this.kubernetesDeserializer = new KubernetesDeserializer();
  }

  @Override
  public List<KubernetesResource> deserialize(JsonParser p, DeserializationContext ctxt) {
    final JsonNode node = p.readValueAsTree();
    if (!node.isArray()) {
      throw DatabindException.from(p, "Expected array but found " + node.getNodeType());
    }
    final List<KubernetesResource> ret = new ArrayList<>();
    for (JsonNode item : node) {
      ret.add(kubernetesDeserializer.deserialize(p, ctxt, item));
    }
    return ret;
  }
}
