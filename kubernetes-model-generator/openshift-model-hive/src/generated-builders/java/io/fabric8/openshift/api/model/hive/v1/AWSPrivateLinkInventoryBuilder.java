package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSPrivateLinkInventoryBuilder extends AWSPrivateLinkInventoryFluent<AWSPrivateLinkInventoryBuilder> implements VisitableBuilder<AWSPrivateLinkInventory,AWSPrivateLinkInventoryBuilder>{

  AWSPrivateLinkInventoryFluent<?> fluent;

  public AWSPrivateLinkInventoryBuilder() {
    this(new AWSPrivateLinkInventory());
  }
  
  public AWSPrivateLinkInventoryBuilder(AWSPrivateLinkInventoryFluent<?> fluent) {
    this(fluent, new AWSPrivateLinkInventory());
  }
  
  public AWSPrivateLinkInventoryBuilder(AWSPrivateLinkInventory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSPrivateLinkInventoryBuilder(AWSPrivateLinkInventoryFluent<?> fluent,AWSPrivateLinkInventory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSPrivateLinkInventory build() {
    AWSPrivateLinkInventory buildable = new AWSPrivateLinkInventory(fluent.getRegion(), fluent.buildSubnets(), fluent.getVpcID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}