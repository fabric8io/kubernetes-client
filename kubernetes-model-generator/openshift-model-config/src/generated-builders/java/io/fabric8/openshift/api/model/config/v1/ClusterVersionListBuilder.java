package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionListBuilder extends ClusterVersionListFluent<ClusterVersionListBuilder> implements VisitableBuilder<ClusterVersionList,ClusterVersionListBuilder>{

  ClusterVersionListFluent<?> fluent;

  public ClusterVersionListBuilder() {
    this(new ClusterVersionList());
  }
  
  public ClusterVersionListBuilder(ClusterVersionListFluent<?> fluent) {
    this(fluent, new ClusterVersionList());
  }
  
  public ClusterVersionListBuilder(ClusterVersionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionListBuilder(ClusterVersionListFluent<?> fluent,ClusterVersionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionList build() {
    ClusterVersionList buildable = new ClusterVersionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}