package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerificationPolicyBuilder extends VerificationPolicyFluent<VerificationPolicyBuilder> implements VisitableBuilder<VerificationPolicy,VerificationPolicyBuilder>{

  VerificationPolicyFluent<?> fluent;

  public VerificationPolicyBuilder() {
    this(new VerificationPolicy());
  }
  
  public VerificationPolicyBuilder(VerificationPolicyFluent<?> fluent) {
    this(fluent, new VerificationPolicy());
  }
  
  public VerificationPolicyBuilder(VerificationPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerificationPolicyBuilder(VerificationPolicyFluent<?> fluent,VerificationPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerificationPolicy build() {
    VerificationPolicy buildable = new VerificationPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}