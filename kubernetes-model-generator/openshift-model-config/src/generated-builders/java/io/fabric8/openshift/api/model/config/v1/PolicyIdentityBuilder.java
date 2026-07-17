package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyIdentityBuilder extends PolicyIdentityFluent<PolicyIdentityBuilder> implements VisitableBuilder<PolicyIdentity,PolicyIdentityBuilder>{

  PolicyIdentityFluent<?> fluent;

  public PolicyIdentityBuilder() {
    this(new PolicyIdentity());
  }
  
  public PolicyIdentityBuilder(PolicyIdentityFluent<?> fluent) {
    this(fluent, new PolicyIdentity());
  }
  
  public PolicyIdentityBuilder(PolicyIdentity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyIdentityBuilder(PolicyIdentityFluent<?> fluent,PolicyIdentity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyIdentity build() {
    PolicyIdentity buildable = new PolicyIdentity(fluent.buildExactRepository(), fluent.getMatchPolicy(), fluent.buildRemapIdentity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}