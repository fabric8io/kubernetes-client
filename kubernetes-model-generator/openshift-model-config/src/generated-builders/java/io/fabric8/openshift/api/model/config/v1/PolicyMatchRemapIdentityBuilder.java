package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyMatchRemapIdentityBuilder extends PolicyMatchRemapIdentityFluent<PolicyMatchRemapIdentityBuilder> implements VisitableBuilder<PolicyMatchRemapIdentity,PolicyMatchRemapIdentityBuilder>{

  PolicyMatchRemapIdentityFluent<?> fluent;

  public PolicyMatchRemapIdentityBuilder() {
    this(new PolicyMatchRemapIdentity());
  }
  
  public PolicyMatchRemapIdentityBuilder(PolicyMatchRemapIdentityFluent<?> fluent) {
    this(fluent, new PolicyMatchRemapIdentity());
  }
  
  public PolicyMatchRemapIdentityBuilder(PolicyMatchRemapIdentity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyMatchRemapIdentityBuilder(PolicyMatchRemapIdentityFluent<?> fluent,PolicyMatchRemapIdentity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyMatchRemapIdentity build() {
    PolicyMatchRemapIdentity buildable = new PolicyMatchRemapIdentity(fluent.getPrefix(), fluent.getSignedPrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}