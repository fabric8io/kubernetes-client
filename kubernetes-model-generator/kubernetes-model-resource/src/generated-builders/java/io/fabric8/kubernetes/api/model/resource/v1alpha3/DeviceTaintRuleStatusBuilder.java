package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTaintRuleStatusBuilder extends DeviceTaintRuleStatusFluent<DeviceTaintRuleStatusBuilder> implements VisitableBuilder<DeviceTaintRuleStatus,DeviceTaintRuleStatusBuilder>{

  DeviceTaintRuleStatusFluent<?> fluent;

  public DeviceTaintRuleStatusBuilder() {
    this(new DeviceTaintRuleStatus());
  }
  
  public DeviceTaintRuleStatusBuilder(DeviceTaintRuleStatusFluent<?> fluent) {
    this(fluent, new DeviceTaintRuleStatus());
  }
  
  public DeviceTaintRuleStatusBuilder(DeviceTaintRuleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTaintRuleStatusBuilder(DeviceTaintRuleStatusFluent<?> fluent,DeviceTaintRuleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceTaintRuleStatus build() {
    DeviceTaintRuleStatus buildable = new DeviceTaintRuleStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}