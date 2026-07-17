package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDeviceSpecBuilder extends NetworkDeviceSpecFluent<NetworkDeviceSpecBuilder> implements VisitableBuilder<NetworkDeviceSpec,NetworkDeviceSpecBuilder>{

  NetworkDeviceSpecFluent<?> fluent;

  public NetworkDeviceSpecBuilder() {
    this(new NetworkDeviceSpec());
  }
  
  public NetworkDeviceSpecBuilder(NetworkDeviceSpecFluent<?> fluent) {
    this(fluent, new NetworkDeviceSpec());
  }
  
  public NetworkDeviceSpecBuilder(NetworkDeviceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDeviceSpecBuilder(NetworkDeviceSpecFluent<?> fluent,NetworkDeviceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDeviceSpec build() {
    NetworkDeviceSpec buildable = new NetworkDeviceSpec(fluent.buildAddressesFromPools(), fluent.getGateway(), fluent.getIpAddrs(), fluent.getNameservers(), fluent.getNetworkName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}