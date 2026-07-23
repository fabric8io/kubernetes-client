package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDomainClaimBuilder extends ClusterDomainClaimFluent<ClusterDomainClaimBuilder> implements VisitableBuilder<ClusterDomainClaim,ClusterDomainClaimBuilder>{

  ClusterDomainClaimFluent<?> fluent;

  public ClusterDomainClaimBuilder() {
    this(new ClusterDomainClaim());
  }
  
  public ClusterDomainClaimBuilder(ClusterDomainClaimFluent<?> fluent) {
    this(fluent, new ClusterDomainClaim());
  }
  
  public ClusterDomainClaimBuilder(ClusterDomainClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDomainClaimBuilder(ClusterDomainClaimFluent<?> fluent,ClusterDomainClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDomainClaim build() {
    ClusterDomainClaim buildable = new ClusterDomainClaim(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}