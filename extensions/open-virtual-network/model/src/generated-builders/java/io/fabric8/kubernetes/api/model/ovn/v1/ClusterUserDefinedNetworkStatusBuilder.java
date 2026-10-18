package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterUserDefinedNetworkStatusBuilder extends ClusterUserDefinedNetworkStatusFluent<ClusterUserDefinedNetworkStatusBuilder> implements VisitableBuilder<ClusterUserDefinedNetworkStatus,ClusterUserDefinedNetworkStatusBuilder>{

  ClusterUserDefinedNetworkStatusFluent<?> fluent;

  public ClusterUserDefinedNetworkStatusBuilder() {
    this(new ClusterUserDefinedNetworkStatus());
  }
  
  public ClusterUserDefinedNetworkStatusBuilder(ClusterUserDefinedNetworkStatusFluent<?> fluent) {
    this(fluent, new ClusterUserDefinedNetworkStatus());
  }
  
  public ClusterUserDefinedNetworkStatusBuilder(ClusterUserDefinedNetworkStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterUserDefinedNetworkStatusBuilder(ClusterUserDefinedNetworkStatusFluent<?> fluent,ClusterUserDefinedNetworkStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterUserDefinedNetworkStatus build() {
    ClusterUserDefinedNetworkStatus buildable = new ClusterUserDefinedNetworkStatus(fluent.getConditions(), fluent.getVrfName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}