package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressMemorySpecBuilder extends StressMemorySpecFluent<StressMemorySpecBuilder> implements VisitableBuilder<StressMemorySpec,StressMemorySpecBuilder>{

  StressMemorySpecFluent<?> fluent;

  public StressMemorySpecBuilder() {
    this(new StressMemorySpec());
  }
  
  public StressMemorySpecBuilder(StressMemorySpecFluent<?> fluent) {
    this(fluent, new StressMemorySpec());
  }
  
  public StressMemorySpecBuilder(StressMemorySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressMemorySpecBuilder(StressMemorySpecFluent<?> fluent,StressMemorySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressMemorySpec build() {
    StressMemorySpec buildable = new StressMemorySpec(fluent.getOptions(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}