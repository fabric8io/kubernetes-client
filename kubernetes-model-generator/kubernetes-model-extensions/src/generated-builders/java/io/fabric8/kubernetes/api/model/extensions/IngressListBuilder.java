package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressListBuilder extends IngressListFluent<IngressListBuilder> implements VisitableBuilder<IngressList,IngressListBuilder>{

  IngressListFluent<?> fluent;

  public IngressListBuilder() {
    this(new IngressList());
  }
  
  public IngressListBuilder(IngressListFluent<?> fluent) {
    this(fluent, new IngressList());
  }
  
  public IngressListBuilder(IngressList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressListBuilder(IngressListFluent<?> fluent,IngressList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressList build() {
    IngressList buildable = new IngressList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}