package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ModifyVolumeStatusBuilder extends ModifyVolumeStatusFluent<ModifyVolumeStatusBuilder> implements VisitableBuilder<ModifyVolumeStatus,ModifyVolumeStatusBuilder>{

  ModifyVolumeStatusFluent<?> fluent;

  public ModifyVolumeStatusBuilder() {
    this(new ModifyVolumeStatus());
  }
  
  public ModifyVolumeStatusBuilder(ModifyVolumeStatusFluent<?> fluent) {
    this(fluent, new ModifyVolumeStatus());
  }
  
  public ModifyVolumeStatusBuilder(ModifyVolumeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ModifyVolumeStatusBuilder(ModifyVolumeStatusFluent<?> fluent,ModifyVolumeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ModifyVolumeStatus build() {
    ModifyVolumeStatus buildable = new ModifyVolumeStatus(fluent.getStatus(), fluent.getTargetVolumeAttributesClassName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}