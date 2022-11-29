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
package io.fabric8.istio.api.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowCredentials",
    "allowHeaders",
    "allowMethods",
    "allowOrigin",
    "allowOrigins",
    "exposeHeaders",
    "maxAge"
})
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class CorsPolicy implements KubernetesResource {

  @JsonProperty("allowCredentials")
  private Boolean allowCredentials;
  @JsonProperty("allowHeaders")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> allowHeaders = new ArrayList<>();
  @JsonProperty("allowMethods")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> allowMethods = new ArrayList<>();
  @JsonProperty("allowOrigin")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> deprecatedAllowOrigin = new ArrayList<>();
  @JsonProperty("allowOrigins")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<StringMatch> allowOrigins = new ArrayList<>();
  @JsonProperty("exposeHeaders")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> exposeHeaders = new ArrayList<>();
  @JsonProperty("maxAge")
  private String maxAge;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  /**
   * No args constructor for use in serialization
   */
  public CorsPolicy() {
  }

  /**
   * @param allowMethods
   * @param allowHeaders
   * @param exposeHeaders
   * @param maxAge
   * @param allowCredentials
   * @param deprecatedAllowOrigin
   * @param allowOrigins
   */
  public CorsPolicy(Boolean allowCredentials, List<String> allowHeaders, List<String> allowMethods,
      List<String> deprecatedAllowOrigin, List<StringMatch> allowOrigins, List<String> exposeHeaders, String maxAge) {
    super();
    this.allowCredentials = allowCredentials;
    this.allowHeaders = allowHeaders;
    this.allowMethods = allowMethods;
    this.deprecatedAllowOrigin = deprecatedAllowOrigin;
    this.allowOrigins = allowOrigins;
    this.exposeHeaders = exposeHeaders;
    this.maxAge = maxAge;
  }

  @JsonProperty("allowCredentials")
  public Boolean getAllowCredentials() {
    return allowCredentials;
  }

  @JsonProperty("allowCredentials")
  public void setAllowCredentials(Boolean allowCredentials) {
    this.allowCredentials = allowCredentials;
  }

  @JsonProperty("allowHeaders")
  public List<String> getAllowHeaders() {
    return allowHeaders;
  }

  @JsonProperty("allowHeaders")
  public void setAllowHeaders(List<String> allowHeaders) {
    this.allowHeaders = allowHeaders;
  }

  @JsonProperty("allowMethods")
  public List<String> getAllowMethods() {
    return allowMethods;
  }

  @JsonProperty("allowMethods")
  public void setAllowMethods(List<String> allowMethods) {
    this.allowMethods = allowMethods;
  }

  @JsonProperty("allowOrigin")
  public List<String> getDeprecatedAllowOrigin() {
    return deprecatedAllowOrigin;
  }

  @JsonProperty("allowOrigin")
  public void setDeprecatedAllowOrigin(List<String> deprecatedAllowOrigin) {
    this.deprecatedAllowOrigin = deprecatedAllowOrigin;
  }

  @JsonProperty("allowOrigins")
  public List<StringMatch> getAllowOrigins() {
    return allowOrigins;
  }

  @JsonProperty("allowOrigins")
  public void setAllowOrigins(List<StringMatch> allowOrigins) {
    this.allowOrigins = allowOrigins;
  }

  @JsonProperty("exposeHeaders")
  public List<String> getExposeHeaders() {
    return exposeHeaders;
  }

  @JsonProperty("exposeHeaders")
  public void setExposeHeaders(List<String> exposeHeaders) {
    this.exposeHeaders = exposeHeaders;
  }

  @JsonProperty("maxAge")
  public String getMaxAge() {
    return maxAge;
  }

  @JsonProperty("maxAge")
  public void setMaxAge(String maxAge) {
    this.maxAge = maxAge;
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
