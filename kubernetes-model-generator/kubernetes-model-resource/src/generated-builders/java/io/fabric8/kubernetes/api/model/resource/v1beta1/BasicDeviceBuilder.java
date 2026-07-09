package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BasicDeviceBuilder extends BasicDeviceFluent<BasicDeviceBuilder> implements VisitableBuilder<BasicDevice,BasicDeviceBuilder>{

  BasicDeviceFluent<?> fluent;

  public BasicDeviceBuilder() {
    this(new BasicDevice());
  }
  
  public BasicDeviceBuilder(BasicDeviceFluent<?> fluent) {
    this(fluent, new BasicDevice());
  }
  
  public BasicDeviceBuilder(BasicDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BasicDeviceBuilder(BasicDeviceFluent<?> fluent,BasicDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BasicDevice build() {
    BasicDevice buildable = new BasicDevice(fluent.getAllNodes(), fluent.getAllowMultipleAllocations(), fluent.getAttributes(), fluent.getBindingConditions(), fluent.getBindingFailureConditions(), fluent.getBindsToNode(), fluent.getCapacity(), fluent.buildConsumesCounters(), fluent.getNodeAllocatableResourceMappings(), fluent.getNodeName(), fluent.getNodeSelector(), fluent.buildTaints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}