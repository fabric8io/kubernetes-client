package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllowedFlexVolumeBuilder extends AllowedFlexVolumeFluent<AllowedFlexVolumeBuilder> implements VisitableBuilder<AllowedFlexVolume,AllowedFlexVolumeBuilder>{

  AllowedFlexVolumeFluent<?> fluent;

  public AllowedFlexVolumeBuilder() {
    this(new AllowedFlexVolume());
  }
  
  public AllowedFlexVolumeBuilder(AllowedFlexVolumeFluent<?> fluent) {
    this(fluent, new AllowedFlexVolume());
  }
  
  public AllowedFlexVolumeBuilder(AllowedFlexVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllowedFlexVolumeBuilder(AllowedFlexVolumeFluent<?> fluent,AllowedFlexVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllowedFlexVolume build() {
    AllowedFlexVolume buildable = new AllowedFlexVolume(fluent.getDriver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}