package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VsphereVirtualDiskVolumeSourceBuilder extends VsphereVirtualDiskVolumeSourceFluent<VsphereVirtualDiskVolumeSourceBuilder> implements VisitableBuilder<VsphereVirtualDiskVolumeSource,VsphereVirtualDiskVolumeSourceBuilder>{

  VsphereVirtualDiskVolumeSourceFluent<?> fluent;

  public VsphereVirtualDiskVolumeSourceBuilder() {
    this(new VsphereVirtualDiskVolumeSource());
  }
  
  public VsphereVirtualDiskVolumeSourceBuilder(VsphereVirtualDiskVolumeSourceFluent<?> fluent) {
    this(fluent, new VsphereVirtualDiskVolumeSource());
  }
  
  public VsphereVirtualDiskVolumeSourceBuilder(VsphereVirtualDiskVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VsphereVirtualDiskVolumeSourceBuilder(VsphereVirtualDiskVolumeSourceFluent<?> fluent,VsphereVirtualDiskVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VsphereVirtualDiskVolumeSource build() {
    VsphereVirtualDiskVolumeSource buildable = new VsphereVirtualDiskVolumeSource(fluent.getFsType(), fluent.getStoragePolicyID(), fluent.getStoragePolicyName(), fluent.getVolumePath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}