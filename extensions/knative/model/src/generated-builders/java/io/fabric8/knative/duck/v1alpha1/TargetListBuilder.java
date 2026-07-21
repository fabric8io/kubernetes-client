package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TargetListBuilder extends TargetListFluent<TargetListBuilder> implements VisitableBuilder<TargetList,TargetListBuilder>{

  TargetListFluent<?> fluent;

  public TargetListBuilder() {
    this(new TargetList());
  }
  
  public TargetListBuilder(TargetListFluent<?> fluent) {
    this(fluent, new TargetList());
  }
  
  public TargetListBuilder(TargetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TargetListBuilder(TargetListFluent<?> fluent,TargetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TargetList build() {
    TargetList buildable = new TargetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}