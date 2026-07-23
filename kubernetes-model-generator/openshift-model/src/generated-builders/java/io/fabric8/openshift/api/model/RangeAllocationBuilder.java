package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RangeAllocationBuilder extends RangeAllocationFluent<RangeAllocationBuilder> implements VisitableBuilder<RangeAllocation,RangeAllocationBuilder>{

  RangeAllocationFluent<?> fluent;

  public RangeAllocationBuilder() {
    this(new RangeAllocation());
  }
  
  public RangeAllocationBuilder(RangeAllocationFluent<?> fluent) {
    this(fluent, new RangeAllocation());
  }
  
  public RangeAllocationBuilder(RangeAllocation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RangeAllocationBuilder(RangeAllocationFluent<?> fluent,RangeAllocation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RangeAllocation build() {
    RangeAllocation buildable = new RangeAllocation(fluent.getApiVersion(), fluent.getData(), fluent.getKind(), fluent.buildMetadata(), fluent.getRange());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}