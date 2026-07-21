package io.fabric8.istio.api.api.type.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyTargetReferenceBuilder extends PolicyTargetReferenceFluent<PolicyTargetReferenceBuilder> implements VisitableBuilder<PolicyTargetReference,PolicyTargetReferenceBuilder>{

  PolicyTargetReferenceFluent<?> fluent;

  public PolicyTargetReferenceBuilder() {
    this(new PolicyTargetReference());
  }
  
  public PolicyTargetReferenceBuilder(PolicyTargetReferenceFluent<?> fluent) {
    this(fluent, new PolicyTargetReference());
  }
  
  public PolicyTargetReferenceBuilder(PolicyTargetReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyTargetReferenceBuilder(PolicyTargetReferenceFluent<?> fluent,PolicyTargetReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyTargetReference build() {
    PolicyTargetReference buildable = new PolicyTargetReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}