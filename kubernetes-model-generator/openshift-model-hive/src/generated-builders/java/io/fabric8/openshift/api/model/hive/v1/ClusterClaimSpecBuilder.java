package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimSpecBuilder extends ClusterClaimSpecFluent<ClusterClaimSpecBuilder> implements VisitableBuilder<ClusterClaimSpec,ClusterClaimSpecBuilder>{

  ClusterClaimSpecFluent<?> fluent;

  public ClusterClaimSpecBuilder() {
    this(new ClusterClaimSpec());
  }
  
  public ClusterClaimSpecBuilder(ClusterClaimSpecFluent<?> fluent) {
    this(fluent, new ClusterClaimSpec());
  }
  
  public ClusterClaimSpecBuilder(ClusterClaimSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimSpecBuilder(ClusterClaimSpecFluent<?> fluent,ClusterClaimSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaimSpec build() {
    ClusterClaimSpec buildable = new ClusterClaimSpec(fluent.getClusterPoolName(), fluent.getLifetime(), fluent.getNamespace(), fluent.getSubjects());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}