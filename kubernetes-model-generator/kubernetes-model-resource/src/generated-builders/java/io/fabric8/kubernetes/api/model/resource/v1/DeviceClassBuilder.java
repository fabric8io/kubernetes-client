package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceClassBuilder extends DeviceClassFluent<DeviceClassBuilder> implements VisitableBuilder<DeviceClass,DeviceClassBuilder>{

  DeviceClassFluent<?> fluent;

  public DeviceClassBuilder() {
    this(new DeviceClass());
  }
  
  public DeviceClassBuilder(DeviceClassFluent<?> fluent) {
    this(fluent, new DeviceClass());
  }
  
  public DeviceClassBuilder(DeviceClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceClassBuilder(DeviceClassFluent<?> fluent,DeviceClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceClass build() {
    DeviceClass buildable = new DeviceClass(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}