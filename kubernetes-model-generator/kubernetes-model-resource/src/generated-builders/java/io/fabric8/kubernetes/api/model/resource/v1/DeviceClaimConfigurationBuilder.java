package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceClaimConfigurationBuilder extends DeviceClaimConfigurationFluent<DeviceClaimConfigurationBuilder> implements VisitableBuilder<DeviceClaimConfiguration,DeviceClaimConfigurationBuilder>{

  DeviceClaimConfigurationFluent<?> fluent;

  public DeviceClaimConfigurationBuilder() {
    this(new DeviceClaimConfiguration());
  }
  
  public DeviceClaimConfigurationBuilder(DeviceClaimConfigurationFluent<?> fluent) {
    this(fluent, new DeviceClaimConfiguration());
  }
  
  public DeviceClaimConfigurationBuilder(DeviceClaimConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceClaimConfigurationBuilder(DeviceClaimConfigurationFluent<?> fluent,DeviceClaimConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceClaimConfiguration build() {
    DeviceClaimConfiguration buildable = new DeviceClaimConfiguration(fluent.buildOpaque(), fluent.getRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}