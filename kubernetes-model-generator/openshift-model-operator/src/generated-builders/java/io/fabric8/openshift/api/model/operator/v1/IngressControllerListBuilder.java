package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerListBuilder extends IngressControllerListFluent<IngressControllerListBuilder> implements VisitableBuilder<IngressControllerList,IngressControllerListBuilder>{

  IngressControllerListFluent<?> fluent;

  public IngressControllerListBuilder() {
    this(new IngressControllerList());
  }
  
  public IngressControllerListBuilder(IngressControllerListFluent<?> fluent) {
    this(fluent, new IngressControllerList());
  }
  
  public IngressControllerListBuilder(IngressControllerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerListBuilder(IngressControllerListFluent<?> fluent,IngressControllerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerList build() {
    IngressControllerList buildable = new IngressControllerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}