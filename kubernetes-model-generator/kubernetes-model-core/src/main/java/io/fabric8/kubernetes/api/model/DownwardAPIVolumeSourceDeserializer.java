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

public class DownwardAPIVolumeSourceDeserializer extends JsonDeserializer<DownwardAPIVolumeSource> {

  @Override
  public DownwardAPIVolumeSource deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    DownwardAPIVolumeSourceBuilder builder = new DownwardAPIVolumeSourceBuilder();
    if (node.get("items") != null) {
      for (final JsonNode keyToPathNode : node.get("items")) {
        builder.addToItems(createDownwardAPIVolumeFile(keyToPathNode, jsonParser));
      }
    }
    if (node.get("defaultMode") != null) {
      builder.withDefaultMode(createIntegerValue(node.get("defaultMode")));
    }
    return builder.build();
  }

  private DownwardAPIVolumeFile createDownwardAPIVolumeFile(JsonNode node, JsonParser jsonParser)
      throws JsonProcessingException {
    DownwardAPIVolumeFile downwardAPIVolumeFile = jsonParser.getCodec().treeToValue(node, DownwardAPIVolumeFile.class);
    DownwardAPIVolumeFileBuilder downwardAPIVolumeFileBuilder = new DownwardAPIVolumeFileBuilder(downwardAPIVolumeFile);
    if (node.get("mode") != null) {
      downwardAPIVolumeFileBuilder.withMode(createIntegerValue(node.get("mode")));
    }
    return downwardAPIVolumeFileBuilder.build();
  }
}
