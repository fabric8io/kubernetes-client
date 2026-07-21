package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CPUStressorBuilder extends CPUStressorFluent<CPUStressorBuilder> implements VisitableBuilder<CPUStressor,CPUStressorBuilder>{

  CPUStressorFluent<?> fluent;

  public CPUStressorBuilder() {
    this(new CPUStressor());
  }
  
  public CPUStressorBuilder(CPUStressorFluent<?> fluent) {
    this(fluent, new CPUStressor());
  }
  
  public CPUStressorBuilder(CPUStressor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CPUStressorBuilder(CPUStressorFluent<?> fluent,CPUStressor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CPUStressor build() {
    CPUStressor buildable = new CPUStressor(fluent.getLoad(), fluent.getOptions(), fluent.getWorkers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}