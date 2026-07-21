package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterManagerBuilder extends ClusterManagerFluent<ClusterManagerBuilder> implements VisitableBuilder<ClusterManager,ClusterManagerBuilder>{

  ClusterManagerFluent<?> fluent;

  public ClusterManagerBuilder() {
    this(new ClusterManager());
  }
  
  public ClusterManagerBuilder(ClusterManagerFluent<?> fluent) {
    this(fluent, new ClusterManager());
  }
  
  public ClusterManagerBuilder(ClusterManager instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterManagerBuilder(ClusterManagerFluent<?> fluent,ClusterManager instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterManager build() {
    ClusterManager buildable = new ClusterManager(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}