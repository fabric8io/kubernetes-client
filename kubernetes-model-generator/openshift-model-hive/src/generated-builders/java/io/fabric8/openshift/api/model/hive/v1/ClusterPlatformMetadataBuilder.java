package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPlatformMetadataBuilder extends ClusterPlatformMetadataFluent<ClusterPlatformMetadataBuilder> implements VisitableBuilder<ClusterPlatformMetadata,ClusterPlatformMetadataBuilder>{

  ClusterPlatformMetadataFluent<?> fluent;

  public ClusterPlatformMetadataBuilder() {
    this(new ClusterPlatformMetadata());
  }
  
  public ClusterPlatformMetadataBuilder(ClusterPlatformMetadataFluent<?> fluent) {
    this(fluent, new ClusterPlatformMetadata());
  }
  
  public ClusterPlatformMetadataBuilder(ClusterPlatformMetadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPlatformMetadataBuilder(ClusterPlatformMetadataFluent<?> fluent,ClusterPlatformMetadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPlatformMetadata build() {
    ClusterPlatformMetadata buildable = new ClusterPlatformMetadata(fluent.buildAws(), fluent.buildAzure(), fluent.buildGcp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}