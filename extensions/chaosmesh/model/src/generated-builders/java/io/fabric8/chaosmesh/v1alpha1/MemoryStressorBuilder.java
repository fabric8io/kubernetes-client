package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MemoryStressorBuilder extends MemoryStressorFluent<MemoryStressorBuilder> implements VisitableBuilder<MemoryStressor,MemoryStressorBuilder>{

  MemoryStressorFluent<?> fluent;

  public MemoryStressorBuilder() {
    this(new MemoryStressor());
  }
  
  public MemoryStressorBuilder(MemoryStressorFluent<?> fluent) {
    this(fluent, new MemoryStressor());
  }
  
  public MemoryStressorBuilder(MemoryStressor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MemoryStressorBuilder(MemoryStressorFluent<?> fluent,MemoryStressor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MemoryStressor build() {
    MemoryStressor buildable = new MemoryStressor(fluent.getOomScoreAdj(), fluent.getOptions(), fluent.getSize(), fluent.getWorkers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}