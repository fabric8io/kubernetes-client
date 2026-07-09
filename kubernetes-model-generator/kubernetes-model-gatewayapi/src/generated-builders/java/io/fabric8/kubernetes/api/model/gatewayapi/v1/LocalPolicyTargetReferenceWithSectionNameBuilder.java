package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalPolicyTargetReferenceWithSectionNameBuilder extends LocalPolicyTargetReferenceWithSectionNameFluent<LocalPolicyTargetReferenceWithSectionNameBuilder> implements VisitableBuilder<LocalPolicyTargetReferenceWithSectionName,LocalPolicyTargetReferenceWithSectionNameBuilder>{

  LocalPolicyTargetReferenceWithSectionNameFluent<?> fluent;

  public LocalPolicyTargetReferenceWithSectionNameBuilder() {
    this(new LocalPolicyTargetReferenceWithSectionName());
  }
  
  public LocalPolicyTargetReferenceWithSectionNameBuilder(LocalPolicyTargetReferenceWithSectionNameFluent<?> fluent) {
    this(fluent, new LocalPolicyTargetReferenceWithSectionName());
  }
  
  public LocalPolicyTargetReferenceWithSectionNameBuilder(LocalPolicyTargetReferenceWithSectionName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalPolicyTargetReferenceWithSectionNameBuilder(LocalPolicyTargetReferenceWithSectionNameFluent<?> fluent,LocalPolicyTargetReferenceWithSectionName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalPolicyTargetReferenceWithSectionName build() {
    LocalPolicyTargetReferenceWithSectionName buildable = new LocalPolicyTargetReferenceWithSectionName(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getSectionName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}