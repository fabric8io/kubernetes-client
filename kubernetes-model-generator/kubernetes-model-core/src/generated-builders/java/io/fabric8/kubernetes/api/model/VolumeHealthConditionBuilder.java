package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeHealthConditionBuilder extends VolumeHealthConditionFluent<VolumeHealthConditionBuilder> implements VisitableBuilder<VolumeHealthCondition,VolumeHealthConditionBuilder>{

  VolumeHealthConditionFluent<?> fluent;

  public VolumeHealthConditionBuilder() {
    this(new VolumeHealthCondition());
  }
  
  public VolumeHealthConditionBuilder(VolumeHealthConditionFluent<?> fluent) {
    this(fluent, new VolumeHealthCondition());
  }
  
  public VolumeHealthConditionBuilder(VolumeHealthCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeHealthConditionBuilder(VolumeHealthConditionFluent<?> fluent,VolumeHealthCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeHealthCondition build() {
    VolumeHealthCondition buildable = new VolumeHealthCondition(fluent.getMessage(), fluent.getReason(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}