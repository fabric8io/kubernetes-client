package io.fabric8.autoscaling.api.model.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodUpdatePolicyBuilder extends PodUpdatePolicyFluent<PodUpdatePolicyBuilder> implements VisitableBuilder<PodUpdatePolicy,PodUpdatePolicyBuilder>{

  PodUpdatePolicyFluent<?> fluent;

  public PodUpdatePolicyBuilder() {
    this(new PodUpdatePolicy());
  }
  
  public PodUpdatePolicyBuilder(PodUpdatePolicyFluent<?> fluent) {
    this(fluent, new PodUpdatePolicy());
  }
  
  public PodUpdatePolicyBuilder(PodUpdatePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodUpdatePolicyBuilder(PodUpdatePolicyFluent<?> fluent,PodUpdatePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodUpdatePolicy build() {
    PodUpdatePolicy buildable = new PodUpdatePolicy(fluent.getUpdateMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}