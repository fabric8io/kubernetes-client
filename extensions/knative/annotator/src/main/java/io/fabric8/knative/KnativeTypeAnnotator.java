/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.knative;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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
import io.fabric8.kubernetes.model.annotation.ApiGroup;
import io.fabric8.kubernetes.model.annotation.ApiVersion;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.Inline;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jsonschema2pojo.Jackson2Annotator;

public class KnativeTypeAnnotator extends Jackson2Annotator {

    private final Map<String, JDefinedClass> pendingResources = new HashMap<>();
    private final Map<String, JDefinedClass> pendingLists = new HashMap<>();

    @Override
    public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
        //We just want to make sure we avoid infinite loops
        clazz.annotate(JsonDeserialize.class)
                .param("using", JsonDeserializer.None.class);
        clazz.annotate(ToString.class);
        clazz.annotate(EqualsAndHashCode.class);
        try {
            JAnnotationUse buildable = clazz.annotate(Buildable.class)
                    .param("editableEnabled", false)
                    .param("validationEnabled", false)
                    .param("generateBuilderPackage", false)
                    .param("builderPackage", "io.fabric8.kubernetes.api.builder");

            buildable.paramArray("inline").annotate(Inline.class)
                    .param("type", new JCodeModel()._class("io.fabric8.kubernetes.api.model.Doneable"))
                    .param("prefix", "Doneable")
                    .param("value", "done");

            JAnnotationArrayMember arrayMember = buildable.paramArray("refs");
            arrayMember.annotate(BuildableReference.class).param("value", new JCodeModel()._class("io.fabric8.kubernetes.api.model.ObjectMeta"));
            arrayMember.annotate(BuildableReference.class).param("value", new JCodeModel()._class("io.fabric8.kubernetes.api.model.Volume"));
            arrayMember.annotate(BuildableReference.class).param("value", new JCodeModel()._class("io.fabric8.kubernetes.api.model.Container"));

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
              .param("outputPath", "knative.properties").param("gather", true);

          pendingLists.remove(resourceName);
          pendingResources.remove(resourceName);
        }
      }
    }

    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {

    }

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {

    }

    @Override
    public void propertyGetter(JMethod getter, String propertyName) {

    }

    @Override
    public void propertySetter(JMethod setter, String propertyName) {

    }

    @Override
    public void anyGetter(JMethod getter) {

    }

    @Override
    public void anySetter(JMethod setter) {

    }

    @Override
    public void enumCreatorMethod(JMethod creatorMethod) {

    }

    @Override
    public void enumValueMethod(JMethod valueMethod) {

    }

    @Override
    public void enumConstant(JEnumConstant constant, String value) {

    }

    @Override
    public boolean isAdditionalPropertiesSupported() {
        return true;
    }

    @Override
    public void additionalPropertiesField(JFieldVar field, JDefinedClass clazz, String propertyName) {

    }
}
