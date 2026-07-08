package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeStatusBuilder extends VolumeStatusFluent<VolumeStatusBuilder> implements VisitableBuilder<VolumeStatus,VolumeStatusBuilder>{

  VolumeStatusFluent<?> fluent;

  public VolumeStatusBuilder() {
    this(new VolumeStatus());
  }
  
  public VolumeStatusBuilder(VolumeStatusFluent<?> fluent) {
    this(fluent, new VolumeStatus());
  }
  
  public VolumeStatusBuilder(VolumeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeStatusBuilder(VolumeStatusFluent<?> fluent,VolumeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeStatus build() {
    VolumeStatus buildable = new VolumeStatus(fluent.buildImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}