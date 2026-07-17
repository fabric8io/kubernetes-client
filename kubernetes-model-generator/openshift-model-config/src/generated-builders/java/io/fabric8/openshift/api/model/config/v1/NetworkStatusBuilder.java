package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkStatusBuilder extends NetworkStatusFluent<NetworkStatusBuilder> implements VisitableBuilder<NetworkStatus,NetworkStatusBuilder>{

  NetworkStatusFluent<?> fluent;

  public NetworkStatusBuilder() {
    this(new NetworkStatus());
  }
  
  public NetworkStatusBuilder(NetworkStatusFluent<?> fluent) {
    this(fluent, new NetworkStatus());
  }
  
  public NetworkStatusBuilder(NetworkStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkStatusBuilder(NetworkStatusFluent<?> fluent,NetworkStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkStatus build() {
    NetworkStatus buildable = new NetworkStatus(fluent.buildClusterNetwork(), fluent.getClusterNetworkMTU(), fluent.getConditions(), fluent.buildMigration(), fluent.getNetworkType(), fluent.getServiceNetwork());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}