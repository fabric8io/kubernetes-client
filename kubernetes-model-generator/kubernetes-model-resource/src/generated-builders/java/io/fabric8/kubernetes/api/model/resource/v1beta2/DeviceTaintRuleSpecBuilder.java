package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTaintRuleSpecBuilder extends DeviceTaintRuleSpecFluent<DeviceTaintRuleSpecBuilder> implements VisitableBuilder<DeviceTaintRuleSpec,DeviceTaintRuleSpecBuilder>{

  DeviceTaintRuleSpecFluent<?> fluent;

  public DeviceTaintRuleSpecBuilder() {
    this(new DeviceTaintRuleSpec());
  }
  
  public DeviceTaintRuleSpecBuilder(DeviceTaintRuleSpecFluent<?> fluent) {
    this(fluent, new DeviceTaintRuleSpec());
  }
  
  public DeviceTaintRuleSpecBuilder(DeviceTaintRuleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTaintRuleSpecBuilder(DeviceTaintRuleSpecFluent<?> fluent,DeviceTaintRuleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceTaintRuleSpec build() {
    DeviceTaintRuleSpec buildable = new DeviceTaintRuleSpec(fluent.buildDeviceSelector(), fluent.buildTaint());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}