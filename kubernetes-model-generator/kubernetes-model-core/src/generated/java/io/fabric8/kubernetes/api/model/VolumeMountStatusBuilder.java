package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeMountStatusBuilder extends VolumeMountStatusFluent<VolumeMountStatusBuilder> implements VisitableBuilder<VolumeMountStatus,VolumeMountStatusBuilder>{

  VolumeMountStatusFluent<?> fluent;

  public VolumeMountStatusBuilder() {
    this(new VolumeMountStatus());
  }
  
  public VolumeMountStatusBuilder(VolumeMountStatusFluent<?> fluent) {
    this(fluent, new VolumeMountStatus());
  }
  
  public VolumeMountStatusBuilder(VolumeMountStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeMountStatusBuilder(VolumeMountStatusFluent<?> fluent,VolumeMountStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeMountStatus build() {
    VolumeMountStatus buildable = new VolumeMountStatus(fluent.getMountPath(), fluent.getName(), fluent.getReadOnly(), fluent.getRecursiveReadOnly(), fluent.buildVolumeStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}