package io.fabric8.kubernetes.api.model.coordination.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaseSpecBuilder extends LeaseSpecFluent<LeaseSpecBuilder> implements VisitableBuilder<LeaseSpec,LeaseSpecBuilder>{

  LeaseSpecFluent<?> fluent;

  public LeaseSpecBuilder() {
    this(new LeaseSpec());
  }
  
  public LeaseSpecBuilder(LeaseSpecFluent<?> fluent) {
    this(fluent, new LeaseSpec());
  }
  
  public LeaseSpecBuilder(LeaseSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaseSpecBuilder(LeaseSpecFluent<?> fluent,LeaseSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaseSpec build() {
    LeaseSpec buildable = new LeaseSpec(fluent.getAcquireTime(), fluent.getHolderIdentity(), fluent.getLeaseDurationSeconds(), fluent.getLeaseTransitions(), fluent.getPreferredHolder(), fluent.getRenewTime(), fluent.getStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}