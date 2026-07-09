package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTaintBuilder extends DeviceTaintFluent<DeviceTaintBuilder> implements VisitableBuilder<DeviceTaint,DeviceTaintBuilder>{

  DeviceTaintFluent<?> fluent;

  public DeviceTaintBuilder() {
    this(new DeviceTaint());
  }
  
  public DeviceTaintBuilder(DeviceTaintFluent<?> fluent) {
    this(fluent, new DeviceTaint());
  }
  
  public DeviceTaintBuilder(DeviceTaint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTaintBuilder(DeviceTaintFluent<?> fluent,DeviceTaint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceTaint build() {
    DeviceTaint buildable = new DeviceTaint(fluent.getEffect(), fluent.getKey(), fluent.getTimeAdded(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}