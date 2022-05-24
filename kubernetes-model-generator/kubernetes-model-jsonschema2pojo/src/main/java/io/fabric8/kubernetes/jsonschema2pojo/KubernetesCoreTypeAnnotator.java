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
package io.fabric8.kubernetes.jsonschema2pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpressionImpl;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JFormatter;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KubernetesCoreTypeAnnotator extends Jackson2Annotator {
  protected static final String ANNOTATION_VALUE = "value";
  protected static final String API_VERSION = "apiVersion";
  protected static final String METADATA = "metadata";
  protected static final String KIND = "kind";
  protected static final String DEFAULT = "default";
  protected static final String INTERFACE_TYPE_PROPERTY = "interfaceType";
  public static final String CORE_PACKAGE = "core";
  public static final String OPENSHIFT_PACKAGE = "openshift";
  protected final Map<String, JDefinedClass> pendingResources = new HashMap<>();
  protected final Map<String, JDefinedClass> pendingLists = new HashMap<>();
  protected String moduleName = null;

  private final Set<String> handledClasses = new HashSet<>();

  public KubernetesCoreTypeAnnotator(GenerationConfig generationConfig) {
    super(generationConfig);
  }

  @Override
  public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
    // ensure every class is only processed once
    if (handledClasses.contains(clazz.fullName())) {
      return;
    }

    JAnnotationArrayMember annotationValue = clazz.annotate(JsonPropertyOrder.class).paramArray(ANNOTATION_VALUE);

    annotationValue.param(API_VERSION);
    annotationValue.param(KIND);
    annotationValue.param(METADATA);
    for (Iterator<String> properties = propertiesNode.fieldNames(); properties.hasNext();) {
      String next = properties.next();
      if (!next.equals(API_VERSION) && !next.equals(KIND) && !next.equals(METADATA)) {
        annotationValue.param(next);
      }
    }

    clazz.annotate(ToString.class);
    clazz.annotate(EqualsAndHashCode.class);
    clazz.annotate(Setter.class);
    clazz.annotate(Accessors.class).paramArray("prefix").param("_").param("");
    processBuildable(clazz);

    final Map<String, JFieldVar> fields = clazz.fields();
    if (fields.containsKey(KIND) && propertiesNode.has(API_VERSION) && propertiesNode.get(API_VERSION).has(DEFAULT)) {
      String apiVersion = propertiesNode.get(API_VERSION).get(DEFAULT).toString().replace('"', ' ').trim();
      String apiGroup = "";
      final int lastSlash = apiVersion.lastIndexOf('/');
      if (lastSlash > 0) {
        apiGroup = apiVersion.substring(0, lastSlash);
        apiVersion = apiVersion.substring(apiGroup.length() + 1);
      }

      String resourceName = clazz.fullName();
      if (resourceName.endsWith("List")) {
        resourceName = resourceName.substring(0, resourceName.length() - 4);
        final JDefinedClass resourceClass = pendingResources.remove(resourceName);
        if (resourceClass != null) {
          annotate(clazz, apiVersion, apiGroup);
          addClassesToPropertyFiles(resourceClass);
        } else {
          pendingLists.put(resourceName, clazz);
        }
      } else {
        final JDefinedClass resourceListClass = pendingLists.remove(resourceName);
        if (resourceListClass != null) {
          annotate(resourceListClass, apiVersion, apiGroup);
          addClassesToPropertyFiles(clazz);
        } else {
          annotate(clazz, apiVersion, apiGroup);
          pendingResources.put(resourceName, clazz);
        }
      }
    }
  }

  private void annotate(JDefinedClass clazz, String apiVersion, String apiGroup) {
    clazz.annotate(Version.class).param(ANNOTATION_VALUE, apiVersion);
    clazz.annotate(Group.class).param(ANNOTATION_VALUE, apiGroup);
  }

  @Override
  public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
    if (moduleName == null && schema.has("$module")) {
      moduleName = schema.get("$module").textValue();
    }

    if (schema.has("serializer")) {
      annotateSerde(clazz, JsonSerialize.class, schema.get("serializer").asText());
    }

    String deserializer = null;
    if (schema.has("deserializer")) {
      deserializer = schema.get("deserializer").asText();
    }

    if (schema.has("properties") && hasInterfaceFields(schema.get("properties"))) {
      clazz.annotate(JsonDeserialize.class)
          .param("using", JsonUnwrappedDeserializer.class);
    } else {
      annotateSerde(clazz, JsonDeserialize.class,
          deserializer == null ? JsonDeserializer.None.class.getCanonicalName() : deserializer);
    }

    super.propertyInclusion(clazz, schema);
  }

  private void annotateSerde(JDefinedClass clazz, Class<? extends Annotation> annotation, String usingClassName) {
    if (!usingClassName.endsWith(".class")) {
      usingClassName = usingClassName + ".class";
    }

    clazz.annotate(annotation).param("using", literalExpression(usingClassName));
  }

  private JExpressionImpl literalExpression(String literal) {
    return new JExpressionImpl() {
      @Override
      public void generate(JFormatter f) {
        f.p(literal);
      }
    };
  }

  @Override
  public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
    super.propertyField(field, clazz, propertyName, propertyNode);

    if (propertyNode.has("javaOmitEmpty") && propertyNode.get("javaOmitEmpty").asBoolean(false)) {
      field.annotate(JsonInclude.class).param(ANNOTATION_VALUE, JsonInclude.Include.NON_EMPTY);
    }

    // Annotate JsonUnwrapped for interfaces as they cannot be created when no implementations
    if (propertyNode.hasNonNull(INTERFACE_TYPE_PROPERTY)) {
      field.annotate(JsonUnwrapped.class);
    }
  }

  protected void processBuildable(JDefinedClass clazz) {
    clazz.annotate(Buildable.class)
        .param("editableEnabled", false)
        .param("validationEnabled", false)
        .param("generateBuilderPackage", true)
        .param("lazyCollectionInitEnabled", false)
        .param("builderPackage", "io.fabric8.kubernetes.api.builder");
  }

  protected void addClassesToPropertyFiles(JDefinedClass clazz) {
    if (moduleName == null || moduleName.equals(getPackageCategory(clazz.getPackage().name())) /*
                                                                                                * &&
                                                                                                * shouldIncludeClass(clazz.name(
                                                                                                * ))
                                                                                                */) {
      JAnnotationArrayMember arrayMember = clazz.annotate(TemplateTransformations.class)
          .paramArray(ANNOTATION_VALUE);
      arrayMember.annotate(TemplateTransformation.class).param(ANNOTATION_VALUE, "/manifest.vm")
          .param("outputPath", (moduleName == null ? "model" : moduleName) + ".properties").param("gather", true);
    }
  }

  private String getPackageCategory(String packageName) {
    if (packageName.isEmpty()) {
      return null;
    }
    if (packageName.equals("io.fabric8.kubernetes.api.model")) {
      return CORE_PACKAGE;
    } else if (packageName.equals("io.fabric8.openshift.api.model")) {
      return OPENSHIFT_PACKAGE;
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

  private boolean hasInterfaceFields(JsonNode propertiesNode) {
    for (Iterator<JsonNode> field = propertiesNode.elements(); field.hasNext();) {
      JsonNode propertyNode = field.next();
      if (propertyNode.hasNonNull(INTERFACE_TYPE_PROPERTY)) {
        return true;
      }
    }

    return false;
  }

}
