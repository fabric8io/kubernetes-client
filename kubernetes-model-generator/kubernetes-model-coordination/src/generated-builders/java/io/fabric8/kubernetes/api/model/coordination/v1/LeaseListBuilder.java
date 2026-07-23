package io.fabric8.kubernetes.api.model.coordination.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaseListBuilder extends LeaseListFluent<LeaseListBuilder> implements VisitableBuilder<LeaseList,LeaseListBuilder>{

  LeaseListFluent<?> fluent;

  public LeaseListBuilder() {
    this(new LeaseList());
  }
  
  public LeaseListBuilder(LeaseListFluent<?> fluent) {
    this(fluent, new LeaseList());
  }
  
  public LeaseListBuilder(LeaseList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaseListBuilder(LeaseListFluent<?> fluent,LeaseList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaseList build() {
    LeaseList buildable = new LeaseList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}