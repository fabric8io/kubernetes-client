package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BasicSchedulingPolicyBuilder extends BasicSchedulingPolicyFluent<BasicSchedulingPolicyBuilder> implements VisitableBuilder<BasicSchedulingPolicy,BasicSchedulingPolicyBuilder>{

  BasicSchedulingPolicyFluent<?> fluent;

  public BasicSchedulingPolicyBuilder() {
    this(new BasicSchedulingPolicy());
  }
  
  public BasicSchedulingPolicyBuilder(BasicSchedulingPolicyFluent<?> fluent) {
    this(fluent, new BasicSchedulingPolicy());
  }
  
  public BasicSchedulingPolicyBuilder(BasicSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BasicSchedulingPolicyBuilder(BasicSchedulingPolicyFluent<?> fluent,BasicSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BasicSchedulingPolicy build() {
    BasicSchedulingPolicy buildable = new BasicSchedulingPolicy();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}