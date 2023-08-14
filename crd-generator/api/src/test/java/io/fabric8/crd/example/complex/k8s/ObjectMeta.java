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
package io.fabric8.crd.example.complex.k8s;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.model.KubernetesResource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Simplified version of the K8s ObjectMeta.
 *
 * The purpose of this class is to create a complex, but stable CRD, that doesn't change when the generated ObjectMeta class is
 * changed.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "annotations",
    "creationTimestamp",
    "deletionGracePeriodSeconds",
    "deletionTimestamp",
    "finalizers",
    "generateName",
    "generation",
    "labels",
    "name",
    "namespace",
    "resourceVersion",
    "selfLink",
    "uid"
})
public class ObjectMeta implements KubernetesResource {

  @JsonProperty("annotations")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Map<String, String> annotations = new LinkedHashMap<>();
  @JsonProperty("creationTimestamp")
  private String creationTimestamp;
  @JsonProperty("deletionGracePeriodSeconds")
  private Long deletionGracePeriodSeconds;
  @JsonProperty("deletionTimestamp")
  private String deletionTimestamp;
  @JsonProperty("finalizers")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> finalizers = new ArrayList<>();
  @JsonProperty("generateName")
  private String generateName;
  @JsonProperty("generation")
  private Long generation;
  @JsonProperty("labels")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Map<String, String> labels = new LinkedHashMap<>();
  @JsonProperty("name")
  private String name;
  @JsonProperty("namespace")
  private String namespace;
  @JsonProperty("resourceVersion")
  private String resourceVersion;
  @JsonProperty("selfLink")
  private String selfLink;
  @JsonProperty("uid")
  private String uid;
  @JsonIgnore
  private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

  public ObjectMeta() {
  }

  @JsonProperty("annotations")
  public Map<String, String> getAnnotations() {
    return annotations;
  }

  @JsonProperty("annotations")
  public void setAnnotations(Map<String, String> annotations) {
    this.annotations = annotations;
  }

  @JsonProperty("creationTimestamp")
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  @JsonProperty("creationTimestamp")
  public void setCreationTimestamp(String creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }

  @JsonProperty("deletionGracePeriodSeconds")
  public Long getDeletionGracePeriodSeconds() {
    return deletionGracePeriodSeconds;
  }

  @JsonProperty("deletionGracePeriodSeconds")
  public void setDeletionGracePeriodSeconds(Long deletionGracePeriodSeconds) {
    this.deletionGracePeriodSeconds = deletionGracePeriodSeconds;
  }

  @JsonProperty("deletionTimestamp")
  public String getDeletionTimestamp() {
    return deletionTimestamp;
  }

  @JsonProperty("deletionTimestamp")
  public void setDeletionTimestamp(String deletionTimestamp) {
    this.deletionTimestamp = deletionTimestamp;
  }

  @JsonProperty("finalizers")
  public List<String> getFinalizers() {
    return finalizers;
  }

  @JsonProperty("finalizers")
  public void setFinalizers(List<String> finalizers) {
    this.finalizers = finalizers;
  }

  @JsonProperty("generateName")
  public String getGenerateName() {
    return generateName;
  }

  @JsonProperty("generateName")
  public void setGenerateName(String generateName) {
    this.generateName = generateName;
  }

  @JsonProperty("generation")
  public Long getGeneration() {
    return generation;
  }

  @JsonProperty("generation")
  public void setGeneration(Long generation) {
    this.generation = generation;
  }

  @JsonProperty("labels")
  public Map<String, String> getLabels() {
    return labels;
  }

  @JsonProperty("labels")
  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("namespace")
  public String getNamespace() {
    return namespace;
  }

  @JsonProperty("namespace")
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  @JsonProperty("resourceVersion")
  public String getResourceVersion() {
    return resourceVersion;
  }

  @JsonProperty("resourceVersion")
  public void setResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
  }

  @JsonProperty("selfLink")
  public String getSelfLink() {
    return selfLink;
  }

  @JsonProperty("selfLink")
  public void setSelfLink(String selfLink) {
    this.selfLink = selfLink;
  }

  @JsonProperty("uid")
  public String getUid() {
    return uid;
  }

  @JsonProperty("uid")
  public void setUid(String uid) {
    this.uid = uid;
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
