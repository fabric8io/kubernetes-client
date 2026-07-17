package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeprovisionListBuilder extends ClusterDeprovisionListFluent<ClusterDeprovisionListBuilder> implements VisitableBuilder<ClusterDeprovisionList,ClusterDeprovisionListBuilder>{

  ClusterDeprovisionListFluent<?> fluent;

  public ClusterDeprovisionListBuilder() {
    this(new ClusterDeprovisionList());
  }
  
  public ClusterDeprovisionListBuilder(ClusterDeprovisionListFluent<?> fluent) {
    this(fluent, new ClusterDeprovisionList());
  }
  
  public ClusterDeprovisionListBuilder(ClusterDeprovisionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeprovisionListBuilder(ClusterDeprovisionListFluent<?> fluent,ClusterDeprovisionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeprovisionList build() {
    ClusterDeprovisionList buildable = new ClusterDeprovisionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}