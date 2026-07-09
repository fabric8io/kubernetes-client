package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityClassListBuilder extends PriorityClassListFluent<PriorityClassListBuilder> implements VisitableBuilder<PriorityClassList,PriorityClassListBuilder>{

  PriorityClassListFluent<?> fluent;

  public PriorityClassListBuilder() {
    this(new PriorityClassList());
  }
  
  public PriorityClassListBuilder(PriorityClassListFluent<?> fluent) {
    this(fluent, new PriorityClassList());
  }
  
  public PriorityClassListBuilder(PriorityClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityClassListBuilder(PriorityClassListFluent<?> fluent,PriorityClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityClassList build() {
    PriorityClassList buildable = new PriorityClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}