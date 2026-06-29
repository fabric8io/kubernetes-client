package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SuccessPolicyBuilder extends SuccessPolicyFluent<SuccessPolicyBuilder> implements VisitableBuilder<SuccessPolicy,SuccessPolicyBuilder>{

  SuccessPolicyFluent<?> fluent;

  public SuccessPolicyBuilder() {
    this(new SuccessPolicy());
  }
  
  public SuccessPolicyBuilder(SuccessPolicyFluent<?> fluent) {
    this(fluent, new SuccessPolicy());
  }
  
  public SuccessPolicyBuilder(SuccessPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SuccessPolicyBuilder(SuccessPolicyFluent<?> fluent,SuccessPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SuccessPolicy build() {
    SuccessPolicy buildable = new SuccessPolicy(fluent.buildRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}