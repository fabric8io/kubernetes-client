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
package io.fabric8.kubernetes.annotator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import io.fabric8.kubernetes.model.annotation.ApiGroup;
import io.fabric8.kubernetes.model.annotation.ApiVersion;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.Inline;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jsonschema2pojo.Jackson2Annotator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class KubernetesCoreTypeAnnotator extends Jackson2Annotator {
  protected final Map<String, JDefinedClass> pendingResources = new HashMap<>();
  protected final Map<String, JDefinedClass> pendingLists = new HashMap<>();
  protected String moduleName = null;

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
    processBuildable(clazz);

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

        String apiVersion = propertiesNode.get("apiVersion").get("default").toString().replaceAll(Pattern.quote("\""), "");
        String apiGroup = "";
        if (apiVersion.contains("/")) {
          apiGroup = apiVersion.substring(0, apiVersion.lastIndexOf("/"));
          apiVersion = apiVersion.substring(apiGroup.length() + 1);
        }
        resourceClass.annotate(ApiVersion.class).param("value", apiVersion);
        resourceClass.annotate(ApiGroup.class).param("value", apiGroup);
        resourceListClass.annotate(ApiVersion.class).param("value", apiVersion);
        resourceListClass.annotate(ApiGroup.class).param("value", apiGroup);
        pendingLists.remove(resourceName);
        pendingResources.remove(resourceName);
      }
      addClassesToPropertyFiles(clazz);
    }
  }

  @Override
  public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
    if (moduleName == null) {
      moduleName = schema.get("$module").textValue();
    }
    super.propertyInclusion(clazz, schema);
  }

  @Override
  public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
    super.propertyField(field, clazz, propertyName, propertyNode);

    if (propertyNode.has("javaOmitEmpty") && propertyNode.get("javaOmitEmpty").asBoolean(false)) {
      field.annotate(JsonInclude.class).param("value", JsonInclude.Include.NON_EMPTY);
    }
  }

  protected void processBuildable(JDefinedClass clazz) {
    try {
      clazz.annotate(Buildable.class)
        .param("editableEnabled", false)
        .param("validationEnabled", false)
        .param("generateBuilderPackage", true)
        .param("lazyCollectionInitEnabled", false)
        .param("builderPackage", "io.fabric8.kubernetes.api.builder")
        .annotationParam("inline", Inline.class)
        .param("type", new JCodeModel()._class("io.fabric8.kubernetes.api.model.Doneable"))
        .param("prefix", "Doneable")
        .param("value", "done");

    } catch (JClassAlreadyExistsException e) {
      e.printStackTrace();
    }
  }

  protected void addClassesToPropertyFiles(JDefinedClass clazz) {
    String packageCategory = getPackageCategory(clazz.getPackage().name());
    if (moduleName.equals(packageCategory) && shouldIncludeClass(clazz.name())) {
      JAnnotationArrayMember arrayMember = clazz.annotate(VelocityTransformations.class)
        .paramArray("value");
      arrayMember.annotate(VelocityTransformation.class).param("value", "/manifest.vm")
        .param("outputPath", moduleName + ".properties").param("gather", true);
    }
  }

  private String getPackageCategory(String packageName) {
    if (packageName.isEmpty()) {
      return null;
    }
    if (packageName.equals("io.fabric8.kubernetes.api.model")) {
      return "kubernetes";
    } else if (packageName.equals("io.fabric8.openshift.api.model")) {
      return "openshift";
    }
    // append whatever is after io.fabric8.kubernetes.api.model whether it's
    // io.fabric8.kubernetes.api.model.apps or
    // io.fabric8.kubernetes.api.model.batch.v1
    String[] parts = packageName.split("\\.");
    if (parts.length < 6) {
      throw new IllegalArgumentException("Invalid package name encountered: " + packageName);
    }
    return parts[5];
  }

  public boolean shouldIncludeClass(String className) {
    return !(className.contains("ServiceReference") ||
      className.equals("AllowedFlexVolume") ||
      className.equals("DeploymentCondition") ||
      className.equals("FSGroupStrategyOptions") ||
      className.equals("PolicyRule") ||
      className.equals("IDRange") ||
      className.equals("SupplementalGroupsStrategyOptions") ||
      className.equals("PodIP") ||
      className.equals("VolumeAttachmentSource") ||
      className.equals("DeploymentStrategy") ||
      className.contains("List") ||
      className.equals("BuildRequest") ||
      className.equals("ImageSignature") ||
      className.equals("ImageStreamImport") ||
      className.equals("OpenshiftRoleBindingRestriction") ||
      className.equals("Scale") ||
      className.equals("Status") ||
      className.equals("TokenReview") ||
      className.equals("RouteIngress") ||
      className.equals("ProjectRequest") ||
      className.equals("WebhookClientConfig"));
  }
}
