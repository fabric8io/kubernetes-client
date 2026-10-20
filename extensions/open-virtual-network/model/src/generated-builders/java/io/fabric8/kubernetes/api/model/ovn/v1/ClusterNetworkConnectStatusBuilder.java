package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkConnectStatusBuilder extends ClusterNetworkConnectStatusFluent<ClusterNetworkConnectStatusBuilder> implements VisitableBuilder<ClusterNetworkConnectStatus,ClusterNetworkConnectStatusBuilder>{

  ClusterNetworkConnectStatusFluent<?> fluent;

  public ClusterNetworkConnectStatusBuilder() {
    this(new ClusterNetworkConnectStatus());
  }
  
  public ClusterNetworkConnectStatusBuilder(ClusterNetworkConnectStatusFluent<?> fluent) {
    this(fluent, new ClusterNetworkConnectStatus());
  }
  
  public ClusterNetworkConnectStatusBuilder(ClusterNetworkConnectStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkConnectStatusBuilder(ClusterNetworkConnectStatusFluent<?> fluent,ClusterNetworkConnectStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetworkConnectStatus build() {
    ClusterNetworkConnectStatus buildable = new ClusterNetworkConnectStatus(fluent.getConditions(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}