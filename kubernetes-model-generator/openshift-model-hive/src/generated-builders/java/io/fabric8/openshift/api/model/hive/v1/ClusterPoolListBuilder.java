package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolListBuilder extends ClusterPoolListFluent<ClusterPoolListBuilder> implements VisitableBuilder<ClusterPoolList,ClusterPoolListBuilder>{

  ClusterPoolListFluent<?> fluent;

  public ClusterPoolListBuilder() {
    this(new ClusterPoolList());
  }
  
  public ClusterPoolListBuilder(ClusterPoolListFluent<?> fluent) {
    this(fluent, new ClusterPoolList());
  }
  
  public ClusterPoolListBuilder(ClusterPoolList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolListBuilder(ClusterPoolListFluent<?> fluent,ClusterPoolList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPoolList build() {
    ClusterPoolList buildable = new ClusterPoolList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}