package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionOperatorSpecBuilder extends ClusterVersionOperatorSpecFluent<ClusterVersionOperatorSpecBuilder> implements VisitableBuilder<ClusterVersionOperatorSpec,ClusterVersionOperatorSpecBuilder>{

  ClusterVersionOperatorSpecFluent<?> fluent;

  public ClusterVersionOperatorSpecBuilder() {
    this(new ClusterVersionOperatorSpec());
  }
  
  public ClusterVersionOperatorSpecBuilder(ClusterVersionOperatorSpecFluent<?> fluent) {
    this(fluent, new ClusterVersionOperatorSpec());
  }
  
  public ClusterVersionOperatorSpecBuilder(ClusterVersionOperatorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionOperatorSpecBuilder(ClusterVersionOperatorSpecFluent<?> fluent,ClusterVersionOperatorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionOperatorSpec build() {
    ClusterVersionOperatorSpec buildable = new ClusterVersionOperatorSpec(fluent.getOperatorLogLevel());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}