package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPNetworkInterfaceBuilder extends GCPNetworkInterfaceFluent<GCPNetworkInterfaceBuilder> implements VisitableBuilder<GCPNetworkInterface,GCPNetworkInterfaceBuilder>{

  GCPNetworkInterfaceFluent<?> fluent;

  public GCPNetworkInterfaceBuilder() {
    this(new GCPNetworkInterface());
  }
  
  public GCPNetworkInterfaceBuilder(GCPNetworkInterfaceFluent<?> fluent) {
    this(fluent, new GCPNetworkInterface());
  }
  
  public GCPNetworkInterfaceBuilder(GCPNetworkInterface instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPNetworkInterfaceBuilder(GCPNetworkInterfaceFluent<?> fluent,GCPNetworkInterface instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPNetworkInterface build() {
    GCPNetworkInterface buildable = new GCPNetworkInterface(fluent.getNetwork(), fluent.getProjectID(), fluent.getPublicIP(), fluent.getSubnetwork());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}