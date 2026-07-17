package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RichReferenceBuilder extends RichReferenceFluent<RichReferenceBuilder> implements VisitableBuilder<RichReference,RichReferenceBuilder>{

  RichReferenceFluent<?> fluent;

  public RichReferenceBuilder() {
    this(new RichReference());
  }
  
  public RichReferenceBuilder(RichReferenceFluent<?> fluent) {
    this(fluent, new RichReference());
  }
  
  public RichReferenceBuilder(RichReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RichReferenceBuilder(RichReferenceFluent<?> fluent,RichReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RichReference build() {
    RichReference buildable = new RichReference(fluent.getApiVersion(), fluent.buildConditions(), fluent.getFieldPath(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getResourceVersion(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}