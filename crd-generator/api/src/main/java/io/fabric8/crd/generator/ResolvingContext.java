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

package io.fabric8.crd.generator;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
      ((GeneratorObjectSchema)schema).javaType = convertedType;
      seen.putIfAbsent(this.visitorContext.getSeenSchemaUri(convertedType), (GeneratorObjectSchema)schema);
      return result;
    }
  }

  final JsonSchemaGenerator generator;
  final SerializationConfig serializationConfig;
  final KubernetesSerialization kubernetesSerialization;
  final Map<String, GeneratorObjectSchema> seen = new HashMap<>();

  private static class AccessibleKubernetesSerialization extends KubernetesSerialization {

    @Override
    public ObjectMapper getMapper() {
      return super.getMapper();
    };

  }

  private static AccessibleKubernetesSerialization DEFAULT_KUBERNETES_SERIALIZATION;

  public static ResolvingContext defaultResolvingContext() {
    if (DEFAULT_KUBERNETES_SERIALIZATION == null) {
      DEFAULT_KUBERNETES_SERIALIZATION = new AccessibleKubernetesSerialization();
    }
    return new ResolvingContext(DEFAULT_KUBERNETES_SERIALIZATION.getMapper(), DEFAULT_KUBERNETES_SERIALIZATION);
  }

  public ResolvingContext(ObjectMapper mapper, KubernetesSerialization kubernetesSerialization) {
    serializationConfig = mapper.getSerializationConfig();
    this.kubernetesSerialization = kubernetesSerialization;
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

}
