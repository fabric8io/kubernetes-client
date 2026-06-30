package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeNodeAffinityBuilder extends VolumeNodeAffinityFluent<VolumeNodeAffinityBuilder> implements VisitableBuilder<VolumeNodeAffinity,VolumeNodeAffinityBuilder>{

  VolumeNodeAffinityFluent<?> fluent;

  public VolumeNodeAffinityBuilder() {
    this(new VolumeNodeAffinity());
  }
  
  public VolumeNodeAffinityBuilder(VolumeNodeAffinityFluent<?> fluent) {
    this(fluent, new VolumeNodeAffinity());
  }
  
  public VolumeNodeAffinityBuilder(VolumeNodeAffinity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeNodeAffinityBuilder(VolumeNodeAffinityFluent<?> fluent,VolumeNodeAffinity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeNodeAffinity build() {
    VolumeNodeAffinity buildable = new VolumeNodeAffinity(fluent.buildRequired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}