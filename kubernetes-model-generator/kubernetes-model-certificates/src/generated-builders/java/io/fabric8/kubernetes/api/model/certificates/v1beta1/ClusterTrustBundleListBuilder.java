package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTrustBundleListBuilder extends ClusterTrustBundleListFluent<ClusterTrustBundleListBuilder> implements VisitableBuilder<ClusterTrustBundleList,ClusterTrustBundleListBuilder>{

  ClusterTrustBundleListFluent<?> fluent;

  public ClusterTrustBundleListBuilder() {
    this(new ClusterTrustBundleList());
  }
  
  public ClusterTrustBundleListBuilder(ClusterTrustBundleListFluent<?> fluent) {
    this(fluent, new ClusterTrustBundleList());
  }
  
  public ClusterTrustBundleListBuilder(ClusterTrustBundleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTrustBundleListBuilder(ClusterTrustBundleListFluent<?> fluent,ClusterTrustBundleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTrustBundleList build() {
    ClusterTrustBundleList buildable = new ClusterTrustBundleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}