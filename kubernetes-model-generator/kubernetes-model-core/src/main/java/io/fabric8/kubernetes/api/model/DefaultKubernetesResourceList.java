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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@Getter
@Setter
@ToString
public class DefaultKubernetesResourceList<T extends HasMetadata> implements KubernetesResource, KubernetesResourceList<T> {

  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("items")
  private List<T> items = new ArrayList<>();

  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ListMeta metadata;
}
