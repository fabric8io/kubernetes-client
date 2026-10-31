package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositeBasicSchedulingPolicyBuilder extends CompositeBasicSchedulingPolicyFluent<CompositeBasicSchedulingPolicyBuilder> implements VisitableBuilder<CompositeBasicSchedulingPolicy,CompositeBasicSchedulingPolicyBuilder>{

  CompositeBasicSchedulingPolicyFluent<?> fluent;

  public CompositeBasicSchedulingPolicyBuilder() {
    this(new CompositeBasicSchedulingPolicy());
  }
  
  public CompositeBasicSchedulingPolicyBuilder(CompositeBasicSchedulingPolicyFluent<?> fluent) {
    this(fluent, new CompositeBasicSchedulingPolicy());
  }
  
  public CompositeBasicSchedulingPolicyBuilder(CompositeBasicSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositeBasicSchedulingPolicyBuilder(CompositeBasicSchedulingPolicyFluent<?> fluent,CompositeBasicSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositeBasicSchedulingPolicy build() {
    CompositeBasicSchedulingPolicy buildable = new CompositeBasicSchedulingPolicy();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}