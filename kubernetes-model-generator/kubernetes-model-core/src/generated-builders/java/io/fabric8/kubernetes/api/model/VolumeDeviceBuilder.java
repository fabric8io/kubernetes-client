package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeDeviceBuilder extends VolumeDeviceFluent<VolumeDeviceBuilder> implements VisitableBuilder<VolumeDevice,VolumeDeviceBuilder>{

  VolumeDeviceFluent<?> fluent;

  public VolumeDeviceBuilder() {
    this(new VolumeDevice());
  }
  
  public VolumeDeviceBuilder(VolumeDeviceFluent<?> fluent) {
    this(fluent, new VolumeDevice());
  }
  
  public VolumeDeviceBuilder(VolumeDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeDeviceBuilder(VolumeDeviceFluent<?> fluent,VolumeDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeDevice build() {
    VolumeDevice buildable = new VolumeDevice(fluent.getDevicePath(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}