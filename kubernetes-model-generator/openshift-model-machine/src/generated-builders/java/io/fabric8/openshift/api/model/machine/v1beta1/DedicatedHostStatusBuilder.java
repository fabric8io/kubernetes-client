package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DedicatedHostStatusBuilder extends DedicatedHostStatusFluent<DedicatedHostStatusBuilder> implements VisitableBuilder<DedicatedHostStatus,DedicatedHostStatusBuilder>{

  DedicatedHostStatusFluent<?> fluent;

  public DedicatedHostStatusBuilder() {
    this(new DedicatedHostStatus());
  }
  
  public DedicatedHostStatusBuilder(DedicatedHostStatusFluent<?> fluent) {
    this(fluent, new DedicatedHostStatus());
  }
  
  public DedicatedHostStatusBuilder(DedicatedHostStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DedicatedHostStatusBuilder(DedicatedHostStatusFluent<?> fluent,DedicatedHostStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DedicatedHostStatus build() {
    DedicatedHostStatus buildable = new DedicatedHostStatus(fluent.getId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}