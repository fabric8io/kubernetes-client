package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimBuilder extends ClusterClaimFluent<ClusterClaimBuilder> implements VisitableBuilder<ClusterClaim,ClusterClaimBuilder>{

  ClusterClaimFluent<?> fluent;

  public ClusterClaimBuilder() {
    this(new ClusterClaim());
  }
  
  public ClusterClaimBuilder(ClusterClaimFluent<?> fluent) {
    this(fluent, new ClusterClaim());
  }
  
  public ClusterClaimBuilder(ClusterClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimBuilder(ClusterClaimFluent<?> fluent,ClusterClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaim build() {
    ClusterClaim buildable = new ClusterClaim(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}