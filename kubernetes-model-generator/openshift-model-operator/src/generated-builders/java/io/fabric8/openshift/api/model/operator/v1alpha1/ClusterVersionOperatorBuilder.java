package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionOperatorBuilder extends ClusterVersionOperatorFluent<ClusterVersionOperatorBuilder> implements VisitableBuilder<ClusterVersionOperator,ClusterVersionOperatorBuilder>{

  ClusterVersionOperatorFluent<?> fluent;

  public ClusterVersionOperatorBuilder() {
    this(new ClusterVersionOperator());
  }
  
  public ClusterVersionOperatorBuilder(ClusterVersionOperatorFluent<?> fluent) {
    this(fluent, new ClusterVersionOperator());
  }
  
  public ClusterVersionOperatorBuilder(ClusterVersionOperator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionOperatorBuilder(ClusterVersionOperatorFluent<?> fluent,ClusterVersionOperator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionOperator build() {
    ClusterVersionOperator buildable = new ClusterVersionOperator(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}