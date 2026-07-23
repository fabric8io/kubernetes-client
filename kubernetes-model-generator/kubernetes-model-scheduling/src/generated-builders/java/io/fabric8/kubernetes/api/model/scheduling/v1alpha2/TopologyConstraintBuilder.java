package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologyConstraintBuilder extends TopologyConstraintFluent<TopologyConstraintBuilder> implements VisitableBuilder<TopologyConstraint,TopologyConstraintBuilder>{

  TopologyConstraintFluent<?> fluent;

  public TopologyConstraintBuilder() {
    this(new TopologyConstraint());
  }
  
  public TopologyConstraintBuilder(TopologyConstraintFluent<?> fluent) {
    this(fluent, new TopologyConstraint());
  }
  
  public TopologyConstraintBuilder(TopologyConstraint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologyConstraintBuilder(TopologyConstraintFluent<?> fluent,TopologyConstraint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TopologyConstraint build() {
    TopologyConstraint buildable = new TopologyConstraint(fluent.getKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}