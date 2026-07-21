package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VerificationPolicyListBuilder extends VerificationPolicyListFluent<VerificationPolicyListBuilder> implements VisitableBuilder<VerificationPolicyList,VerificationPolicyListBuilder>{

  VerificationPolicyListFluent<?> fluent;

  public VerificationPolicyListBuilder() {
    this(new VerificationPolicyList());
  }
  
  public VerificationPolicyListBuilder(VerificationPolicyListFluent<?> fluent) {
    this(fluent, new VerificationPolicyList());
  }
  
  public VerificationPolicyListBuilder(VerificationPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VerificationPolicyListBuilder(VerificationPolicyListFluent<?> fluent,VerificationPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VerificationPolicyList build() {
    VerificationPolicyList buildable = new VerificationPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}