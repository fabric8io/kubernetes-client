package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupSchedulingConstraintsBuilder extends CompositePodGroupSchedulingConstraintsFluent<CompositePodGroupSchedulingConstraintsBuilder> implements VisitableBuilder<CompositePodGroupSchedulingConstraints,CompositePodGroupSchedulingConstraintsBuilder>{

  CompositePodGroupSchedulingConstraintsFluent<?> fluent;

  public CompositePodGroupSchedulingConstraintsBuilder() {
    this(new CompositePodGroupSchedulingConstraints());
  }
  
  public CompositePodGroupSchedulingConstraintsBuilder(CompositePodGroupSchedulingConstraintsFluent<?> fluent) {
    this(fluent, new CompositePodGroupSchedulingConstraints());
  }
  
  public CompositePodGroupSchedulingConstraintsBuilder(CompositePodGroupSchedulingConstraints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupSchedulingConstraintsBuilder(CompositePodGroupSchedulingConstraintsFluent<?> fluent,CompositePodGroupSchedulingConstraints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroupSchedulingConstraints build() {
    CompositePodGroupSchedulingConstraints buildable = new CompositePodGroupSchedulingConstraints(fluent.buildTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}