package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectSubnetBuilder extends ConnectSubnetFluent<ConnectSubnetBuilder> implements VisitableBuilder<ConnectSubnet,ConnectSubnetBuilder>{

  ConnectSubnetFluent<?> fluent;

  public ConnectSubnetBuilder() {
    this(new ConnectSubnet());
  }
  
  public ConnectSubnetBuilder(ConnectSubnetFluent<?> fluent) {
    this(fluent, new ConnectSubnet());
  }
  
  public ConnectSubnetBuilder(ConnectSubnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectSubnetBuilder(ConnectSubnetFluent<?> fluent,ConnectSubnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectSubnet build() {
    ConnectSubnet buildable = new ConnectSubnet(fluent.getCidr(), fluent.getNetworkPrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}