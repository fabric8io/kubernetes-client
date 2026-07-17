package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkListBuilder extends ClusterNetworkListFluent<ClusterNetworkListBuilder> implements VisitableBuilder<ClusterNetworkList,ClusterNetworkListBuilder>{

  ClusterNetworkListFluent<?> fluent;

  public ClusterNetworkListBuilder() {
    this(new ClusterNetworkList());
  }
  
  public ClusterNetworkListBuilder(ClusterNetworkListFluent<?> fluent) {
    this(fluent, new ClusterNetworkList());
  }
  
  public ClusterNetworkListBuilder(ClusterNetworkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkListBuilder(ClusterNetworkListFluent<?> fluent,ClusterNetworkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetworkList build() {
    ClusterNetworkList buildable = new ClusterNetworkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}