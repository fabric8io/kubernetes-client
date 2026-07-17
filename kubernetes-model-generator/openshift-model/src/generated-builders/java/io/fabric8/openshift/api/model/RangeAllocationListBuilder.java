package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RangeAllocationListBuilder extends RangeAllocationListFluent<RangeAllocationListBuilder> implements VisitableBuilder<RangeAllocationList,RangeAllocationListBuilder>{

  RangeAllocationListFluent<?> fluent;

  public RangeAllocationListBuilder() {
    this(new RangeAllocationList());
  }
  
  public RangeAllocationListBuilder(RangeAllocationListFluent<?> fluent) {
    this(fluent, new RangeAllocationList());
  }
  
  public RangeAllocationListBuilder(RangeAllocationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RangeAllocationListBuilder(RangeAllocationListFluent<?> fluent,RangeAllocationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RangeAllocationList build() {
    RangeAllocationList buildable = new RangeAllocationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}