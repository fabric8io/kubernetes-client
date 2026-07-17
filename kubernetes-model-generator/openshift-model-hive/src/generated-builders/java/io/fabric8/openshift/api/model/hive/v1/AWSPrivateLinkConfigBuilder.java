package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSPrivateLinkConfigBuilder extends AWSPrivateLinkConfigFluent<AWSPrivateLinkConfigBuilder> implements VisitableBuilder<AWSPrivateLinkConfig,AWSPrivateLinkConfigBuilder>{

  AWSPrivateLinkConfigFluent<?> fluent;

  public AWSPrivateLinkConfigBuilder() {
    this(new AWSPrivateLinkConfig());
  }
  
  public AWSPrivateLinkConfigBuilder(AWSPrivateLinkConfigFluent<?> fluent) {
    this(fluent, new AWSPrivateLinkConfig());
  }
  
  public AWSPrivateLinkConfigBuilder(AWSPrivateLinkConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSPrivateLinkConfigBuilder(AWSPrivateLinkConfigFluent<?> fluent,AWSPrivateLinkConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSPrivateLinkConfig build() {
    AWSPrivateLinkConfig buildable = new AWSPrivateLinkConfig(fluent.buildAssociatedVPCs(), fluent.buildCredentialsSecretRef(), fluent.getDnsRecordType(), fluent.buildEndpointVPCInventory());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}