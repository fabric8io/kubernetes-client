package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterStateSpecBuilder extends ClusterStateSpecFluent<ClusterStateSpecBuilder> implements VisitableBuilder<ClusterStateSpec,ClusterStateSpecBuilder>{

  ClusterStateSpecFluent<?> fluent;

  public ClusterStateSpecBuilder() {
    this(new ClusterStateSpec());
  }
  
  public ClusterStateSpecBuilder(ClusterStateSpecFluent<?> fluent) {
    this(fluent, new ClusterStateSpec());
  }
  
  public ClusterStateSpecBuilder(ClusterStateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterStateSpecBuilder(ClusterStateSpecFluent<?> fluent,ClusterStateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterStateSpec build() {
    ClusterStateSpec buildable = new ClusterStateSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}