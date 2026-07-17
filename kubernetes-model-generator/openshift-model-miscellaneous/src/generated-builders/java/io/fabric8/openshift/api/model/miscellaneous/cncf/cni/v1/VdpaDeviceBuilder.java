package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VdpaDeviceBuilder extends VdpaDeviceFluent<VdpaDeviceBuilder> implements VisitableBuilder<VdpaDevice,VdpaDeviceBuilder>{

  VdpaDeviceFluent<?> fluent;

  public VdpaDeviceBuilder() {
    this(new VdpaDevice());
  }
  
  public VdpaDeviceBuilder(VdpaDeviceFluent<?> fluent) {
    this(fluent, new VdpaDevice());
  }
  
  public VdpaDeviceBuilder(VdpaDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VdpaDeviceBuilder(VdpaDeviceFluent<?> fluent,VdpaDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VdpaDevice build() {
    VdpaDevice buildable = new VdpaDevice(fluent.getDriver(), fluent.getParentDevice(), fluent.getPath(), fluent.getPciAddress(), fluent.getPfPciAddress(), fluent.getRepresentorDevice());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}