package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BlockDeviceVolumeBuilder extends BlockDeviceVolumeFluent<BlockDeviceVolumeBuilder> implements VisitableBuilder<BlockDeviceVolume,BlockDeviceVolumeBuilder>{

  BlockDeviceVolumeFluent<?> fluent;

  public BlockDeviceVolumeBuilder() {
    this(new BlockDeviceVolume());
  }
  
  public BlockDeviceVolumeBuilder(BlockDeviceVolumeFluent<?> fluent) {
    this(fluent, new BlockDeviceVolume());
  }
  
  public BlockDeviceVolumeBuilder(BlockDeviceVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BlockDeviceVolumeBuilder(BlockDeviceVolumeFluent<?> fluent,BlockDeviceVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BlockDeviceVolume build() {
    BlockDeviceVolume buildable = new BlockDeviceVolume(fluent.getAvailabilityZone(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}