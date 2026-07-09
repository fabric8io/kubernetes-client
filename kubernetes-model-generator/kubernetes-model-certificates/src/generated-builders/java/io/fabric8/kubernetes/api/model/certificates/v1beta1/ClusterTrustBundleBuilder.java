package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTrustBundleBuilder extends ClusterTrustBundleFluent<ClusterTrustBundleBuilder> implements VisitableBuilder<ClusterTrustBundle,ClusterTrustBundleBuilder>{

  ClusterTrustBundleFluent<?> fluent;

  public ClusterTrustBundleBuilder() {
    this(new ClusterTrustBundle());
  }
  
  public ClusterTrustBundleBuilder(ClusterTrustBundleFluent<?> fluent) {
    this(fluent, new ClusterTrustBundle());
  }
  
  public ClusterTrustBundleBuilder(ClusterTrustBundle instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTrustBundleBuilder(ClusterTrustBundleFluent<?> fluent,ClusterTrustBundle instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTrustBundle build() {
    ClusterTrustBundle buildable = new ClusterTrustBundle(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}