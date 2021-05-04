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

package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "apiGroups",
    "clusterScope",
    "namespaces",
    "resources",
    "verbs"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ResourcePolicyRule implements KubernetesResource
{

    @JsonProperty("apiGroups")
    private List<String> apiGroups = new ArrayList<String>();
    @JsonProperty("clusterScope")
    private Boolean clusterScope;
    @JsonProperty("namespaces")
    private List<String> namespaces = new ArrayList<String>();
    @JsonProperty("resources")
    private List<String> resources = new ArrayList<String>();
    @JsonProperty("verbs")
    private List<String> verbs = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourcePolicyRule() {
    }

    /**
     * 
     * @param clusterScope
     * @param resources
     * @param verbs
     * @param apiGroups
     * @param namespaces
     */
    public ResourcePolicyRule(List<String> apiGroups, Boolean clusterScope, List<String> namespaces, List<String> resources, List<String> verbs) {
        super();
        this.apiGroups = apiGroups;
        this.clusterScope = clusterScope;
        this.namespaces = namespaces;
        this.resources = resources;
        this.verbs = verbs;
    }

    @JsonProperty("apiGroups")
    public List<String> getApiGroups() {
        return apiGroups;
    }

    @JsonProperty("apiGroups")
    public void setApiGroups(List<String> apiGroups) {
        this.apiGroups = apiGroups;
    }

    @JsonProperty("clusterScope")
    public Boolean getClusterScope() {
        return clusterScope;
    }

    @JsonProperty("clusterScope")
    public void setClusterScope(Boolean clusterScope) {
        this.clusterScope = clusterScope;
    }

    @JsonProperty("namespaces")
    public List<String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("resources")
    public List<String> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @JsonProperty("verbs")
    public List<String> getVerbs() {
        return verbs;
    }

    @JsonProperty("verbs")
    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
