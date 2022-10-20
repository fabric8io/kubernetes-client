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
package io.fabric8.certmanager.api.model.v1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "isCA",
    "issuerRef",
    "request",
    "usages"
})
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = true, validationEnabled = false, generateBuilderPackage = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class CertificateRequestSpec implements KubernetesResource {

  @JsonProperty("duration")
  private Duration duration;
  @JsonProperty("isCA")
  private Boolean isCA;
  @JsonProperty("issuerRef")
  private io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef;
  @JsonProperty("request")
  private String request;
  @JsonProperty("usages")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> usages = new ArrayList<>();
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  /**
   * No args constructor for use in serialization
   *
   */
  public CertificateRequestSpec() {
  }

  /**
   *
   * @param duration
   * @param request
   * @param isCA
   * @param issuerRef
   * @param usages
   */
  public CertificateRequestSpec(Duration duration, Boolean isCA,
      io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef, String request, List<String> usages) {
    super();
    this.duration = duration;
    this.isCA = isCA;
    this.issuerRef = issuerRef;
    this.request = request;
    this.usages = usages;
  }

  @JsonProperty("duration")
  public Duration getDuration() {
    return duration;
  }

  @JsonProperty("duration")
  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  @JsonProperty("isCA")
  public Boolean getIsCA() {
    return isCA;
  }

  @JsonProperty("isCA")
  public void setIsCA(Boolean isCA) {
    this.isCA = isCA;
  }

  @JsonProperty("issuerRef")
  public io.fabric8.certmanager.api.model.meta.v1.ObjectReference getIssuerRef() {
    return issuerRef;
  }

  @JsonProperty("issuerRef")
  public void setIssuerRef(io.fabric8.certmanager.api.model.meta.v1.ObjectReference issuerRef) {
    this.issuerRef = issuerRef;
  }

  @JsonProperty("request")
  public String getRequest() {
    return request;
  }

  @JsonProperty("request")
  public void setRequest(String request) {
    this.request = request;
  }

  @JsonProperty("usages")
  public List<String> getUsages() {
    return usages;
  }

  @JsonProperty("usages")
  public void setUsages(List<String> usages) {
    this.usages = usages;
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
