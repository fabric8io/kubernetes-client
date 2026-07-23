package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOperatorStatusBuilder extends ClusterOperatorStatusFluent<ClusterOperatorStatusBuilder> implements VisitableBuilder<ClusterOperatorStatus,ClusterOperatorStatusBuilder>{

  ClusterOperatorStatusFluent<?> fluent;

  public ClusterOperatorStatusBuilder() {
    this(new ClusterOperatorStatus());
  }
  
  public ClusterOperatorStatusBuilder(ClusterOperatorStatusFluent<?> fluent) {
    this(fluent, new ClusterOperatorStatus());
  }
  
  public ClusterOperatorStatusBuilder(ClusterOperatorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOperatorStatusBuilder(ClusterOperatorStatusFluent<?> fluent,ClusterOperatorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOperatorStatus build() {
    ClusterOperatorStatus buildable = new ClusterOperatorStatus(fluent.buildConditions(), fluent.getExtension(), fluent.buildRelatedObjects(), fluent.buildVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}