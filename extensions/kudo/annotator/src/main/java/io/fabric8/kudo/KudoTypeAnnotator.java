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
package io.fabric8.kudo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JEnumConstant;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import io.fabric8.kubernetes.ModelAnnotator;
import io.fabric8.kubernetes.model.annotation.ApiGroup;
import io.fabric8.kubernetes.model.annotation.ApiVersion;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.Inline;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class KudoTypeAnnotator extends ModelAnnotator {
  private final Map<String, JDefinedClass> pendingResources = new HashMap<>();
  private final Map<String, JDefinedClass> pendingLists = new HashMap<>();

  @Override
  public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
    JAnnotationArrayMember annotationValue = clazz.annotate(JsonPropertyOrder.class).paramArray("value");

    annotationValue.param("apiVersion");
    annotationValue.param("kind");
    annotationValue.param("metadata");
    for (Iterator<String> properties = propertiesNode.fieldNames(); properties.hasNext();) {
      String next = properties.next();
      if (!next.equals("apiVersion") && !next.equals("kind") && !next.equals("metadata")) {
        annotationValue.param(next);
      }
    }

    //We just want to make sure we avoid infinite loops
    clazz.annotate(JsonDeserialize.class)
      .param("using", JsonDeserializer.None.class);
    clazz.annotate(ToString.class);
    clazz.annotate(EqualsAndHashCode.class);
    try {
      JAnnotationUse buildable = clazz.annotate(Buildable.class)
        .param("editableEnabled", false)
        .param("validationEnabled", false)
        .param("generateBuilderPackage", true)
        .param("builderPackage", "io.fabric8.kubernetes.api.builder")
        .annotationParam("inline", Inline.class)
        .param("type", new JCodeModel()._class("io.fabric8.kubernetes.api.model.Doneable"))
        .param("prefix", "Doneable")
        .param("value", "done");
    } catch (JClassAlreadyExistsException e) {
      e.printStackTrace();
    }

    if (clazz.fields().containsKey("kind") && clazz.fields().containsKey("metadata")) {
      String resourceName;

      if (clazz.name().endsWith("List")) {
        resourceName = clazz.name().substring(0, clazz.name().length() - 4);
        pendingLists.put(resourceName, clazz);
      } else {
        resourceName = clazz.name();
        pendingResources.put(clazz.name(), clazz);
      }

      if (pendingResources.containsKey(resourceName) && pendingLists.containsKey(resourceName)) {
        JDefinedClass resourceClass = pendingResources.get(resourceName);
        JDefinedClass resourceListClass = pendingLists.get(resourceName);

        String apiVersion =  propertiesNode.get("apiVersion").get("default").toString().replaceAll(Pattern.quote("\""), "");
        String apiGroup = "";
        if (apiVersion.contains("/")) {
          apiGroup = apiVersion.substring(0, apiVersion.lastIndexOf("/"));
          apiVersion = apiVersion.substring(apiGroup.length() + 1);
        }
        resourceClass.annotate(ApiVersion.class).param("value", apiVersion);
        resourceClass.annotate(ApiGroup.class).param("value", apiGroup);
        resourceListClass.annotate(ApiVersion.class).param("value", apiVersion);
        resourceListClass.annotate(ApiGroup.class).param("value", apiGroup);

        JAnnotationArrayMember arrayMember = resourceClass.annotate(VelocityTransformations.class)
          .paramArray("value");
        arrayMember.annotate(VelocityTransformation.class).param("value", "/manifest.vm")
          .param("outputPath", "kudo.properties").param("gather", true);

        pendingLists.remove(resourceName);
        pendingResources.remove(resourceName);
      }
    }
  }

  @Override
  public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
    super.propertyField(field, clazz, propertyName, propertyNode);

    if (propertyNode.has("javaOmitEmpty") && propertyNode.get("javaOmitEmpty").asBoolean(false)) {
      field.annotate(JsonInclude.class).param("value", JsonInclude.Include.NON_EMPTY);
    }
  }
}
