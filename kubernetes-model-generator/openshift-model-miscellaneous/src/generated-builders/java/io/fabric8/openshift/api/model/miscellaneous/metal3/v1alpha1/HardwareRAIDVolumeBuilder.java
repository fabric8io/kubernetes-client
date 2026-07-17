package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HardwareRAIDVolumeBuilder extends HardwareRAIDVolumeFluent<HardwareRAIDVolumeBuilder> implements VisitableBuilder<HardwareRAIDVolume,HardwareRAIDVolumeBuilder>{

  HardwareRAIDVolumeFluent<?> fluent;

  public HardwareRAIDVolumeBuilder() {
    this(new HardwareRAIDVolume());
  }
  
  public HardwareRAIDVolumeBuilder(HardwareRAIDVolumeFluent<?> fluent) {
    this(fluent, new HardwareRAIDVolume());
  }
  
  public HardwareRAIDVolumeBuilder(HardwareRAIDVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HardwareRAIDVolumeBuilder(HardwareRAIDVolumeFluent<?> fluent,HardwareRAIDVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HardwareRAIDVolume build() {
    HardwareRAIDVolume buildable = new HardwareRAIDVolume(fluent.getController(), fluent.getLevel(), fluent.getName(), fluent.getNumberOfPhysicalDisks(), fluent.getPhysicalDisks(), fluent.getRotational(), fluent.getSizeGibibytes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}