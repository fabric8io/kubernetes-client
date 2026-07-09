package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespacedPolicyTargetReferenceBuilder extends NamespacedPolicyTargetReferenceFluent<NamespacedPolicyTargetReferenceBuilder> implements VisitableBuilder<NamespacedPolicyTargetReference,NamespacedPolicyTargetReferenceBuilder>{

  NamespacedPolicyTargetReferenceFluent<?> fluent;

  public NamespacedPolicyTargetReferenceBuilder() {
    this(new NamespacedPolicyTargetReference());
  }
  
  public NamespacedPolicyTargetReferenceBuilder(NamespacedPolicyTargetReferenceFluent<?> fluent) {
    this(fluent, new NamespacedPolicyTargetReference());
  }
  
  public NamespacedPolicyTargetReferenceBuilder(NamespacedPolicyTargetReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespacedPolicyTargetReferenceBuilder(NamespacedPolicyTargetReferenceFluent<?> fluent,NamespacedPolicyTargetReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespacedPolicyTargetReference build() {
    NamespacedPolicyTargetReference buildable = new NamespacedPolicyTargetReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}