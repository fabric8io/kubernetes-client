package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VhostDeviceBuilder extends VhostDeviceFluent<VhostDeviceBuilder> implements VisitableBuilder<VhostDevice,VhostDeviceBuilder>{

  VhostDeviceFluent<?> fluent;

  public VhostDeviceBuilder() {
    this(new VhostDevice());
  }
  
  public VhostDeviceBuilder(VhostDeviceFluent<?> fluent) {
    this(fluent, new VhostDevice());
  }
  
  public VhostDeviceBuilder(VhostDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VhostDeviceBuilder(VhostDeviceFluent<?> fluent,VhostDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VhostDevice build() {
    VhostDevice buildable = new VhostDevice(fluent.getMode(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}