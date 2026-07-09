package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicyBuilder extends PodSecurityPolicyFluent<PodSecurityPolicyBuilder> implements VisitableBuilder<PodSecurityPolicy,PodSecurityPolicyBuilder>{

  PodSecurityPolicyFluent<?> fluent;

  public PodSecurityPolicyBuilder() {
    this(new PodSecurityPolicy());
  }
  
  public PodSecurityPolicyBuilder(PodSecurityPolicyFluent<?> fluent) {
    this(fluent, new PodSecurityPolicy());
  }
  
  public PodSecurityPolicyBuilder(PodSecurityPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicyBuilder(PodSecurityPolicyFluent<?> fluent,PodSecurityPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicy build() {
    PodSecurityPolicy buildable = new PodSecurityPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}