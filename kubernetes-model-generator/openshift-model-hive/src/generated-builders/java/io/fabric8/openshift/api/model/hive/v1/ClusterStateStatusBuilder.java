package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterStateStatusBuilder extends ClusterStateStatusFluent<ClusterStateStatusBuilder> implements VisitableBuilder<ClusterStateStatus,ClusterStateStatusBuilder>{

  ClusterStateStatusFluent<?> fluent;

  public ClusterStateStatusBuilder() {
    this(new ClusterStateStatus());
  }
  
  public ClusterStateStatusBuilder(ClusterStateStatusFluent<?> fluent) {
    this(fluent, new ClusterStateStatus());
  }
  
  public ClusterStateStatusBuilder(ClusterStateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterStateStatusBuilder(ClusterStateStatusFluent<?> fluent,ClusterStateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterStateStatus build() {
    ClusterStateStatus buildable = new ClusterStateStatus(fluent.buildClusterOperators(), fluent.getLastUpdated());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}