package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParentReferenceBuilder extends ParentReferenceFluent<ParentReferenceBuilder> implements VisitableBuilder<ParentReference,ParentReferenceBuilder>{

  ParentReferenceFluent<?> fluent;

  public ParentReferenceBuilder() {
    this(new ParentReference());
  }
  
  public ParentReferenceBuilder(ParentReferenceFluent<?> fluent) {
    this(fluent, new ParentReference());
  }
  
  public ParentReferenceBuilder(ParentReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParentReferenceBuilder(ParentReferenceFluent<?> fluent,ParentReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParentReference build() {
    ParentReference buildable = new ParentReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getPort(), fluent.getSectionName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}