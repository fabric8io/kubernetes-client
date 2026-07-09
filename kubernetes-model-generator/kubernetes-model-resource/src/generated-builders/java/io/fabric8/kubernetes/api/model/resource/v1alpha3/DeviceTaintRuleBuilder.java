package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTaintRuleBuilder extends DeviceTaintRuleFluent<DeviceTaintRuleBuilder> implements VisitableBuilder<DeviceTaintRule,DeviceTaintRuleBuilder>{

  DeviceTaintRuleFluent<?> fluent;

  public DeviceTaintRuleBuilder() {
    this(new DeviceTaintRule());
  }
  
  public DeviceTaintRuleBuilder(DeviceTaintRuleFluent<?> fluent) {
    this(fluent, new DeviceTaintRule());
  }
  
  public DeviceTaintRuleBuilder(DeviceTaintRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTaintRuleBuilder(DeviceTaintRuleFluent<?> fluent,DeviceTaintRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceTaintRule build() {
    DeviceTaintRule buildable = new DeviceTaintRule(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}