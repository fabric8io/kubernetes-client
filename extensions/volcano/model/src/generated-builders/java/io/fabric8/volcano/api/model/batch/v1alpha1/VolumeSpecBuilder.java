package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeSpecBuilder extends VolumeSpecFluent<VolumeSpecBuilder> implements VisitableBuilder<VolumeSpec,VolumeSpecBuilder>{

  VolumeSpecFluent<?> fluent;

  public VolumeSpecBuilder() {
    this(new VolumeSpec());
  }
  
  public VolumeSpecBuilder(VolumeSpecFluent<?> fluent) {
    this(fluent, new VolumeSpec());
  }
  
  public VolumeSpecBuilder(VolumeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeSpecBuilder(VolumeSpecFluent<?> fluent,VolumeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeSpec build() {
    VolumeSpec buildable = new VolumeSpec(fluent.getMountPath(), fluent.getVolumeClaim(), fluent.getVolumeClaimName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}