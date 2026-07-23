package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeprovisionSpecBuilder extends ClusterDeprovisionSpecFluent<ClusterDeprovisionSpecBuilder> implements VisitableBuilder<ClusterDeprovisionSpec,ClusterDeprovisionSpecBuilder>{

  ClusterDeprovisionSpecFluent<?> fluent;

  public ClusterDeprovisionSpecBuilder() {
    this(new ClusterDeprovisionSpec());
  }
  
  public ClusterDeprovisionSpecBuilder(ClusterDeprovisionSpecFluent<?> fluent) {
    this(fluent, new ClusterDeprovisionSpec());
  }
  
  public ClusterDeprovisionSpecBuilder(ClusterDeprovisionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeprovisionSpecBuilder(ClusterDeprovisionSpecFluent<?> fluent,ClusterDeprovisionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeprovisionSpec build() {
    ClusterDeprovisionSpec buildable = new ClusterDeprovisionSpec(fluent.getBaseDomain(), fluent.getClusterID(), fluent.getClusterName(), fluent.getInfraID(), fluent.buildPlatform());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}