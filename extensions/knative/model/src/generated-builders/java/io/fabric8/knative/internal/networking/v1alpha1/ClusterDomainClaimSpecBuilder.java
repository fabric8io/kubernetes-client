package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDomainClaimSpecBuilder extends ClusterDomainClaimSpecFluent<ClusterDomainClaimSpecBuilder> implements VisitableBuilder<ClusterDomainClaimSpec,ClusterDomainClaimSpecBuilder>{

  ClusterDomainClaimSpecFluent<?> fluent;

  public ClusterDomainClaimSpecBuilder() {
    this(new ClusterDomainClaimSpec());
  }
  
  public ClusterDomainClaimSpecBuilder(ClusterDomainClaimSpecFluent<?> fluent) {
    this(fluent, new ClusterDomainClaimSpec());
  }
  
  public ClusterDomainClaimSpecBuilder(ClusterDomainClaimSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDomainClaimSpecBuilder(ClusterDomainClaimSpecFluent<?> fluent,ClusterDomainClaimSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDomainClaimSpec build() {
    ClusterDomainClaimSpec buildable = new ClusterDomainClaimSpec(fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}