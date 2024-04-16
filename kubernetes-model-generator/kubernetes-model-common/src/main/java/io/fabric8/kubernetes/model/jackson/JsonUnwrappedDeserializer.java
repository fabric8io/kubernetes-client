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
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Desc: this is a workaround on the problem that Jackson's @JsonUnwrapped doesn't work with
 * polymorphism (@JsonTypeInfo)
 * Adapted from https://stackoverflow.com/questions/37423848/deserializing-polymorphic-types-with-jsonunwrapped-using-jackson
 */
public class JsonUnwrappedDeserializer<T> extends JsonDeserializer<T> implements ContextualDeserializer {

  private static final JsonUnwrapped cancelUnwrappedAnnotation;

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
  private List<UnwrappedInfo> unwrappedInfos;

  /*
   * Needed by Jackson
   */
  public JsonUnwrappedDeserializer() {
  }

  public JsonUnwrappedDeserializer(DeserializationContext deserializationContext) throws JsonMappingException {
    JavaType type = deserializationContext.getContextualType();

    BeanDescription description = deserializationContext.getConfig().introspect(type);

    List<BeanPropertyDefinition> unwrappedProperties = description.findProperties().stream()
        .filter(prop -> Stream.of(prop.getConstructorParameter(), prop.getMutator(), prop.getField())
            .filter(Objects::nonNull)
            .anyMatch(member -> {
              JsonUnwrapped unwrappedAnnotation = member.getAnnotation(JsonUnwrapped.class);
              if (unwrappedAnnotation != null) {
                member.getAllAnnotations().add(cancelUnwrappedAnnotation);
              }
              return unwrappedAnnotation != null;
            }))
        .collect(Collectors.toList());

    if (unwrappedProperties.isEmpty()) {
      throw new UnsupportedOperationException("@JsonUnwrapped properties not found in " + type.getTypeName());
    }

    ownPropertyNames = description.findProperties().stream()
        .map(BeanPropertyDefinition::getName)
        .collect(Collectors.toSet());
    ownPropertyNames.removeAll(description.getIgnoredPropertyNames());

    JsonDeserializer<Object> rawBeanDeserializer = deserializationContext.getFactory()
        .createBeanDeserializer(deserializationContext, type, description);
    ((ResolvableDeserializer) rawBeanDeserializer).resolve(deserializationContext);
    beanDeserializer = (JsonDeserializer<T>) rawBeanDeserializer;

    unwrappedInfos = new ArrayList<>();
    for (BeanPropertyDefinition unwrappedProperty : unwrappedProperties) {
      unwrappedInfos.add(new UnwrappedInfo(deserializationContext, unwrappedProperty));
      ownPropertyNames.remove(unwrappedProperty.getName());
    }
  }

  private static final class UnwrappedInfo {
    final String propertyName;
    final NameTransformer nameTransformer;
    final Set<String> beanPropertyNames;

    public UnwrappedInfo(DeserializationContext context, BeanPropertyDefinition unwrappedProperty) {
      propertyName = unwrappedProperty.getName();
      final JsonUnwrapped annotation = unwrappedProperty.getField().getAnnotation(JsonUnwrapped.class);
      nameTransformer = NameTransformer.simpleTransformer(annotation.prefix(), annotation.suffix());
      beanPropertyNames = new HashSet<>();
      // Extract viable property names for deserialization and nested deserialization
      final Set<Class<?>> processedTypes = new HashSet<>();
      extractPropertiesDeep(context, processedTypes, beanPropertyNames, unwrappedProperty);
    }

    private static void extractPropertiesDeep(DeserializationContext context, Set<Class<?>> processedTypes,
        Set<String> properties, BeanPropertyDefinition bean) {
      final Collection<NamedType> types = context.getConfig().getSubtypeResolver()
          .collectAndResolveSubtypesByClass(context.getConfig(),
              context.getConfig().introspect(bean.getPrimaryType()).getClassInfo());
      for (NamedType type : types) {
        if (!processedTypes.add(type.getType())) {
          continue;
        }
        for (BeanPropertyDefinition property : context.getConfig().introspect(context.constructType(type.getType()))
            .findProperties()) {
          properties.add(property.getName());
          extractPropertiesDeep(context, processedTypes, properties, property);
        }
      }
    }

  }

  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty)
      throws JsonMappingException {
    return new JsonUnwrappedDeserializer<>(deserializationContext);
  }

  @Override
  public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    final ObjectNode node = jsonParser.readValueAsTree();
    final ObjectNode ownNode = deserializationContext.getNodeFactory().objectNode();
    final Map<UnwrappedInfo, ObjectNode> unwrappedNodes = new HashMap<>();

    node.fields().forEachRemaining(entry -> {
      final String key = entry.getKey();
      final JsonNode value = entry.getValue();

      boolean replaced = false;
      for (UnwrappedInfo unwrapped : unwrappedInfos) {
        final String transformed = unwrapped.nameTransformer.reverse(key);
        final ObjectNode unwrappedNode = unwrappedNodes.getOrDefault(unwrapped,
            deserializationContext.getNodeFactory().objectNode());
        if (transformed != null && !ownPropertyNames.contains(key) && unwrapped.beanPropertyNames.contains(transformed)) {
          unwrappedNodes.putIfAbsent(unwrapped, unwrappedNode);
          unwrappedNode.replace(transformed, value);
          replaced = true;
        }
      }
      if (!replaced && ownPropertyNames.contains(key)) {
        ownNode.replace(key, value);
      }
    });

    for (Map.Entry<UnwrappedInfo, ObjectNode> entry : unwrappedNodes.entrySet()) {
      ownNode.replace(entry.getKey().propertyName, entry.getValue());
    }

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
