package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDomainClaimListBuilder extends ClusterDomainClaimListFluent<ClusterDomainClaimListBuilder> implements VisitableBuilder<ClusterDomainClaimList,ClusterDomainClaimListBuilder>{

  ClusterDomainClaimListFluent<?> fluent;

  public ClusterDomainClaimListBuilder() {
    this(new ClusterDomainClaimList());
  }
  
  public ClusterDomainClaimListBuilder(ClusterDomainClaimListFluent<?> fluent) {
    this(fluent, new ClusterDomainClaimList());
  }
  
  public ClusterDomainClaimListBuilder(ClusterDomainClaimList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDomainClaimListBuilder(ClusterDomainClaimListFluent<?> fluent,ClusterDomainClaimList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDomainClaimList build() {
    ClusterDomainClaimList buildable = new ClusterDomainClaimList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}