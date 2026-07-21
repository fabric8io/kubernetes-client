package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VMSpecBuilder extends VMSpecFluent<VMSpecBuilder> implements VisitableBuilder<VMSpec,VMSpecBuilder>{

  VMSpecFluent<?> fluent;

  public VMSpecBuilder() {
    this(new VMSpec());
  }
  
  public VMSpecBuilder(VMSpecFluent<?> fluent) {
    this(fluent, new VMSpec());
  }
  
  public VMSpecBuilder(VMSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VMSpecBuilder(VMSpecFluent<?> fluent,VMSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VMSpec build() {
    VMSpec buildable = new VMSpec(fluent.getVmName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}