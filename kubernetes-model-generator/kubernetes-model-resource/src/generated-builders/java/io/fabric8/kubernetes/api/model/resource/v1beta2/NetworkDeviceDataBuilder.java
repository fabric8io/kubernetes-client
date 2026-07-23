package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDeviceDataBuilder extends NetworkDeviceDataFluent<NetworkDeviceDataBuilder> implements VisitableBuilder<NetworkDeviceData,NetworkDeviceDataBuilder>{

  NetworkDeviceDataFluent<?> fluent;

  public NetworkDeviceDataBuilder() {
    this(new NetworkDeviceData());
  }
  
  public NetworkDeviceDataBuilder(NetworkDeviceDataFluent<?> fluent) {
    this(fluent, new NetworkDeviceData());
  }
  
  public NetworkDeviceDataBuilder(NetworkDeviceData instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDeviceDataBuilder(NetworkDeviceDataFluent<?> fluent,NetworkDeviceData instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDeviceData build() {
    NetworkDeviceData buildable = new NetworkDeviceData(fluent.getHardwareAddress(), fluent.getInterfaceName(), fluent.getIps());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}