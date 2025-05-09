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

package io.fabric8.crdv2.generator;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.factories.JsonSchemaFactory;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.VisitorContext;
import com.fasterxml.jackson.module.jsonSchema.factories.WrapperFactory;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.kubernetes.client.utils.YamlDumpSettings;
import io.fabric8.kubernetes.client.utils.YamlDumpSettingsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Encapsulates the stateful Jackson details that allow for crd to be fully resolved by our logic
 * - holds an association of uris to already generated jackson schemas
 * - holds a Jackson SchemaGenerator which is not thread-safe
 */
public class ResolvingContext {

  static final class GeneratorObjectSchema extends ObjectSchema {

    JavaType javaType;
    Map<String, BeanProperty> beanProperties = new LinkedHashMap<>();

    @Override
    public void putOptionalProperty(BeanProperty property, JsonSchema jsonSchema) {
      beanProperties.put(property.getName(), property);
      super.putOptionalProperty(property, jsonSchema);
    }

    @Override
    public JsonSchema putProperty(BeanProperty property, JsonSchema value) {
      beanProperties.put(property.getName(), property);
      return super.putProperty(property, value);
    }

  }

  private final class KubernetesSchemaFactoryWrapper extends SchemaFactoryWrapper {

    private KubernetesSchemaFactoryWrapper(SerializerProvider p, WrapperFactory wrapperFactory) {
      super(p, wrapperFactory);
      this.schemaProvider = new JsonSchemaFactory() {

        @Override
        public ObjectSchema objectSchema() {
          return new GeneratorObjectSchema();
        }

      };
    }

    @Override
    public JsonObjectFormatVisitor expectObjectFormat(JavaType convertedType) {
      // TODO: jackson should pass in directly here if there's an anyGetter / setter
      // so that we may directly mark preserve unknown
      JsonObjectFormatVisitor result = super.expectObjectFormat(convertedType);
      ((GeneratorObjectSchema) schema).javaType = convertedType;
      uriToJacksonSchema.putIfAbsent(this.visitorContext.getSeenSchemaUri(convertedType), (GeneratorObjectSchema) schema);
      return result;
    }
  }

  final JsonSchemaGenerator generator;
  final ObjectMapper objectMapper;
  final KubernetesSerialization kubernetesSerialization;
  final Map<String, GeneratorObjectSchema> uriToJacksonSchema;
  final boolean implicitPreserveUnknownFields;
  final boolean ignoreJSONSchemaAnnotation;

  private static ObjectMapper OBJECT_MAPPER;

  public static ResolvingContext defaultResolvingContext(boolean implicitPreserveUnknownFields) {
    return defaultResolvingContext(implicitPreserveUnknownFields, new YamlDumpSettingsBuilder().build());
  }

  public static ResolvingContext defaultResolvingContext(boolean implicitPreserveUnknownFields,
      YamlDumpSettings yamlDumpSettings) {
    if (OBJECT_MAPPER == null) {
      OBJECT_MAPPER = new ObjectMapper();
    }
    return new ResolvingContext(
        OBJECT_MAPPER,
        new KubernetesSerialization(OBJECT_MAPPER, false, yamlDumpSettings),
        implicitPreserveUnknownFields);
  }

  public ResolvingContext forkContext() {
    return new ResolvingContext(objectMapper, kubernetesSerialization, uriToJacksonSchema, implicitPreserveUnknownFields,
        ignoreJSONSchemaAnnotation);
  }

  public ResolvingContext forkContext(boolean ignoreJSONSchemaAnnotation) {
    return new ResolvingContext(objectMapper, kubernetesSerialization, uriToJacksonSchema, implicitPreserveUnknownFields,
        ignoreJSONSchemaAnnotation);
  }

  public ResolvingContext(ObjectMapper mapper, KubernetesSerialization kubernetesSerialization,
      boolean implicitPreserveUnknownFields) {
    this(mapper, kubernetesSerialization, new ConcurrentHashMap<>(), implicitPreserveUnknownFields, false);
  }

  private ResolvingContext(ObjectMapper mapper, KubernetesSerialization kubernetesSerialization,
      Map<String, GeneratorObjectSchema> uriToJacksonSchema,
      boolean implicitPreserveUnknownFields,
      boolean ignoreJSONSchemaAnnotation) {
    this.uriToJacksonSchema = uriToJacksonSchema;
    this.objectMapper = mapper;
    this.kubernetesSerialization = kubernetesSerialization;
    this.implicitPreserveUnknownFields = implicitPreserveUnknownFields;
    this.ignoreJSONSchemaAnnotation = ignoreJSONSchemaAnnotation;
    generator = new JsonSchemaGenerator(mapper, new WrapperFactory() {

      @Override
      public SchemaFactoryWrapper getWrapper(SerializerProvider provider) {
        return new KubernetesSchemaFactoryWrapper(provider, this);
      }

      @Override
      public SchemaFactoryWrapper getWrapper(SerializerProvider provider, VisitorContext rvc) {
        SchemaFactoryWrapper wrapper = getWrapper(provider);
        wrapper.setVisitorContext(rvc);
        return wrapper;
      }

    });
  }

  JsonSchema toJsonSchema(Class<?> clazz) {
    try {
      return generator.generateSchema(clazz);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    }
  }

}
