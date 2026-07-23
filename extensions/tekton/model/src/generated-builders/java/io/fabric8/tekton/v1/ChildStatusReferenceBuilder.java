package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChildStatusReferenceBuilder extends ChildStatusReferenceFluent<ChildStatusReferenceBuilder> implements VisitableBuilder<ChildStatusReference,ChildStatusReferenceBuilder>{

  ChildStatusReferenceFluent<?> fluent;

  public ChildStatusReferenceBuilder() {
    this(new ChildStatusReference());
  }
  
  public ChildStatusReferenceBuilder(ChildStatusReferenceFluent<?> fluent) {
    this(fluent, new ChildStatusReference());
  }
  
  public ChildStatusReferenceBuilder(ChildStatusReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChildStatusReferenceBuilder(ChildStatusReferenceFluent<?> fluent,ChildStatusReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChildStatusReference build() {
    ChildStatusReference buildable = new ChildStatusReference(fluent.getApiVersion(), fluent.getDisplayName(), fluent.getKind(), fluent.getName(), fluent.getPipelineTaskName(), fluent.buildWhenExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}