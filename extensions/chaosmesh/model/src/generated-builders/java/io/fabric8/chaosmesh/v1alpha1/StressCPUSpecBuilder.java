package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StressCPUSpecBuilder extends StressCPUSpecFluent<StressCPUSpecBuilder> implements VisitableBuilder<StressCPUSpec,StressCPUSpecBuilder>{

  StressCPUSpecFluent<?> fluent;

  public StressCPUSpecBuilder() {
    this(new StressCPUSpec());
  }
  
  public StressCPUSpecBuilder(StressCPUSpecFluent<?> fluent) {
    this(fluent, new StressCPUSpec());
  }
  
  public StressCPUSpecBuilder(StressCPUSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StressCPUSpecBuilder(StressCPUSpecFluent<?> fluent,StressCPUSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StressCPUSpec build() {
    StressCPUSpec buildable = new StressCPUSpec(fluent.getLoad(), fluent.getOptions(), fluent.getWorkers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}