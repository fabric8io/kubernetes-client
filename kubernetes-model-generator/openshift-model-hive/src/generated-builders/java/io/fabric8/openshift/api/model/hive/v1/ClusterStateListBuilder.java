package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterStateListBuilder extends ClusterStateListFluent<ClusterStateListBuilder> implements VisitableBuilder<ClusterStateList,ClusterStateListBuilder>{

  ClusterStateListFluent<?> fluent;

  public ClusterStateListBuilder() {
    this(new ClusterStateList());
  }
  
  public ClusterStateListBuilder(ClusterStateListFluent<?> fluent) {
    this(fluent, new ClusterStateList());
  }
  
  public ClusterStateListBuilder(ClusterStateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterStateListBuilder(ClusterStateListFluent<?> fluent,ClusterStateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterStateList build() {
    ClusterStateList buildable = new ClusterStateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}