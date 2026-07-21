package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KReferenceBuilder extends KReferenceFluent<KReferenceBuilder> implements VisitableBuilder<KReference,KReferenceBuilder>{

  KReferenceFluent<?> fluent;

  public KReferenceBuilder() {
    this(new KReference());
  }
  
  public KReferenceBuilder(KReferenceFluent<?> fluent) {
    this(fluent, new KReference());
  }
  
  public KReferenceBuilder(KReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KReferenceBuilder(KReferenceFluent<?> fluent,KReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KReference build() {
    KReference buildable = new KReference(fluent.getAddress(), fluent.getApiVersion(), fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}