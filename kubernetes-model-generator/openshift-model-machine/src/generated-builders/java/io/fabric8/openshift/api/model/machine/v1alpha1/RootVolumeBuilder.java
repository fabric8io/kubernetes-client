package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RootVolumeBuilder extends RootVolumeFluent<RootVolumeBuilder> implements VisitableBuilder<RootVolume,RootVolumeBuilder>{

  RootVolumeFluent<?> fluent;

  public RootVolumeBuilder() {
    this(new RootVolume());
  }
  
  public RootVolumeBuilder(RootVolumeFluent<?> fluent) {
    this(fluent, new RootVolume());
  }
  
  public RootVolumeBuilder(RootVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RootVolumeBuilder(RootVolumeFluent<?> fluent,RootVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RootVolume build() {
    RootVolume buildable = new RootVolume(fluent.getAvailabilityZone(), fluent.getDeviceType(), fluent.getDiskSize(), fluent.getSourceType(), fluent.getSourceUUID(), fluent.getVolumeType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}