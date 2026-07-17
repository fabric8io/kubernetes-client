package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOperatorBuilder extends ClusterOperatorFluent<ClusterOperatorBuilder> implements VisitableBuilder<ClusterOperator,ClusterOperatorBuilder>{

  ClusterOperatorFluent<?> fluent;

  public ClusterOperatorBuilder() {
    this(new ClusterOperator());
  }
  
  public ClusterOperatorBuilder(ClusterOperatorFluent<?> fluent) {
    this(fluent, new ClusterOperator());
  }
  
  public ClusterOperatorBuilder(ClusterOperator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOperatorBuilder(ClusterOperatorFluent<?> fluent,ClusterOperator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOperator build() {
    ClusterOperator buildable = new ClusterOperator(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}