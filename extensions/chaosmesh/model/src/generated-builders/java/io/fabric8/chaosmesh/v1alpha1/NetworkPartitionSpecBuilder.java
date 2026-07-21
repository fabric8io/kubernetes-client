package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkPartitionSpecBuilder extends NetworkPartitionSpecFluent<NetworkPartitionSpecBuilder> implements VisitableBuilder<NetworkPartitionSpec,NetworkPartitionSpecBuilder>{

  NetworkPartitionSpecFluent<?> fluent;

  public NetworkPartitionSpecBuilder() {
    this(new NetworkPartitionSpec());
  }
  
  public NetworkPartitionSpecBuilder(NetworkPartitionSpecFluent<?> fluent) {
    this(fluent, new NetworkPartitionSpec());
  }
  
  public NetworkPartitionSpecBuilder(NetworkPartitionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkPartitionSpecBuilder(NetworkPartitionSpecFluent<?> fluent,NetworkPartitionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkPartitionSpec build() {
    NetworkPartitionSpec buildable = new NetworkPartitionSpec(fluent.getAcceptTcpFlags(), fluent.getDevice(), fluent.getDirection(), fluent.getHostname(), fluent.getIpAddress(), fluent.getIpProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}