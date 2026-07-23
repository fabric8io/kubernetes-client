package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupSchedulingPolicyBuilder extends PodGroupSchedulingPolicyFluent<PodGroupSchedulingPolicyBuilder> implements VisitableBuilder<PodGroupSchedulingPolicy,PodGroupSchedulingPolicyBuilder>{

  PodGroupSchedulingPolicyFluent<?> fluent;

  public PodGroupSchedulingPolicyBuilder() {
    this(new PodGroupSchedulingPolicy());
  }
  
  public PodGroupSchedulingPolicyBuilder(PodGroupSchedulingPolicyFluent<?> fluent) {
    this(fluent, new PodGroupSchedulingPolicy());
  }
  
  public PodGroupSchedulingPolicyBuilder(PodGroupSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupSchedulingPolicyBuilder(PodGroupSchedulingPolicyFluent<?> fluent,PodGroupSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupSchedulingPolicy build() {
    PodGroupSchedulingPolicy buildable = new PodGroupSchedulingPolicy(fluent.buildBasic(), fluent.buildGang());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}