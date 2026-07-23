package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSAssociatedVPCBuilder extends AWSAssociatedVPCFluent<AWSAssociatedVPCBuilder> implements VisitableBuilder<AWSAssociatedVPC,AWSAssociatedVPCBuilder>{

  AWSAssociatedVPCFluent<?> fluent;

  public AWSAssociatedVPCBuilder() {
    this(new AWSAssociatedVPC());
  }
  
  public AWSAssociatedVPCBuilder(AWSAssociatedVPCFluent<?> fluent) {
    this(fluent, new AWSAssociatedVPC());
  }
  
  public AWSAssociatedVPCBuilder(AWSAssociatedVPC instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSAssociatedVPCBuilder(AWSAssociatedVPCFluent<?> fluent,AWSAssociatedVPC instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSAssociatedVPC build() {
    AWSAssociatedVPC buildable = new AWSAssociatedVPC(fluent.buildCredentialsSecretRef(), fluent.getRegion(), fluent.getVpcID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}