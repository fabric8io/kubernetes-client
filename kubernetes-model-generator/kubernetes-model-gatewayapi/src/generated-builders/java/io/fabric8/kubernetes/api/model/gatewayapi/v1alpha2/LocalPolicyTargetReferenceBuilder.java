package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalPolicyTargetReferenceBuilder extends LocalPolicyTargetReferenceFluent<LocalPolicyTargetReferenceBuilder> implements VisitableBuilder<LocalPolicyTargetReference,LocalPolicyTargetReferenceBuilder>{

  LocalPolicyTargetReferenceFluent<?> fluent;

  public LocalPolicyTargetReferenceBuilder() {
    this(new LocalPolicyTargetReference());
  }
  
  public LocalPolicyTargetReferenceBuilder(LocalPolicyTargetReferenceFluent<?> fluent) {
    this(fluent, new LocalPolicyTargetReference());
  }
  
  public LocalPolicyTargetReferenceBuilder(LocalPolicyTargetReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalPolicyTargetReferenceBuilder(LocalPolicyTargetReferenceFluent<?> fluent,LocalPolicyTargetReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalPolicyTargetReference build() {
    LocalPolicyTargetReference buildable = new LocalPolicyTargetReference(fluent.getGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}