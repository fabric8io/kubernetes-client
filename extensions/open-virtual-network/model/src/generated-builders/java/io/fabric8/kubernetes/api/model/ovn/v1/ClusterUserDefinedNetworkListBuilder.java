package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterUserDefinedNetworkListBuilder extends ClusterUserDefinedNetworkListFluent<ClusterUserDefinedNetworkListBuilder> implements VisitableBuilder<ClusterUserDefinedNetworkList,ClusterUserDefinedNetworkListBuilder>{

  ClusterUserDefinedNetworkListFluent<?> fluent;

  public ClusterUserDefinedNetworkListBuilder() {
    this(new ClusterUserDefinedNetworkList());
  }
  
  public ClusterUserDefinedNetworkListBuilder(ClusterUserDefinedNetworkListFluent<?> fluent) {
    this(fluent, new ClusterUserDefinedNetworkList());
  }
  
  public ClusterUserDefinedNetworkListBuilder(ClusterUserDefinedNetworkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterUserDefinedNetworkListBuilder(ClusterUserDefinedNetworkListFluent<?> fluent,ClusterUserDefinedNetworkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterUserDefinedNetworkList build() {
    ClusterUserDefinedNetworkList buildable = new ClusterUserDefinedNetworkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}