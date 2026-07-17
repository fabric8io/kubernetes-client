package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOperatorSpecBuilder extends ClusterOperatorSpecFluent<ClusterOperatorSpecBuilder> implements VisitableBuilder<ClusterOperatorSpec,ClusterOperatorSpecBuilder>{

  ClusterOperatorSpecFluent<?> fluent;

  public ClusterOperatorSpecBuilder() {
    this(new ClusterOperatorSpec());
  }
  
  public ClusterOperatorSpecBuilder(ClusterOperatorSpecFluent<?> fluent) {
    this(fluent, new ClusterOperatorSpec());
  }
  
  public ClusterOperatorSpecBuilder(ClusterOperatorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOperatorSpecBuilder(ClusterOperatorSpecFluent<?> fluent,ClusterOperatorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOperatorSpec build() {
    ClusterOperatorSpec buildable = new ClusterOperatorSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}