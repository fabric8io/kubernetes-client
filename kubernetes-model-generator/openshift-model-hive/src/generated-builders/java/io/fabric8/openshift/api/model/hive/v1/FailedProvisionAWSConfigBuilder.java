package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailedProvisionAWSConfigBuilder extends FailedProvisionAWSConfigFluent<FailedProvisionAWSConfigBuilder> implements VisitableBuilder<FailedProvisionAWSConfig,FailedProvisionAWSConfigBuilder>{

  FailedProvisionAWSConfigFluent<?> fluent;

  public FailedProvisionAWSConfigBuilder() {
    this(new FailedProvisionAWSConfig());
  }
  
  public FailedProvisionAWSConfigBuilder(FailedProvisionAWSConfigFluent<?> fluent) {
    this(fluent, new FailedProvisionAWSConfig());
  }
  
  public FailedProvisionAWSConfigBuilder(FailedProvisionAWSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailedProvisionAWSConfigBuilder(FailedProvisionAWSConfigFluent<?> fluent,FailedProvisionAWSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailedProvisionAWSConfig build() {
    FailedProvisionAWSConfig buildable = new FailedProvisionAWSConfig(fluent.getBucket(), fluent.buildCredentialsSecretRef(), fluent.getRegion(), fluent.getServiceEndpoint());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}