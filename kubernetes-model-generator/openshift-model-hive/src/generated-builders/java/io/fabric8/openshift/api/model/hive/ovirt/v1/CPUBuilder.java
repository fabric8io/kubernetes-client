package io.fabric8.openshift.api.model.hive.ovirt.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CPUBuilder extends CPUFluent<CPUBuilder> implements VisitableBuilder<CPU,CPUBuilder>{

  CPUFluent<?> fluent;

  public CPUBuilder() {
    this(new CPU());
  }
  
  public CPUBuilder(CPUFluent<?> fluent) {
    this(fluent, new CPU());
  }
  
  public CPUBuilder(CPU instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CPUBuilder(CPUFluent<?> fluent,CPU instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CPU build() {
    CPU buildable = new CPU(fluent.getCores(), fluent.getSockets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}