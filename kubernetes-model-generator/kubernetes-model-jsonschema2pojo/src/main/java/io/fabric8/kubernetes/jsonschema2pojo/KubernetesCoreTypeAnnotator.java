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
import io.fabric8.kubernetes.model.annotation.PackageSuffix;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KubernetesCoreTypeAnnotator extends Jackson2Annotator {
  protected static final String ANNOTATION_VALUE = "value";
  protected static final String API_VERSION = "apiVersion";
  protected static final String METADATA = "metadata";
  protected static final String KIND = "kind";
  public static final String CORE_PACKAGE = "core";
  public static final String OPENSHIFT_PACKAGE = "openshift";
  protected final Map<String, JDefinedClass> pendingResources = new HashMap<>();
  protected final Map<String, JDefinedClass> pendingLists = new HashMap<>();
  protected String moduleName = null;

  public KubernetesCoreTypeAnnotator(GenerationConfig generationConfig) {
    super(generationConfig);
  }

  @Override
  public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
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
    processBuildable(clazz);
  
    final Map<String, JFieldVar> fields = clazz.fields();
    if (fields.containsKey(KIND) && fields.containsKey(METADATA)) {
      String resourceName = clazz.name();
      final int listIndex = resourceName.lastIndexOf("List");
      if (listIndex > 0 ) {
        resourceName = resourceName.substring(0, listIndex);
        pendingLists.put(resourceName, clazz);
      } else {
        pendingResources.put(resourceName, clazz);
      }
      
      final JDefinedClass resourceClass = pendingResources.get(resourceName);
      final JDefinedClass resourceListClass = pendingLists.get(resourceName);
      if (resourceClass != null && resourceListClass != null) {
        String apiVersion = propertiesNode.get(API_VERSION).get("default").toString().replace('"', ' ').trim();
        String apiGroup = "";
        final int lastSlash = apiVersion.lastIndexOf('/');
        if (lastSlash > 0) {
          apiGroup = apiVersion.substring(0, lastSlash);
          apiVersion = apiVersion.substring(apiGroup.length() + 1);
        }
        String packageSuffix = getPackageSuffix(apiVersion);

        resourceClass.annotate(Version.class).param(ANNOTATION_VALUE, apiVersion);
        resourceClass.annotate(Group.class).param(ANNOTATION_VALUE, apiGroup);
        resourceClass.annotate(PackageSuffix.class).param(ANNOTATION_VALUE, packageSuffix);
        resourceListClass.annotate(Version.class).param(ANNOTATION_VALUE, apiVersion);
        resourceListClass.annotate(Group.class).param(ANNOTATION_VALUE, apiGroup);
        resourceListClass.annotate(PackageSuffix.class).param(ANNOTATION_VALUE, packageSuffix);
        pendingLists.remove(resourceName);
        pendingResources.remove(resourceName);
        addClassesToPropertyFiles(resourceClass);
      }
    }
  }
  
  @Override
  public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
    if (moduleName == null) {
      moduleName = schema.get("$module").textValue();
    }

    if (schema.has("serializer")) {
      annotateSerde(clazz, JsonSerialize.class, schema.get("serializer").asText());
    }

    if (schema.has("deserializer")) {
      annotateSerde(clazz, JsonDeserialize.class, schema.get("deserializer").asText());
    } else {
      clazz.annotate(JsonDeserialize.class).param("using", JsonDeserializer.None.class);
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
    String packageCategory = getPackageCategory(clazz.getPackage().name());
    if (moduleName.equals(packageCategory) /*&& shouldIncludeClass(clazz.name())*/) {
      JAnnotationArrayMember arrayMember = clazz.annotate(VelocityTransformations.class)
        .paramArray(ANNOTATION_VALUE);
      arrayMember.annotate(VelocityTransformation.class).param(ANNOTATION_VALUE, "/manifest.vm")
        .param("outputPath", moduleName + ".properties").param("gather", true);
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

  private String getPackageSuffix(String apiVersion) {
    return "." +
      moduleName +
      "." +
      apiVersion;
  }
}
