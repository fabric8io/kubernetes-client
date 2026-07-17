package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSPrivateLinkVPCBuilder extends AWSPrivateLinkVPCFluent<AWSPrivateLinkVPCBuilder> implements VisitableBuilder<AWSPrivateLinkVPC,AWSPrivateLinkVPCBuilder>{

  AWSPrivateLinkVPCFluent<?> fluent;

  public AWSPrivateLinkVPCBuilder() {
    this(new AWSPrivateLinkVPC());
  }
  
  public AWSPrivateLinkVPCBuilder(AWSPrivateLinkVPCFluent<?> fluent) {
    this(fluent, new AWSPrivateLinkVPC());
  }
  
  public AWSPrivateLinkVPCBuilder(AWSPrivateLinkVPC instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSPrivateLinkVPCBuilder(AWSPrivateLinkVPCFluent<?> fluent,AWSPrivateLinkVPC instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSPrivateLinkVPC build() {
    AWSPrivateLinkVPC buildable = new AWSPrivateLinkVPC(fluent.getRegion(), fluent.getVpcID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}