package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSPrivateLinkSubnetBuilder extends AWSPrivateLinkSubnetFluent<AWSPrivateLinkSubnetBuilder> implements VisitableBuilder<AWSPrivateLinkSubnet,AWSPrivateLinkSubnetBuilder>{

  AWSPrivateLinkSubnetFluent<?> fluent;

  public AWSPrivateLinkSubnetBuilder() {
    this(new AWSPrivateLinkSubnet());
  }
  
  public AWSPrivateLinkSubnetBuilder(AWSPrivateLinkSubnetFluent<?> fluent) {
    this(fluent, new AWSPrivateLinkSubnet());
  }
  
  public AWSPrivateLinkSubnetBuilder(AWSPrivateLinkSubnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSPrivateLinkSubnetBuilder(AWSPrivateLinkSubnetFluent<?> fluent,AWSPrivateLinkSubnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSPrivateLinkSubnet build() {
    AWSPrivateLinkSubnet buildable = new AWSPrivateLinkSubnet(fluent.getAvailabilityZone(), fluent.getSubnetID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}