package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceClassConfigurationBuilder extends DeviceClassConfigurationFluent<DeviceClassConfigurationBuilder> implements VisitableBuilder<DeviceClassConfiguration,DeviceClassConfigurationBuilder>{

  DeviceClassConfigurationFluent<?> fluent;

  public DeviceClassConfigurationBuilder() {
    this(new DeviceClassConfiguration());
  }
  
  public DeviceClassConfigurationBuilder(DeviceClassConfigurationFluent<?> fluent) {
    this(fluent, new DeviceClassConfiguration());
  }
  
  public DeviceClassConfigurationBuilder(DeviceClassConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceClassConfigurationBuilder(DeviceClassConfigurationFluent<?> fluent,DeviceClassConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceClassConfiguration build() {
    DeviceClassConfiguration buildable = new DeviceClassConfiguration(fluent.buildOpaque());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}