package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupSpecBuilder extends CompositePodGroupSpecFluent<CompositePodGroupSpecBuilder> implements VisitableBuilder<CompositePodGroupSpec,CompositePodGroupSpecBuilder>{

  CompositePodGroupSpecFluent<?> fluent;

  public CompositePodGroupSpecBuilder() {
    this(new CompositePodGroupSpec());
  }
  
  public CompositePodGroupSpecBuilder(CompositePodGroupSpecFluent<?> fluent) {
    this(fluent, new CompositePodGroupSpec());
  }
  
  public CompositePodGroupSpecBuilder(CompositePodGroupSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupSpecBuilder(CompositePodGroupSpecFluent<?> fluent,CompositePodGroupSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroupSpec build() {
    CompositePodGroupSpec buildable = new CompositePodGroupSpec(fluent.buildDisruptionMode(), fluent.getParentCompositePodGroupName(), fluent.getPreemptionPolicy(), fluent.getPriority(), fluent.getPriorityClassName(), fluent.buildSchedulingConstraints(), fluent.buildSchedulingPolicy(), fluent.buildWorkloadRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}