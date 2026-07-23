package io.fabric8.kubernetes.api.model.coordination.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaseBuilder extends LeaseFluent<LeaseBuilder> implements VisitableBuilder<Lease,LeaseBuilder>{

  LeaseFluent<?> fluent;

  public LeaseBuilder() {
    this(new Lease());
  }
  
  public LeaseBuilder(LeaseFluent<?> fluent) {
    this(fluent, new Lease());
  }
  
  public LeaseBuilder(Lease instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaseBuilder(LeaseFluent<?> fluent,Lease instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Lease build() {
    Lease buildable = new Lease(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}