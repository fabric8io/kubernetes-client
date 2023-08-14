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
package io.fabric8.crd.example.complex;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.fabric8.crd.example.complex.k8s.ObjectMeta;
import io.fabric8.crd.example.complex.k8s.StatefulSetSpec;

@SuppressWarnings("LombokGetterMayBeUsed")
public class StatefulSetConfiguration {

  @JsonProperty("metadata")
  @JsonPropertyDescription("The metadata of this StatefulSet")
  private ObjectMeta metadata = new ObjectMeta();

  @JsonProperty("spec")
  @JsonPropertyDescription("The spec of this StatefulSet")
  private StatefulSetSpec spec = new StatefulSetSpec();

  public StatefulSetConfiguration() {
  }

  public ObjectMeta getMetadata() {
    return metadata;
  }

  public void setMetadata(final ObjectMeta metadata) {
    this.metadata = metadata;
  }

  public StatefulSetSpec getSpec() {
    return spec;
  }

  public void setSpec(final StatefulSetSpec spec) {
    this.spec = spec;
  }
}
