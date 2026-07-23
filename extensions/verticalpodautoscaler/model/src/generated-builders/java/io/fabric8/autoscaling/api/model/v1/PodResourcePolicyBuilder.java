package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodResourcePolicyBuilder extends PodResourcePolicyFluent<PodResourcePolicyBuilder> implements VisitableBuilder<PodResourcePolicy,PodResourcePolicyBuilder>{

  PodResourcePolicyFluent<?> fluent;

  public PodResourcePolicyBuilder() {
    this(new PodResourcePolicy());
  }
  
  public PodResourcePolicyBuilder(PodResourcePolicyFluent<?> fluent) {
    this(fluent, new PodResourcePolicy());
  }
  
  public PodResourcePolicyBuilder(PodResourcePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodResourcePolicyBuilder(PodResourcePolicyFluent<?> fluent,PodResourcePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodResourcePolicy build() {
    PodResourcePolicy buildable = new PodResourcePolicy(fluent.buildContainerPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}