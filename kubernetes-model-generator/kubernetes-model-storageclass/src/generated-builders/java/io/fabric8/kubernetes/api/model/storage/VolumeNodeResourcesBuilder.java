package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeNodeResourcesBuilder extends VolumeNodeResourcesFluent<VolumeNodeResourcesBuilder> implements VisitableBuilder<VolumeNodeResources,VolumeNodeResourcesBuilder>{

  VolumeNodeResourcesFluent<?> fluent;

  public VolumeNodeResourcesBuilder() {
    this(new VolumeNodeResources());
  }
  
  public VolumeNodeResourcesBuilder(VolumeNodeResourcesFluent<?> fluent) {
    this(fluent, new VolumeNodeResources());
  }
  
  public VolumeNodeResourcesBuilder(VolumeNodeResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeNodeResourcesBuilder(VolumeNodeResourcesFluent<?> fluent,VolumeNodeResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeNodeResources build() {
    VolumeNodeResources buildable = new VolumeNodeResources(fluent.getCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}