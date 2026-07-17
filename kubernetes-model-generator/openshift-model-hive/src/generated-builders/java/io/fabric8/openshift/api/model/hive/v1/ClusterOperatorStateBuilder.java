package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOperatorStateBuilder extends ClusterOperatorStateFluent<ClusterOperatorStateBuilder> implements VisitableBuilder<ClusterOperatorState,ClusterOperatorStateBuilder>{

  ClusterOperatorStateFluent<?> fluent;

  public ClusterOperatorStateBuilder() {
    this(new ClusterOperatorState());
  }
  
  public ClusterOperatorStateBuilder(ClusterOperatorStateFluent<?> fluent) {
    this(fluent, new ClusterOperatorState());
  }
  
  public ClusterOperatorStateBuilder(ClusterOperatorState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOperatorStateBuilder(ClusterOperatorStateFluent<?> fluent,ClusterOperatorState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOperatorState build() {
    ClusterOperatorState buildable = new ClusterOperatorState(fluent.getConditions(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}