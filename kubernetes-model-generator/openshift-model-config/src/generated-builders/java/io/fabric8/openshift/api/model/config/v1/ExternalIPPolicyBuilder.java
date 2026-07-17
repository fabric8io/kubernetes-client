package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalIPPolicyBuilder extends ExternalIPPolicyFluent<ExternalIPPolicyBuilder> implements VisitableBuilder<ExternalIPPolicy,ExternalIPPolicyBuilder>{

  ExternalIPPolicyFluent<?> fluent;

  public ExternalIPPolicyBuilder() {
    this(new ExternalIPPolicy());
  }
  
  public ExternalIPPolicyBuilder(ExternalIPPolicyFluent<?> fluent) {
    this(fluent, new ExternalIPPolicy());
  }
  
  public ExternalIPPolicyBuilder(ExternalIPPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalIPPolicyBuilder(ExternalIPPolicyFluent<?> fluent,ExternalIPPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalIPPolicy build() {
    ExternalIPPolicy buildable = new ExternalIPPolicy(fluent.getAllowedCIDRs(), fluent.getRejectedCIDRs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}