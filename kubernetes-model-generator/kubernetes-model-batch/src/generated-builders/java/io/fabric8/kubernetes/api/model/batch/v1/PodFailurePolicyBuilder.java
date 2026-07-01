package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodFailurePolicyBuilder extends PodFailurePolicyFluent<PodFailurePolicyBuilder> implements VisitableBuilder<PodFailurePolicy,PodFailurePolicyBuilder>{

  PodFailurePolicyFluent<?> fluent;

  public PodFailurePolicyBuilder() {
    this(new PodFailurePolicy());
  }
  
  public PodFailurePolicyBuilder(PodFailurePolicyFluent<?> fluent) {
    this(fluent, new PodFailurePolicy());
  }
  
  public PodFailurePolicyBuilder(PodFailurePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodFailurePolicyBuilder(PodFailurePolicyFluent<?> fluent,PodFailurePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodFailurePolicy build() {
    PodFailurePolicy buildable = new PodFailurePolicy(fluent.buildRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}