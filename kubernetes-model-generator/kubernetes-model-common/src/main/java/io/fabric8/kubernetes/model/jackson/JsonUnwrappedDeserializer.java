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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Desc: this is a workaround on the problem that Jackson's @JsonUnwrapped doesn't work with
 * polymorphism (@JsonTypeInfo)
 * Adapted from https://stackoverflow.com/questions/37423848/deserializing-polymorphic-types-with-jsonunwrapped-using-jackson
 */
public class JsonUnwrappedDeserializer<T> extends JsonDeserializer<T> implements ContextualDeserializer {

  private static JsonUnwrapped cancelUnwrappedAnnotation;

  static {
    try {
      cancelUnwrappedAnnotation = CancelUnwrapped.class.getField("dummy").getAnnotation(JsonUnwrapped.class);
    } catch (NoSuchFieldException ex) {
      // this exception will never happen, though:
      throw new RuntimeException(ex);
    }
  }

  private JsonDeserializer<T> beanDeserializer;
  private Set<String> ownPropertyNames;
  private String unwrappedPropertyName;
  private NameTransformer nameTransformer;

  /*
   * Needed by Jackson
   */
  public JsonUnwrappedDeserializer() {
  }

  public JsonUnwrappedDeserializer(DeserializationContext deserializationContext) throws JsonMappingException {
    JavaType type = deserializationContext.getContextualType();

    BeanDescription description = deserializationContext.getConfig().introspect(type);

    final JsonUnwrapped[] tempUnwrappedAnnotation = { null };

    List<BeanPropertyDefinition> unwrappedProperties = description.findProperties().stream()
        .filter(prop -> Arrays.asList(prop.getConstructorParameter(), prop.getMutator(), prop.getField()).stream()
            .filter(Objects::nonNull)
            .anyMatch(member -> {
              JsonUnwrapped unwrappedAnnotation = member.getAnnotation(JsonUnwrapped.class);
              if (unwrappedAnnotation != null) {
                tempUnwrappedAnnotation[0] = unwrappedAnnotation;
                member.getAllAnnotations().add(cancelUnwrappedAnnotation);
              }
              return unwrappedAnnotation != null;
            }))
        .collect(Collectors.toList());

    if (unwrappedProperties.isEmpty()) {
      throw new UnsupportedOperationException("@JsonUnwrapped properties not found in " + type.getTypeName());
    } else if (unwrappedProperties.size() > 1) {
      throw new UnsupportedOperationException("Multiple @JsonUnwrapped properties found in " + type.getTypeName());
    }

    BeanPropertyDefinition unwrappedProperty = unwrappedProperties.get(0);

    nameTransformer = NameTransformer.simpleTransformer(tempUnwrappedAnnotation[0].prefix(),
        tempUnwrappedAnnotation[0].suffix());

    unwrappedPropertyName = unwrappedProperty.getName();

    ownPropertyNames = description.findProperties().stream().map(BeanPropertyDefinition::getName).collect(Collectors.toSet());
    ownPropertyNames.remove(unwrappedPropertyName);
    ownPropertyNames.removeAll(description.getIgnoredPropertyNames());

    JsonDeserializer<Object> rawBeanDeserializer = deserializationContext.getFactory()
        .createBeanDeserializer(deserializationContext, type, description);
    ((ResolvableDeserializer) rawBeanDeserializer).resolve(deserializationContext);
    beanDeserializer = (JsonDeserializer<T>) rawBeanDeserializer;
  }

  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty)
      throws JsonMappingException {
    return new JsonUnwrappedDeserializer<>(deserializationContext);
  }

  @Override
  public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectNode node = jsonParser.readValueAsTree();

    ObjectNode ownNode = deserializationContext.getNodeFactory().objectNode();
    ObjectNode unwrappedNode = deserializationContext.getNodeFactory().objectNode();

    node.fields().forEachRemaining(entry -> {
      String key = entry.getKey();
      JsonNode value = entry.getValue();

      String transformed = nameTransformer.reverse(key);

      if (transformed != null && !ownPropertyNames.contains(key)) {
        unwrappedNode.replace(transformed, value);
      } else {
        ownNode.replace(key, value);
      }
    });

    ownNode.replace(unwrappedPropertyName, unwrappedNode);

    try (TreeTraversingParser syntheticParser = new TreeTraversingParser(ownNode, jsonParser.getCodec())) {
      syntheticParser.nextToken();
      return beanDeserializer.deserialize(syntheticParser, deserializationContext);
    }
  }

  private static class CancelUnwrapped {
    @JsonUnwrapped(enabled = false)
    public Object dummy;
  }
}
