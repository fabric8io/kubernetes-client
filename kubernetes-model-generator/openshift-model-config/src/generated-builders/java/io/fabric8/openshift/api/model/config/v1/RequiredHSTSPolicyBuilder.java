package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequiredHSTSPolicyBuilder extends RequiredHSTSPolicyFluent<RequiredHSTSPolicyBuilder> implements VisitableBuilder<RequiredHSTSPolicy,RequiredHSTSPolicyBuilder>{

  RequiredHSTSPolicyFluent<?> fluent;

  public RequiredHSTSPolicyBuilder() {
    this(new RequiredHSTSPolicy());
  }
  
  public RequiredHSTSPolicyBuilder(RequiredHSTSPolicyFluent<?> fluent) {
    this(fluent, new RequiredHSTSPolicy());
  }
  
  public RequiredHSTSPolicyBuilder(RequiredHSTSPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequiredHSTSPolicyBuilder(RequiredHSTSPolicyFluent<?> fluent,RequiredHSTSPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequiredHSTSPolicy build() {
    RequiredHSTSPolicy buildable = new RequiredHSTSPolicy(fluent.getDomainPatterns(), fluent.getIncludeSubDomainsPolicy(), fluent.buildMaxAge(), fluent.buildNamespaceSelector(), fluent.getPreloadPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}