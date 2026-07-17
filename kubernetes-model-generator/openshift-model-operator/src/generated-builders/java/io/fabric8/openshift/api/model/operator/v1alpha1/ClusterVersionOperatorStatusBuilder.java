package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionOperatorStatusBuilder extends ClusterVersionOperatorStatusFluent<ClusterVersionOperatorStatusBuilder> implements VisitableBuilder<ClusterVersionOperatorStatus,ClusterVersionOperatorStatusBuilder>{

  ClusterVersionOperatorStatusFluent<?> fluent;

  public ClusterVersionOperatorStatusBuilder() {
    this(new ClusterVersionOperatorStatus());
  }
  
  public ClusterVersionOperatorStatusBuilder(ClusterVersionOperatorStatusFluent<?> fluent) {
    this(fluent, new ClusterVersionOperatorStatus());
  }
  
  public ClusterVersionOperatorStatusBuilder(ClusterVersionOperatorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionOperatorStatusBuilder(ClusterVersionOperatorStatusFluent<?> fluent,ClusterVersionOperatorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionOperatorStatus build() {
    ClusterVersionOperatorStatus buildable = new ClusterVersionOperatorStatus(fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}