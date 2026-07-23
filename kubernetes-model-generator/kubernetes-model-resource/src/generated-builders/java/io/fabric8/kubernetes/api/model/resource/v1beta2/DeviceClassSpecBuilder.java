package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceClassSpecBuilder extends DeviceClassSpecFluent<DeviceClassSpecBuilder> implements VisitableBuilder<DeviceClassSpec,DeviceClassSpecBuilder>{

  DeviceClassSpecFluent<?> fluent;

  public DeviceClassSpecBuilder() {
    this(new DeviceClassSpec());
  }
  
  public DeviceClassSpecBuilder(DeviceClassSpecFluent<?> fluent) {
    this(fluent, new DeviceClassSpec());
  }
  
  public DeviceClassSpecBuilder(DeviceClassSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceClassSpecBuilder(DeviceClassSpecFluent<?> fluent,DeviceClassSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceClassSpec build() {
    DeviceClassSpec buildable = new DeviceClassSpec(fluent.buildConfig(), fluent.getExtendedResourceName(), fluent.buildSelectors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}