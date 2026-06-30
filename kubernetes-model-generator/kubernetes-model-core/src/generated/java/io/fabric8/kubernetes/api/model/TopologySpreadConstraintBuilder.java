package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologySpreadConstraintBuilder extends TopologySpreadConstraintFluent<TopologySpreadConstraintBuilder> implements VisitableBuilder<TopologySpreadConstraint,TopologySpreadConstraintBuilder>{

  TopologySpreadConstraintFluent<?> fluent;

  public TopologySpreadConstraintBuilder() {
    this(new TopologySpreadConstraint());
  }
  
  public TopologySpreadConstraintBuilder(TopologySpreadConstraintFluent<?> fluent) {
    this(fluent, new TopologySpreadConstraint());
  }
  
  public TopologySpreadConstraintBuilder(TopologySpreadConstraint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologySpreadConstraintBuilder(TopologySpreadConstraintFluent<?> fluent,TopologySpreadConstraint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TopologySpreadConstraint build() {
    TopologySpreadConstraint buildable = new TopologySpreadConstraint(fluent.buildLabelSelector(), fluent.getMatchLabelKeys(), fluent.getMaxSkew(), fluent.getMinDomains(), fluent.getNodeAffinityPolicy(), fluent.getNodeTaintsPolicy(), fluent.getTopologyKey(), fluent.getWhenUnsatisfiable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}