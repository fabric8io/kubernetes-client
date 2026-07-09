package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTolerationBuilder extends DeviceTolerationFluent<DeviceTolerationBuilder> implements VisitableBuilder<DeviceToleration,DeviceTolerationBuilder>{

  DeviceTolerationFluent<?> fluent;

  public DeviceTolerationBuilder() {
    this(new DeviceToleration());
  }
  
  public DeviceTolerationBuilder(DeviceTolerationFluent<?> fluent) {
    this(fluent, new DeviceToleration());
  }
  
  public DeviceTolerationBuilder(DeviceToleration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTolerationBuilder(DeviceTolerationFluent<?> fluent,DeviceToleration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceToleration build() {
    DeviceToleration buildable = new DeviceToleration(fluent.getEffect(), fluent.getKey(), fluent.getOperator(), fluent.getTolerationSeconds(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}