package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerificationPolicySpecBuilder extends VerificationPolicySpecFluent<VerificationPolicySpecBuilder> implements VisitableBuilder<VerificationPolicySpec,VerificationPolicySpecBuilder>{

  VerificationPolicySpecFluent<?> fluent;

  public VerificationPolicySpecBuilder() {
    this(new VerificationPolicySpec());
  }
  
  public VerificationPolicySpecBuilder(VerificationPolicySpecFluent<?> fluent) {
    this(fluent, new VerificationPolicySpec());
  }
  
  public VerificationPolicySpecBuilder(VerificationPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerificationPolicySpecBuilder(VerificationPolicySpecFluent<?> fluent,VerificationPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerificationPolicySpec build() {
    VerificationPolicySpec buildable = new VerificationPolicySpec(fluent.buildAuthorities(), fluent.getMode(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}