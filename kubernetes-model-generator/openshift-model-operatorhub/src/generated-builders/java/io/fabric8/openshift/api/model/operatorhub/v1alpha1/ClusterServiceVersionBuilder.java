package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterServiceVersionBuilder extends ClusterServiceVersionFluent<ClusterServiceVersionBuilder> implements VisitableBuilder<ClusterServiceVersion,ClusterServiceVersionBuilder>{

  ClusterServiceVersionFluent<?> fluent;

  public ClusterServiceVersionBuilder() {
    this(new ClusterServiceVersion());
  }
  
  public ClusterServiceVersionBuilder(ClusterServiceVersionFluent<?> fluent) {
    this(fluent, new ClusterServiceVersion());
  }
  
  public ClusterServiceVersionBuilder(ClusterServiceVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterServiceVersionBuilder(ClusterServiceVersionFluent<?> fluent,ClusterServiceVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterServiceVersion build() {
    ClusterServiceVersion buildable = new ClusterServiceVersion(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}