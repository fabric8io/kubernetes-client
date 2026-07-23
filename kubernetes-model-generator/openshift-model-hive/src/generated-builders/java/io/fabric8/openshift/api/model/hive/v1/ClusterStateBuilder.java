package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterStateBuilder extends ClusterStateFluent<ClusterStateBuilder> implements VisitableBuilder<ClusterState,ClusterStateBuilder>{

  ClusterStateFluent<?> fluent;

  public ClusterStateBuilder() {
    this(new ClusterState());
  }
  
  public ClusterStateBuilder(ClusterStateFluent<?> fluent) {
    this(fluent, new ClusterState());
  }
  
  public ClusterStateBuilder(ClusterState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterStateBuilder(ClusterStateFluent<?> fluent,ClusterState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterState build() {
    ClusterState buildable = new ClusterState(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}