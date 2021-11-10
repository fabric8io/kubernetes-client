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
package io.fabric8.kubernetes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jsonschema2pojo.AbstractAnnotator;

import java.util.HashSet;
import java.util.Set;

public class ModelAnnotator extends AbstractAnnotator {

  private static final String BUILDABLE_REFERENCE_VALUE = "value";

  private final Set<String> handledClasses = new HashSet<>();

  @Override
  public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
    try {

      // ensure every class is only processed once
      if (handledClasses.contains(clazz.fullName()))
        return;

      // add common annotations
      clazz.annotate(JsonDeserialize.class)
        .param("using", JsonDeserializer.None.class);
      clazz.annotate(ToString.class);
      clazz.annotate(EqualsAndHashCode.class);
      clazz.annotate(Setter.class);
      clazz.annotate(Accessors.class).paramArray("prefix").param("_").param("");

      JAnnotationUse buildable = clazz.annotate(Buildable.class)
        .param("editableEnabled", false)
        .param("validationEnabled", false)
        .param("generateBuilderPackage", false)
        .param("builderPackage", "io.fabric8.kubernetes.api.builder");

        JAnnotationArrayMember refs = buildable.paramArray("refs");
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.ObjectMeta"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.ObjectReference"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.LabelSelector"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.Container"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.EnvVar"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.ContainerPort"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.Volume"));
        refs.annotate(BuildableReference.class).param(BUILDABLE_REFERENCE_VALUE, new JCodeModel()._class("io.fabric8.kubernetes.api.model.VolumeMount"));

      if (isCRD(clazz, propertiesNode) || isCRDList(clazz, propertiesNode)) { // add CRD-specific annotations
        String apiVersion = getApiVersion(propertiesNode);
        clazz.annotate(Version.class).param("value", extractVersion(apiVersion));
        clazz.annotate(Group.class).param("value", extractGroup(apiVersion));
      }

      if (isCRD(clazz, propertiesNode)) { // include in model.properties (only CRDs not Lists!)
        JAnnotationArrayMember arrayMember = clazz.annotate(TemplateTransformations.class)
          .paramArray("value");
        arrayMember.annotate(TemplateTransformation.class)
          .param("value", "/manifest.vm")
          .param("outputPath", "model.properties")
          .param("gather", true);
      }

      handledClasses.add(clazz.fullName());

    } catch (JClassAlreadyExistsException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
    super.propertyField(field, clazz, propertyName, propertyNode);

    if (propertyNode.has("javaOmitEmpty") && propertyNode.get("javaOmitEmpty").asBoolean(false)) {
      field.annotate(JsonInclude.class).param("value", JsonInclude.Include.NON_EMPTY);
    }
  }

  /**
   * all CRDs have apiVersion initialized with a default value
   */
  private boolean hasApiVersionWithDefault(JsonNode propertiesNode) {
    final JsonNode apiVersion = propertiesNode.get("apiVersion");
    if (apiVersion != null) {
      return apiVersion.get("default") != null;
    }
    return false;
  }

  private boolean isCRD(JDefinedClass clazz, JsonNode propertiesNode) {
    return hasApiVersionWithDefault(propertiesNode) && !clazz.name().endsWith("List");
  }

  private boolean isCRDList(JDefinedClass clazz, JsonNode propertiesNode) {
    return hasApiVersionWithDefault(propertiesNode) && clazz.name().endsWith("List");
  }

  private String extractGroup(String apiVersion) {
    return apiVersion.split("/")[0];
  }

  private String extractVersion(String apiVersion) {
    return apiVersion.split("/")[1];
  }

  private String getApiVersion(JsonNode propertiesNode) {
    return propertiesNode.get("apiVersion").get("default").textValue();
  }

}
