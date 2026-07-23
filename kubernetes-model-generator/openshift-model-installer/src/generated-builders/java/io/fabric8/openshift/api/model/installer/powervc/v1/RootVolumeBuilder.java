package io.fabric8.openshift.api.model.installer.powervc.v1;

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
    RootVolume buildable = new RootVolume(fluent.getSize(), fluent.getType(), fluent.getTypes(), fluent.getZones());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}