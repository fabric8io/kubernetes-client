package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkConnectListBuilder extends ClusterNetworkConnectListFluent<ClusterNetworkConnectListBuilder> implements VisitableBuilder<ClusterNetworkConnectList,ClusterNetworkConnectListBuilder>{

  ClusterNetworkConnectListFluent<?> fluent;

  public ClusterNetworkConnectListBuilder() {
    this(new ClusterNetworkConnectList());
  }
  
  public ClusterNetworkConnectListBuilder(ClusterNetworkConnectListFluent<?> fluent) {
    this(fluent, new ClusterNetworkConnectList());
  }
  
  public ClusterNetworkConnectListBuilder(ClusterNetworkConnectList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkConnectListBuilder(ClusterNetworkConnectListFluent<?> fluent,ClusterNetworkConnectList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetworkConnectList build() {
    ClusterNetworkConnectList buildable = new ClusterNetworkConnectList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}