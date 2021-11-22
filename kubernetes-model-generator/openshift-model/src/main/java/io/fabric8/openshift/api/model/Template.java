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
package io.fabric8.openshift.api.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.HasMetadataComparator;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.model.annotation.Generated;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "apiVersion",
        "kind",
        "metadata",
        "labels",
        "objects",
        "parameters"
})
@JsonDeserialize(using = JsonDeserializer.None.class)
@EqualsAndHashCode
@ToString
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage=false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "openshift.properties", gather = true)
})
public class Template implements HasMetadata, Namespaced {

    /**
     * (Required)
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "template.openshift.io/v1";
    /**
     * (Required)
     */
    @JsonProperty("kind")
    private java.lang.String kind = "Template";
    /**
     *
     *
     */
    @JsonProperty("labels")
    private Map<String, String> labels;
    /**
     *
     *
     */
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    /**
     *
     *
     */
    @JsonProperty("objects")
    private List<HasMetadata> objects = new ArrayList<>();
    /**
     *
     *
     */
    @JsonProperty("parameters")
    private List<Parameter> parameters = new ArrayList<>();

    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<>();


    /**
     * No args constructor for use in serialization
     */
    public Template() {
    }

    /**
     * @param apiVersion
     * @param labels
     * @param parameters
     * @param objects
     * @param kind
     * @param metadata
     */
    public Template(String apiVersion, java.lang.String kind, Map<String, String> labels, ObjectMeta metadata, List<HasMetadata> objects, List<Parameter> parameters) {
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.labels = labels;
        this.metadata = metadata;
        this.parameters = parameters;
        this.objects = objects;
    }

    /**
     * (Required)
     *
     * @return The apiVersion
     */
    @Override
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * (Required)
     *
     * @param apiVersion The apiVersion
     */
    @Override
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * (Required)
     *
     * @return The kind
     */
    @Override
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * (Required)
     *
     * @param kind The kind
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    /**
     * @return The labels
     */
    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * @return The metadata
     */
    @Override
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * @param metadata The metadata
     */
    @Override
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * @return The objects
     */
    @JsonProperty("objects")
    public List<HasMetadata> getObjects() {
        if (objects == null) {
            return Collections.emptyList();
        }
        final List<HasMetadata> sortedObjects = new ArrayList<>(objects);
        sortedObjects.sort(new HasMetadataComparator());
        return sortedObjects;
    }

    public void setObjects(List<HasMetadata> objects) {
        this.objects = objects;
    }

    /**
     * @return The parameters
     */
    @JsonProperty("parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * @param parameters The parameters
     */
    @JsonProperty("parameters")
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }
}
