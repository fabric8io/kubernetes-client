package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimListBuilder extends ClusterClaimListFluent<ClusterClaimListBuilder> implements VisitableBuilder<ClusterClaimList,ClusterClaimListBuilder>{

  ClusterClaimListFluent<?> fluent;

  public ClusterClaimListBuilder() {
    this(new ClusterClaimList());
  }
  
  public ClusterClaimListBuilder(ClusterClaimListFluent<?> fluent) {
    this(fluent, new ClusterClaimList());
  }
  
  public ClusterClaimListBuilder(ClusterClaimList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimListBuilder(ClusterClaimListFluent<?> fluent,ClusterClaimList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaimList build() {
    ClusterClaimList buildable = new ClusterClaimList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}