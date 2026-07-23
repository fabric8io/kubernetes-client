package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceInfoBuilder extends DeviceInfoFluent<DeviceInfoBuilder> implements VisitableBuilder<DeviceInfo,DeviceInfoBuilder>{

  DeviceInfoFluent<?> fluent;

  public DeviceInfoBuilder() {
    this(new DeviceInfo());
  }
  
  public DeviceInfoBuilder(DeviceInfoFluent<?> fluent) {
    this(fluent, new DeviceInfo());
  }
  
  public DeviceInfoBuilder(DeviceInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceInfoBuilder(DeviceInfoFluent<?> fluent,DeviceInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceInfo build() {
    DeviceInfo buildable = new DeviceInfo(fluent.buildMemif(), fluent.buildPci(), fluent.getType(), fluent.buildVdpa(), fluent.getVersion(), fluent.buildVhostUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}