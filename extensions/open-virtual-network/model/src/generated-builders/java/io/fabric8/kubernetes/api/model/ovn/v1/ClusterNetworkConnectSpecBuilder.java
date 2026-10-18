package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkConnectSpecBuilder extends ClusterNetworkConnectSpecFluent<ClusterNetworkConnectSpecBuilder> implements VisitableBuilder<ClusterNetworkConnectSpec,ClusterNetworkConnectSpecBuilder>{

  ClusterNetworkConnectSpecFluent<?> fluent;

  public ClusterNetworkConnectSpecBuilder() {
    this(new ClusterNetworkConnectSpec());
  }
  
  public ClusterNetworkConnectSpecBuilder(ClusterNetworkConnectSpecFluent<?> fluent) {
    this(fluent, new ClusterNetworkConnectSpec());
  }
  
  public ClusterNetworkConnectSpecBuilder(ClusterNetworkConnectSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkConnectSpecBuilder(ClusterNetworkConnectSpecFluent<?> fluent,ClusterNetworkConnectSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetworkConnectSpec build() {
    ClusterNetworkConnectSpec buildable = new ClusterNetworkConnectSpec(fluent.buildConnectSubnets(), fluent.getConnectivity(), fluent.buildNetworkSelectors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}