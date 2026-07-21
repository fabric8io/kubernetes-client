package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KResourceListBuilder extends KResourceListFluent<KResourceListBuilder> implements VisitableBuilder<KResourceList,KResourceListBuilder>{

  KResourceListFluent<?> fluent;

  public KResourceListBuilder() {
    this(new KResourceList());
  }
  
  public KResourceListBuilder(KResourceListFluent<?> fluent) {
    this(fluent, new KResourceList());
  }
  
  public KResourceListBuilder(KResourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KResourceListBuilder(KResourceListFluent<?> fluent,KResourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KResourceList build() {
    KResourceList buildable = new KResourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}