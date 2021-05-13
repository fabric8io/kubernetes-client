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
package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * This class is used by KubernetesAttributesExtractor as a fallback for when it can't deserialize
 * the request bodies into KubernetesResource. This happens when using the Raw CustomResource API.
 */
// Override the default KubernetesSerializer so that it doesn't try to deserialize into registered types
@JsonDeserialize(using = None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FallbackHasMetadata implements HasMetadata {

  private String apiVersion;
  private String kind;
  private ObjectMeta metadata;

  /**
   * No args constructor for use in serialization
   *
   */
  public FallbackHasMetadata() {
  }

  public FallbackHasMetadata(String apiVersion, String kind, ObjectMeta metadata) {
    this.apiVersion = apiVersion;
    this.kind = kind;
    this.metadata = metadata;
  }


  @Override
  @JsonProperty("apiVersion")
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  @JsonProperty("apiVersion")
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  @Override
  @JsonProperty("kind")
  public String getKind() {
    return kind;
  }

  @JsonProperty("kind")
  public void setKind(String kind) {
    this.kind = kind;
  }

  @Override
  @JsonProperty("metadata")
  public ObjectMeta getMetadata() {
    return metadata;
  }

  @Override
  @JsonProperty("metadata")
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }

}
