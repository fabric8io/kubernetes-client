package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkConnectBuilder extends ClusterNetworkConnectFluent<ClusterNetworkConnectBuilder> implements VisitableBuilder<ClusterNetworkConnect,ClusterNetworkConnectBuilder>{

  ClusterNetworkConnectFluent<?> fluent;

  public ClusterNetworkConnectBuilder() {
    this(new ClusterNetworkConnect());
  }
  
  public ClusterNetworkConnectBuilder(ClusterNetworkConnectFluent<?> fluent) {
    this(fluent, new ClusterNetworkConnect());
  }
  
  public ClusterNetworkConnectBuilder(ClusterNetworkConnect instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkConnectBuilder(ClusterNetworkConnectFluent<?> fluent,ClusterNetworkConnect instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetworkConnect build() {
    ClusterNetworkConnect buildable = new ClusterNetworkConnect(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}