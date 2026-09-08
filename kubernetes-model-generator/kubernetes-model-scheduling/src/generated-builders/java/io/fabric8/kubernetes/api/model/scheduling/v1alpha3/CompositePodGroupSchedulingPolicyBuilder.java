package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupSchedulingPolicyBuilder extends CompositePodGroupSchedulingPolicyFluent<CompositePodGroupSchedulingPolicyBuilder> implements VisitableBuilder<CompositePodGroupSchedulingPolicy,CompositePodGroupSchedulingPolicyBuilder>{

  CompositePodGroupSchedulingPolicyFluent<?> fluent;

  public CompositePodGroupSchedulingPolicyBuilder() {
    this(new CompositePodGroupSchedulingPolicy());
  }
  
  public CompositePodGroupSchedulingPolicyBuilder(CompositePodGroupSchedulingPolicyFluent<?> fluent) {
    this(fluent, new CompositePodGroupSchedulingPolicy());
  }
  
  public CompositePodGroupSchedulingPolicyBuilder(CompositePodGroupSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupSchedulingPolicyBuilder(CompositePodGroupSchedulingPolicyFluent<?> fluent,CompositePodGroupSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroupSchedulingPolicy build() {
    CompositePodGroupSchedulingPolicy buildable = new CompositePodGroupSchedulingPolicy(fluent.buildBasic(), fluent.buildGang());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}