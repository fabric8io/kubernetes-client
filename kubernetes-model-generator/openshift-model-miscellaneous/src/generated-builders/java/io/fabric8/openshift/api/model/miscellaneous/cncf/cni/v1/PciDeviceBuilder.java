package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PciDeviceBuilder extends PciDeviceFluent<PciDeviceBuilder> implements VisitableBuilder<PciDevice,PciDeviceBuilder>{

  PciDeviceFluent<?> fluent;

  public PciDeviceBuilder() {
    this(new PciDevice());
  }
  
  public PciDeviceBuilder(PciDeviceFluent<?> fluent) {
    this(fluent, new PciDevice());
  }
  
  public PciDeviceBuilder(PciDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PciDeviceBuilder(PciDeviceFluent<?> fluent,PciDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PciDevice build() {
    PciDevice buildable = new PciDevice(fluent.getPciAddress(), fluent.getPfPciAddress(), fluent.getRdmaDevice(), fluent.getRepresentorDevice(), fluent.getVhostNet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}