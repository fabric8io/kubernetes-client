package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HPAScalingPolicyBuilder extends HPAScalingPolicyFluent<HPAScalingPolicyBuilder> implements VisitableBuilder<HPAScalingPolicy,HPAScalingPolicyBuilder>{

  HPAScalingPolicyFluent<?> fluent;

  public HPAScalingPolicyBuilder() {
    this(new HPAScalingPolicy());
  }
  
  public HPAScalingPolicyBuilder(HPAScalingPolicyFluent<?> fluent) {
    this(fluent, new HPAScalingPolicy());
  }
  
  public HPAScalingPolicyBuilder(HPAScalingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HPAScalingPolicyBuilder(HPAScalingPolicyFluent<?> fluent,HPAScalingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HPAScalingPolicy build() {
    HPAScalingPolicy buildable = new HPAScalingPolicy(fluent.getPeriodSeconds(), fluent.getType(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}