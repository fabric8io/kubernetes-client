package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KResourceBuilder extends KResourceFluent<KResourceBuilder> implements VisitableBuilder<KResource,KResourceBuilder>{

  KResourceFluent<?> fluent;

  public KResourceBuilder() {
    this(new KResource());
  }
  
  public KResourceBuilder(KResourceFluent<?> fluent) {
    this(fluent, new KResource());
  }
  
  public KResourceBuilder(KResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KResourceBuilder(KResourceFluent<?> fluent,KResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KResource build() {
    KResource buildable = new KResource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}