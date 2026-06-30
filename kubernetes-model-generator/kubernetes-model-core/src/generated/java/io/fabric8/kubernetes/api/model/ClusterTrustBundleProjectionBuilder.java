package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTrustBundleProjectionBuilder extends ClusterTrustBundleProjectionFluent<ClusterTrustBundleProjectionBuilder> implements VisitableBuilder<ClusterTrustBundleProjection,ClusterTrustBundleProjectionBuilder>{

  ClusterTrustBundleProjectionFluent<?> fluent;

  public ClusterTrustBundleProjectionBuilder() {
    this(new ClusterTrustBundleProjection());
  }
  
  public ClusterTrustBundleProjectionBuilder(ClusterTrustBundleProjectionFluent<?> fluent) {
    this(fluent, new ClusterTrustBundleProjection());
  }
  
  public ClusterTrustBundleProjectionBuilder(ClusterTrustBundleProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTrustBundleProjectionBuilder(ClusterTrustBundleProjectionFluent<?> fluent,ClusterTrustBundleProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTrustBundleProjection build() {
    ClusterTrustBundleProjection buildable = new ClusterTrustBundleProjection(fluent.buildLabelSelector(), fluent.getName(), fluent.getOptional(), fluent.getPath(), fluent.getSignerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}