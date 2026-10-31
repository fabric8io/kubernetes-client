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
import tools.jackson.core.JsonParser;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.deser.BeanDeserializerFactory;
import tools.jackson.databind.introspect.BeanPropertyDefinition;
import tools.jackson.databind.jsontype.NamedType;
import tools.jackson.databind.node.ObjectNode;
import tools.jackson.databind.node.TreeTraversingParser;
import tools.jackson.databind.util.NameTransformer;

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
public class JsonUnwrappedDeserializer<T> extends ValueDeserializer<T> {

  private static final JsonUnwrapped cancelUnwrappedAnnotation;

  static {
    try {
      cancelUnwrappedAnnotation = CancelUnwrapped.class.getField("dummy").getAnnotation(JsonUnwrapped.class);
    } catch (NoSuchFieldException ex) {
      // this exception will never happen, though:
      throw new RuntimeException(ex);
    }
  }

  private ValueDeserializer<T> beanDeserializer;
  private Set<String> ownPropertyNames;
  private List<UnwrappedInfo> unwrappedInfos;

  /*
   * Needed by Jackson
   */
  public JsonUnwrappedDeserializer() {
  }

  public JsonUnwrappedDeserializer(DeserializationContext deserializationContext) throws DatabindException {
    JavaType type = deserializationContext.getContextualType();

    BeanDescription description = deserializationContext.introspectBeanDescriptionForCreation(type);

    List<BeanPropertyDefinition> unwrappedProperties = description.findProperties().stream()
        .filter(prop -> Stream.of(prop.getConstructorParameter(), prop.getMutator(), prop.getField())
            .filter(Objects::nonNull)
            .anyMatch(member -> {
              JsonUnwrapped unwrappedAnnotation = member.getAnnotation(JsonUnwrapped.class);
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

    // Build the bean deserializer directly from the factory to avoid infinite recursion.
    // findContextualValueDeserializer would resolve @JsonDeserialize(using=JsonUnwrappedDeserializer.class)
    // and re-enter createContextual, causing StackOverflow.
    @SuppressWarnings("unchecked")
    ValueDeserializer<Object> rawBeanDeserializer = BeanDeserializerFactory.instance
        .createBeanDeserializer(deserializationContext, type, description.supplier());
    rawBeanDeserializer.resolve(deserializationContext);
    @SuppressWarnings("unchecked")
    ValueDeserializer<T> contextual = (ValueDeserializer<T>) rawBeanDeserializer
        .createContextual(deserializationContext, null);
    beanDeserializer = contextual;

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
      BeanDescription beanDesc = context.introspectBeanDescriptionForCreation(bean.getPrimaryType());
      final Collection<NamedType> types = context.getConfig().getSubtypeResolver()
          .collectAndResolveSubtypesByClass(context.getConfig(), beanDesc.getClassInfo());
      for (NamedType type : types) {
        if (!processedTypes.add(type.getType())) {
          continue;
        }
        for (BeanPropertyDefinition property : context.introspectBeanDescriptionForCreation(
            context.constructType(type.getType())).findProperties()) {
          properties.add(property.getName());
          extractPropertiesDeep(context, processedTypes, properties, property);
        }
      }
    }

  }

  @Override
  public ValueDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty)
      throws DatabindException {
    return new JsonUnwrappedDeserializer<>(deserializationContext);
  }

  @Override
  public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
    final ObjectNode node = jsonParser.readValueAsTree();
    final ObjectNode ownNode = deserializationContext.getNodeFactory().objectNode();
    final Map<UnwrappedInfo, ObjectNode> unwrappedNodes = new HashMap<>();

    node.properties().forEach(entry -> {
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

    try (TreeTraversingParser syntheticParser = new TreeTraversingParser(ownNode, jsonParser.objectReadContext())) {
      syntheticParser.nextToken();
      return beanDeserializer.deserialize(syntheticParser, deserializationContext);
    }
  }

  private static class CancelUnwrapped {
    @JsonUnwrapped(enabled = false)
    public Object dummy;
  }
}
