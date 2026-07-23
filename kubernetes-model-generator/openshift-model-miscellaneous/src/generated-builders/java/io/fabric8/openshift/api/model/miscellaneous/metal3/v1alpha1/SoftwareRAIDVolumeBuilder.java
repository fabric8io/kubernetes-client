package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SoftwareRAIDVolumeBuilder extends SoftwareRAIDVolumeFluent<SoftwareRAIDVolumeBuilder> implements VisitableBuilder<SoftwareRAIDVolume,SoftwareRAIDVolumeBuilder>{

  SoftwareRAIDVolumeFluent<?> fluent;

  public SoftwareRAIDVolumeBuilder() {
    this(new SoftwareRAIDVolume());
  }
  
  public SoftwareRAIDVolumeBuilder(SoftwareRAIDVolumeFluent<?> fluent) {
    this(fluent, new SoftwareRAIDVolume());
  }
  
  public SoftwareRAIDVolumeBuilder(SoftwareRAIDVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SoftwareRAIDVolumeBuilder(SoftwareRAIDVolumeFluent<?> fluent,SoftwareRAIDVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SoftwareRAIDVolume build() {
    SoftwareRAIDVolume buildable = new SoftwareRAIDVolume(fluent.getLevel(), fluent.buildPhysicalDisks(), fluent.getSizeGibibytes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}