package io.fabric8.openshift.api.model.hive.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BootVolumeBuilder extends BootVolumeFluent<BootVolumeBuilder> implements VisitableBuilder<BootVolume,BootVolumeBuilder>{

  BootVolumeFluent<?> fluent;

  public BootVolumeBuilder() {
    this(new BootVolume());
  }
  
  public BootVolumeBuilder(BootVolumeFluent<?> fluent) {
    this(fluent, new BootVolume());
  }
  
  public BootVolumeBuilder(BootVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BootVolumeBuilder(BootVolumeFluent<?> fluent,BootVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BootVolume build() {
    BootVolume buildable = new BootVolume(fluent.getEncryptionKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}