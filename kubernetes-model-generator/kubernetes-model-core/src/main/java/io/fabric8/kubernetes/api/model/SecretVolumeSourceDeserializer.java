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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static io.fabric8.kubernetes.model.jackson.IntegerOctalHandlerUtil.createIntegerValue;

public class SecretVolumeSourceDeserializer extends JsonDeserializer<SecretVolumeSource> {

  @Override
  public SecretVolumeSource deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    SecretVolumeSourceBuilder builder = new SecretVolumeSourceBuilder();
    if (node.get("items") != null) {
      for (final JsonNode keyToPathNode : node.get("items")) {
        builder.addToItems(createKeyToPath(keyToPathNode, jsonParser));
      }
    }
    if (node.get("secretName") != null) {
      builder.withSecretName(node.get("secretName").textValue());
    }
    if (node.get("optional") != null) {
      builder.withOptional(node.get("optional").booleanValue());
    }
    if (node.get("defaultMode") != null) {
      builder.withDefaultMode(createIntegerValue(node.get("defaultMode")));
    }
    return builder.build();
  }

  private KeyToPath createKeyToPath(JsonNode node, JsonParser jsonParser) throws JsonProcessingException {
    KeyToPath keyToPath = jsonParser.getCodec().treeToValue(node, KeyToPath.class);
    KeyToPathBuilder keyToPathBuilder = new KeyToPathBuilder(keyToPath);
    if (node.get("mode") != null) {
      keyToPathBuilder.withMode(createIntegerValue(node.get("mode")));
    }
    return keyToPathBuilder.build();
  }
}
