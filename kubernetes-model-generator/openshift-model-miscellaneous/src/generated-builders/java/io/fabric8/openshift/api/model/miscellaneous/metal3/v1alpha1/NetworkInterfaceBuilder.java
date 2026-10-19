package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkInterfaceBuilder extends NetworkInterfaceFluent<NetworkInterfaceBuilder> implements VisitableBuilder<NetworkInterface,NetworkInterfaceBuilder>{

  NetworkInterfaceFluent<?> fluent;

  public NetworkInterfaceBuilder() {
    this(new NetworkInterface());
  }
  
  public NetworkInterfaceBuilder(NetworkInterfaceFluent<?> fluent) {
    this(fluent, new NetworkInterface());
  }
  
  public NetworkInterfaceBuilder(NetworkInterface instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkInterfaceBuilder(NetworkInterfaceFluent<?> fluent,NetworkInterface instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkInterface build() {
    NetworkInterface buildable = new NetworkInterface(fluent.buildHostNetworkAttachment(), fluent.getMacAddress(), fluent.getName(), fluent.buildSwitchPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}