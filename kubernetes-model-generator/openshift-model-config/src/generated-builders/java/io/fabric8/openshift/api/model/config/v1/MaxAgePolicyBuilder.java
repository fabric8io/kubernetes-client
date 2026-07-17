package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MaxAgePolicyBuilder extends MaxAgePolicyFluent<MaxAgePolicyBuilder> implements VisitableBuilder<MaxAgePolicy,MaxAgePolicyBuilder>{

  MaxAgePolicyFluent<?> fluent;

  public MaxAgePolicyBuilder() {
    this(new MaxAgePolicy());
  }
  
  public MaxAgePolicyBuilder(MaxAgePolicyFluent<?> fluent) {
    this(fluent, new MaxAgePolicy());
  }
  
  public MaxAgePolicyBuilder(MaxAgePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MaxAgePolicyBuilder(MaxAgePolicyFluent<?> fluent,MaxAgePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MaxAgePolicy build() {
    MaxAgePolicy buildable = new MaxAgePolicy(fluent.getLargestMaxAge(), fluent.getSmallestMaxAge());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}