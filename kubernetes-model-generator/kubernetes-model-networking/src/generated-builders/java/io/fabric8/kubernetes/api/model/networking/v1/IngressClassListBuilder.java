package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressClassListBuilder extends IngressClassListFluent<IngressClassListBuilder> implements VisitableBuilder<IngressClassList,IngressClassListBuilder>{

  IngressClassListFluent<?> fluent;

  public IngressClassListBuilder() {
    this(new IngressClassList());
  }
  
  public IngressClassListBuilder(IngressClassListFluent<?> fluent) {
    this(fluent, new IngressClassList());
  }
  
  public IngressClassListBuilder(IngressClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressClassListBuilder(IngressClassListFluent<?> fluent,IngressClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressClassList build() {
    IngressClassList buildable = new IngressClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}