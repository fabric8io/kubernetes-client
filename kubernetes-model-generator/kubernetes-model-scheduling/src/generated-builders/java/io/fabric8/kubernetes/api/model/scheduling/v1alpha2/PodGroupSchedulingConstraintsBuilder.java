package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupSchedulingConstraintsBuilder extends PodGroupSchedulingConstraintsFluent<PodGroupSchedulingConstraintsBuilder> implements VisitableBuilder<PodGroupSchedulingConstraints,PodGroupSchedulingConstraintsBuilder>{

  PodGroupSchedulingConstraintsFluent<?> fluent;

  public PodGroupSchedulingConstraintsBuilder() {
    this(new PodGroupSchedulingConstraints());
  }
  
  public PodGroupSchedulingConstraintsBuilder(PodGroupSchedulingConstraintsFluent<?> fluent) {
    this(fluent, new PodGroupSchedulingConstraints());
  }
  
  public PodGroupSchedulingConstraintsBuilder(PodGroupSchedulingConstraints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupSchedulingConstraintsBuilder(PodGroupSchedulingConstraintsFluent<?> fluent,PodGroupSchedulingConstraints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupSchedulingConstraints build() {
    PodGroupSchedulingConstraints buildable = new PodGroupSchedulingConstraints(fluent.buildTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}