package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HPAScalingRulesBuilder extends HPAScalingRulesFluent<HPAScalingRulesBuilder> implements VisitableBuilder<HPAScalingRules,HPAScalingRulesBuilder>{

  HPAScalingRulesFluent<?> fluent;

  public HPAScalingRulesBuilder() {
    this(new HPAScalingRules());
  }
  
  public HPAScalingRulesBuilder(HPAScalingRulesFluent<?> fluent) {
    this(fluent, new HPAScalingRules());
  }
  
  public HPAScalingRulesBuilder(HPAScalingRules instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HPAScalingRulesBuilder(HPAScalingRulesFluent<?> fluent,HPAScalingRules instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HPAScalingRules build() {
    HPAScalingRules buildable = new HPAScalingRules(fluent.buildPolicies(), fluent.getSelectPolicy(), fluent.getStabilizationWindowSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}