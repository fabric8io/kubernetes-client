package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterServiceVersionListBuilder extends ClusterServiceVersionListFluent<ClusterServiceVersionListBuilder> implements VisitableBuilder<ClusterServiceVersionList,ClusterServiceVersionListBuilder>{

  ClusterServiceVersionListFluent<?> fluent;

  public ClusterServiceVersionListBuilder() {
    this(new ClusterServiceVersionList());
  }
  
  public ClusterServiceVersionListBuilder(ClusterServiceVersionListFluent<?> fluent) {
    this(fluent, new ClusterServiceVersionList());
  }
  
  public ClusterServiceVersionListBuilder(ClusterServiceVersionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterServiceVersionListBuilder(ClusterServiceVersionListFluent<?> fluent,ClusterServiceVersionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterServiceVersionList build() {
    ClusterServiceVersionList buildable = new ClusterServiceVersionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}