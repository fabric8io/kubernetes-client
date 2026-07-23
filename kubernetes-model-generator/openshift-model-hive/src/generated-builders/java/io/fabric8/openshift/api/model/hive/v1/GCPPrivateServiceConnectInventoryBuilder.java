package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPPrivateServiceConnectInventoryBuilder extends GCPPrivateServiceConnectInventoryFluent<GCPPrivateServiceConnectInventoryBuilder> implements VisitableBuilder<GCPPrivateServiceConnectInventory,GCPPrivateServiceConnectInventoryBuilder>{

  GCPPrivateServiceConnectInventoryFluent<?> fluent;

  public GCPPrivateServiceConnectInventoryBuilder() {
    this(new GCPPrivateServiceConnectInventory());
  }
  
  public GCPPrivateServiceConnectInventoryBuilder(GCPPrivateServiceConnectInventoryFluent<?> fluent) {
    this(fluent, new GCPPrivateServiceConnectInventory());
  }
  
  public GCPPrivateServiceConnectInventoryBuilder(GCPPrivateServiceConnectInventory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPPrivateServiceConnectInventoryBuilder(GCPPrivateServiceConnectInventoryFluent<?> fluent,GCPPrivateServiceConnectInventory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPPrivateServiceConnectInventory build() {
    GCPPrivateServiceConnectInventory buildable = new GCPPrivateServiceConnectInventory(fluent.getNetwork(), fluent.buildSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}