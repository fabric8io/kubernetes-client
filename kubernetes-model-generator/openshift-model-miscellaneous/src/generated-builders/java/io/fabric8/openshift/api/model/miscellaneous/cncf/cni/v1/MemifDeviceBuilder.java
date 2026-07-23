package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MemifDeviceBuilder extends MemifDeviceFluent<MemifDeviceBuilder> implements VisitableBuilder<MemifDevice,MemifDeviceBuilder>{

  MemifDeviceFluent<?> fluent;

  public MemifDeviceBuilder() {
    this(new MemifDevice());
  }
  
  public MemifDeviceBuilder(MemifDeviceFluent<?> fluent) {
    this(fluent, new MemifDevice());
  }
  
  public MemifDeviceBuilder(MemifDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MemifDeviceBuilder(MemifDeviceFluent<?> fluent,MemifDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MemifDevice build() {
    MemifDevice buildable = new MemifDevice(fluent.getMode(), fluent.getPath(), fluent.getRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}