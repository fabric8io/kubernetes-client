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
package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.model.jackson.UnmatchedFieldTypeModule;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.deser.BeanDeserializerFactory;

/**
 * Essentially wraps a bean deserializer to allow for unmatched fields
 */
public class TemplateDeserializer extends ValueDeserializer<Template> {

  @Override
  public Template deserialize(JsonParser jsonParser, DeserializationContext ctxt) {
    JavaType type = ctxt.getTypeFactory().constructType(Template.class);
    BeanDescription description = ctxt.introspectBeanDescriptionForCreation(type);

    ValueDeserializer<Object> rawDeserializer = BeanDeserializerFactory.instance
        .createBeanDeserializer(ctxt, type, description.supplier());
    rawDeserializer.resolve(ctxt);
    @SuppressWarnings("unchecked")
    ValueDeserializer<Object> beanDeserializer = (ValueDeserializer<Object>) rawDeserializer
        .createContextual(ctxt, null);

    boolean inTemplate = false;
    if (!UnmatchedFieldTypeModule.isInTemplate()) {
      UnmatchedFieldTypeModule.setInTemplate();
      inTemplate = true;
    }
    try {
      return (Template) beanDeserializer.deserialize(jsonParser, ctxt);
    } finally {
      if (inTemplate) {
        UnmatchedFieldTypeModule.removeInTemplate();
      }
    }
  }
}