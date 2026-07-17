package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPPrivateServiceConnectSubnetBuilder extends GCPPrivateServiceConnectSubnetFluent<GCPPrivateServiceConnectSubnetBuilder> implements VisitableBuilder<GCPPrivateServiceConnectSubnet,GCPPrivateServiceConnectSubnetBuilder>{

  GCPPrivateServiceConnectSubnetFluent<?> fluent;

  public GCPPrivateServiceConnectSubnetBuilder() {
    this(new GCPPrivateServiceConnectSubnet());
  }
  
  public GCPPrivateServiceConnectSubnetBuilder(GCPPrivateServiceConnectSubnetFluent<?> fluent) {
    this(fluent, new GCPPrivateServiceConnectSubnet());
  }
  
  public GCPPrivateServiceConnectSubnetBuilder(GCPPrivateServiceConnectSubnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPPrivateServiceConnectSubnetBuilder(GCPPrivateServiceConnectSubnetFluent<?> fluent,GCPPrivateServiceConnectSubnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPPrivateServiceConnectSubnet build() {
    GCPPrivateServiceConnectSubnet buildable = new GCPPrivateServiceConnectSubnet(fluent.getRegion(), fluent.getSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}