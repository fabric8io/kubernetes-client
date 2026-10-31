package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DynamicHostAllocationSpecBuilder extends DynamicHostAllocationSpecFluent<DynamicHostAllocationSpecBuilder> implements VisitableBuilder<DynamicHostAllocationSpec,DynamicHostAllocationSpecBuilder>{

  DynamicHostAllocationSpecFluent<?> fluent;

  public DynamicHostAllocationSpecBuilder() {
    this(new DynamicHostAllocationSpec());
  }
  
  public DynamicHostAllocationSpecBuilder(DynamicHostAllocationSpecFluent<?> fluent) {
    this(fluent, new DynamicHostAllocationSpec());
  }
  
  public DynamicHostAllocationSpecBuilder(DynamicHostAllocationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DynamicHostAllocationSpecBuilder(DynamicHostAllocationSpecFluent<?> fluent,DynamicHostAllocationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DynamicHostAllocationSpec build() {
    DynamicHostAllocationSpec buildable = new DynamicHostAllocationSpec(fluent.buildTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}