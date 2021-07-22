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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.codemodel.*;
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

public class KubernetesTypeAnnotator extends Jackson2Annotator {

    // see: https://github.com/kubernetes/kubernetes/blob/6902f3112d98eb6bd0894886ff9cd3fbd03a7f79/staging/src/k8s.io/apimachinery/pkg/util/validation/validation.go#L315
    private final String envNamePattern = "[-._a-zA-Z][-._a-zA-Z0-9]*";

    private final String nameIsDNS952LabelPattern = "[a-z]([-a-z0-9]*[a-z0-9])?";

    private final String nameIsDNS1123LabelPattern = "[a-z0-9]([-a-z0-9]*[a-z0-9])?";
    private final int nameIsDNS1123LabelLength = 63;

    private final String nameIsDNS1123SubdomainPattern = nameIsDNS1123LabelPattern + "(\\." + nameIsDNS1123LabelPattern + ")*";
    private final int nameIsDNS1123SubdomainLength = 253;

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

          if (resourceClass.getPackage().name().startsWith("io.fabric8.kubernetes")) {
            JAnnotationArrayMember arrayMember = resourceClass.annotate(VelocityTransformations.class)
              .paramArray("value");
            arrayMember.annotate(VelocityTransformation.class).param("value", "/manifest.vm")
              .param("outputPath", "kubernetes.properties").param("gather", true);
          } else if (resourceClass.getPackage().name().startsWith("io.fabric8.openshift")) {
            JAnnotationArrayMember arrayMember = resourceClass.annotate(VelocityTransformations.class)
              .paramArray("value");
            arrayMember.annotate(VelocityTransformation.class).param("value", "/manifest.vm")
              .param("outputPath", "openshift.properties").param("gather", true);
          }
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

    private int getObjectNameMaxLength(JDefinedClass clazz) {
        String kind = clazz.name();
        if (kind.equals("Namespace") || kind.equals("Project") || kind.equals("Service")) {
            return nameIsDNS1123LabelLength;
        }
        return nameIsDNS1123SubdomainLength;
    }

    private String getObjectNamePattern(JDefinedClass clazz) {
        String kind = clazz.name();
        if (kind.equals("Service")) {
            return nameIsDNS952LabelPattern;
        }
        if (kind.equals("Namespace") || kind.equals("Project")) {
            return nameIsDNS1123LabelPattern;
        }
        return nameIsDNS1123SubdomainPattern;
    }

    private boolean isMinimal(JDefinedClass clazz) {
        String kind = clazz.name();
        return kind.equals("Group") || kind.equals("User") || kind.equals("Identity") || kind.equals("UserIdentityMapping")
            || kind.equals("ClusterNetwork") || kind.equals("HostSubnet") || kind.equals("NetNamespace")
            || kind.equals("Image") || kind.equals("ImageStream") || kind.equals("ImageStreamMapping") || kind.equals("ImageStreamTag") || kind.equals("ImageStreamImport")
            || kind.equals("Policy") || kind.equals("PolicyBinding") || kind.equals("Role") || kind.equals("RoleBinding")
            || kind.equals("OAuthAccessToken") || kind.equals("OAuthAuthorizeToken") || kind.equals("OAuthClientAuthorization");
    }

}
