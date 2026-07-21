package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProcessSpecBuilder extends ProcessSpecFluent<ProcessSpecBuilder> implements VisitableBuilder<ProcessSpec,ProcessSpecBuilder>{

  ProcessSpecFluent<?> fluent;

  public ProcessSpecBuilder() {
    this(new ProcessSpec());
  }
  
  public ProcessSpecBuilder(ProcessSpecFluent<?> fluent) {
    this(fluent, new ProcessSpec());
  }
  
  public ProcessSpecBuilder(ProcessSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProcessSpecBuilder(ProcessSpecFluent<?> fluent,ProcessSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProcessSpec build() {
    ProcessSpec buildable = new ProcessSpec(fluent.getProcess(), fluent.getRecoverCmd(), fluent.getSignal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}