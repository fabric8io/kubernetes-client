package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyRootOfTrustBuilder extends PolicyRootOfTrustFluent<PolicyRootOfTrustBuilder> implements VisitableBuilder<PolicyRootOfTrust,PolicyRootOfTrustBuilder>{

  PolicyRootOfTrustFluent<?> fluent;

  public PolicyRootOfTrustBuilder() {
    this(new PolicyRootOfTrust());
  }
  
  public PolicyRootOfTrustBuilder(PolicyRootOfTrustFluent<?> fluent) {
    this(fluent, new PolicyRootOfTrust());
  }
  
  public PolicyRootOfTrustBuilder(PolicyRootOfTrust instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyRootOfTrustBuilder(PolicyRootOfTrustFluent<?> fluent,PolicyRootOfTrust instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyRootOfTrust build() {
    PolicyRootOfTrust buildable = new PolicyRootOfTrust(fluent.buildFulcioCAWithRekor(), fluent.buildPki(), fluent.getPolicyType(), fluent.buildPublicKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}