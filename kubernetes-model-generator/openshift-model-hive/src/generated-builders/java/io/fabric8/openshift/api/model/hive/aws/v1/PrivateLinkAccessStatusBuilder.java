package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrivateLinkAccessStatusBuilder extends PrivateLinkAccessStatusFluent<PrivateLinkAccessStatusBuilder> implements VisitableBuilder<PrivateLinkAccessStatus,PrivateLinkAccessStatusBuilder>{

  PrivateLinkAccessStatusFluent<?> fluent;

  public PrivateLinkAccessStatusBuilder() {
    this(new PrivateLinkAccessStatus());
  }
  
  public PrivateLinkAccessStatusBuilder(PrivateLinkAccessStatusFluent<?> fluent) {
    this(fluent, new PrivateLinkAccessStatus());
  }
  
  public PrivateLinkAccessStatusBuilder(PrivateLinkAccessStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrivateLinkAccessStatusBuilder(PrivateLinkAccessStatusFluent<?> fluent,PrivateLinkAccessStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrivateLinkAccessStatus build() {
    PrivateLinkAccessStatus buildable = new PrivateLinkAccessStatus(fluent.getHostedZoneID(), fluent.getVpcEndpointID(), fluent.buildVpcEndpointService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}