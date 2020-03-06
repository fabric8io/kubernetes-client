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
package io.fabric8.knative.serving.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.v1.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Volume;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.builder.annotations.Inline;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Modified version of the ServiceStatus class to make sure that .Status.URL isn't attempted to be
 * deserialized as {@link io.fabric8.knative.v1.URL}. The url is actually just a normal String
 */
@JsonIgnoreType // no need to send it back to the server
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", inline = {
  @Inline(type = Doneable.class, prefix = "Doneable", value = "done")
}, refs = {
  @BuildableReference(ObjectMeta.class),
  @BuildableReference(Volume.class),
  @BuildableReference(Container.class)
})
public class ServiceStatus implements KubernetesResource {

  private Addressable address;
  private List<Condition> conditions = new ArrayList<>();
  private String latestCreatedRevisionName;
  private String latestReadyRevisionName;
  private Long observedGeneration;
  private List<TrafficTarget> traffic = new ArrayList<>();
  private String url;
  private Map<String, Object> additionalProperties = new HashMap<>();

  public ServiceStatus(final Addressable address,
                       final List<Condition> conditions,
                       final String latestCreatedRevisionName,
                       final String latestReadyRevisionName,
                       final Long observedGeneration,
                       final List<TrafficTarget> traffic,
                       final String url) {
    this.address = address;
    this.conditions = conditions;
    this.latestCreatedRevisionName = latestCreatedRevisionName;
    this.latestReadyRevisionName = latestReadyRevisionName;
    this.observedGeneration = observedGeneration;
    this.traffic = traffic;
    this.url = url;
  }

  public Addressable getAddress() {
    return address;
  }

  public void setAddress(final Addressable address) {
    this.address = address;
  }

  public List<Condition> getConditions() {
    return conditions;
  }

  public void setConditions(final List<Condition> conditions) {
    this.conditions = conditions;
  }

  public String getLatestCreatedRevisionName() {
    return latestCreatedRevisionName;
  }

  public void setLatestCreatedRevisionName(final String latestCreatedRevisionName) {
    this.latestCreatedRevisionName = latestCreatedRevisionName;
  }

  public String getLatestReadyRevisionName() {
    return latestReadyRevisionName;
  }

  public void setLatestReadyRevisionName(final String latestReadyRevisionName) {
    this.latestReadyRevisionName = latestReadyRevisionName;
  }

  public Long getObservedGeneration() {
    return observedGeneration;
  }

  public void setObservedGeneration(final Long observedGeneration) {
    this.observedGeneration = observedGeneration;
  }

  public List<TrafficTarget> getTraffic() {
    return traffic;
  }

  public void setTraffic(final List<TrafficTarget> traffic) {
    this.traffic = traffic;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(final Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
