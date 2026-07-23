package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTrustBundleSpecBuilder extends ClusterTrustBundleSpecFluent<ClusterTrustBundleSpecBuilder> implements VisitableBuilder<ClusterTrustBundleSpec,ClusterTrustBundleSpecBuilder>{

  ClusterTrustBundleSpecFluent<?> fluent;

  public ClusterTrustBundleSpecBuilder() {
    this(new ClusterTrustBundleSpec());
  }
  
  public ClusterTrustBundleSpecBuilder(ClusterTrustBundleSpecFluent<?> fluent) {
    this(fluent, new ClusterTrustBundleSpec());
  }
  
  public ClusterTrustBundleSpecBuilder(ClusterTrustBundleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTrustBundleSpecBuilder(ClusterTrustBundleSpecFluent<?> fluent,ClusterTrustBundleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTrustBundleSpec build() {
    ClusterTrustBundleSpec buildable = new ClusterTrustBundleSpec(fluent.getSignerName(), fluent.getTrustBundle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}