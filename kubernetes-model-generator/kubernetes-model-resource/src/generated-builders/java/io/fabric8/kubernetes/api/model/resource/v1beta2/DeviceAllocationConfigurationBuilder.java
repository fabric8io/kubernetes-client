package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceAllocationConfigurationBuilder extends DeviceAllocationConfigurationFluent<DeviceAllocationConfigurationBuilder> implements VisitableBuilder<DeviceAllocationConfiguration,DeviceAllocationConfigurationBuilder>{

  DeviceAllocationConfigurationFluent<?> fluent;

  public DeviceAllocationConfigurationBuilder() {
    this(new DeviceAllocationConfiguration());
  }
  
  public DeviceAllocationConfigurationBuilder(DeviceAllocationConfigurationFluent<?> fluent) {
    this(fluent, new DeviceAllocationConfiguration());
  }
  
  public DeviceAllocationConfigurationBuilder(DeviceAllocationConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceAllocationConfigurationBuilder(DeviceAllocationConfigurationFluent<?> fluent,DeviceAllocationConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceAllocationConfiguration build() {
    DeviceAllocationConfiguration buildable = new DeviceAllocationConfiguration(fluent.buildOpaque(), fluent.getRequests(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}