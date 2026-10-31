package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeHealthStatusBuilder extends VolumeHealthStatusFluent<VolumeHealthStatusBuilder> implements VisitableBuilder<VolumeHealthStatus,VolumeHealthStatusBuilder>{

  VolumeHealthStatusFluent<?> fluent;

  public VolumeHealthStatusBuilder() {
    this(new VolumeHealthStatus());
  }
  
  public VolumeHealthStatusBuilder(VolumeHealthStatusFluent<?> fluent) {
    this(fluent, new VolumeHealthStatus());
  }
  
  public VolumeHealthStatusBuilder(VolumeHealthStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeHealthStatusBuilder(VolumeHealthStatusFluent<?> fluent,VolumeHealthStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeHealthStatus build() {
    VolumeHealthStatus buildable = new VolumeHealthStatus(fluent.buildHealthConditions(), fluent.getLastTransitionTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}