package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CapacityRequestPolicyBuilder extends CapacityRequestPolicyFluent<CapacityRequestPolicyBuilder> implements VisitableBuilder<CapacityRequestPolicy,CapacityRequestPolicyBuilder>{

  CapacityRequestPolicyFluent<?> fluent;

  public CapacityRequestPolicyBuilder() {
    this(new CapacityRequestPolicy());
  }
  
  public CapacityRequestPolicyBuilder(CapacityRequestPolicyFluent<?> fluent) {
    this(fluent, new CapacityRequestPolicy());
  }
  
  public CapacityRequestPolicyBuilder(CapacityRequestPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CapacityRequestPolicyBuilder(CapacityRequestPolicyFluent<?> fluent,CapacityRequestPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CapacityRequestPolicy build() {
    CapacityRequestPolicy buildable = new CapacityRequestPolicy(fluent.getDefault(), fluent.buildValidRange(), fluent.getValidValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}