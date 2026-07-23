package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostSubnetBuilder extends HostSubnetFluent<HostSubnetBuilder> implements VisitableBuilder<HostSubnet,HostSubnetBuilder>{

  HostSubnetFluent<?> fluent;

  public HostSubnetBuilder() {
    this(new HostSubnet());
  }
  
  public HostSubnetBuilder(HostSubnetFluent<?> fluent) {
    this(fluent, new HostSubnet());
  }
  
  public HostSubnetBuilder(HostSubnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostSubnetBuilder(HostSubnetFluent<?> fluent,HostSubnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostSubnet build() {
    HostSubnet buildable = new HostSubnet(fluent.getApiVersion(), fluent.getEgressCIDRs(), fluent.getEgressIPs(), fluent.getHost(), fluent.getHostIP(), fluent.getKind(), fluent.buildMetadata(), fluent.getSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}