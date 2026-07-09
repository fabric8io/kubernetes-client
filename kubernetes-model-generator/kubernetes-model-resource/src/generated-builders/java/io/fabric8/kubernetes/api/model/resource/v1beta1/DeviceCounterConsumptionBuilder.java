package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceCounterConsumptionBuilder extends DeviceCounterConsumptionFluent<DeviceCounterConsumptionBuilder> implements VisitableBuilder<DeviceCounterConsumption,DeviceCounterConsumptionBuilder>{

  DeviceCounterConsumptionFluent<?> fluent;

  public DeviceCounterConsumptionBuilder() {
    this(new DeviceCounterConsumption());
  }
  
  public DeviceCounterConsumptionBuilder(DeviceCounterConsumptionFluent<?> fluent) {
    this(fluent, new DeviceCounterConsumption());
  }
  
  public DeviceCounterConsumptionBuilder(DeviceCounterConsumption instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceCounterConsumptionBuilder(DeviceCounterConsumptionFluent<?> fluent,DeviceCounterConsumption instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceCounterConsumption build() {
    DeviceCounterConsumption buildable = new DeviceCounterConsumption(fluent.getCounterSet(), fluent.getCounters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}