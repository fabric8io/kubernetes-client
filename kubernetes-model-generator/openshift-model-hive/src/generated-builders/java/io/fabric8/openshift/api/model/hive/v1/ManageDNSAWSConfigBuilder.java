package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManageDNSAWSConfigBuilder extends ManageDNSAWSConfigFluent<ManageDNSAWSConfigBuilder> implements VisitableBuilder<ManageDNSAWSConfig,ManageDNSAWSConfigBuilder>{

  ManageDNSAWSConfigFluent<?> fluent;

  public ManageDNSAWSConfigBuilder() {
    this(new ManageDNSAWSConfig());
  }
  
  public ManageDNSAWSConfigBuilder(ManageDNSAWSConfigFluent<?> fluent) {
    this(fluent, new ManageDNSAWSConfig());
  }
  
  public ManageDNSAWSConfigBuilder(ManageDNSAWSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManageDNSAWSConfigBuilder(ManageDNSAWSConfigFluent<?> fluent,ManageDNSAWSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManageDNSAWSConfig build() {
    ManageDNSAWSConfig buildable = new ManageDNSAWSConfig(fluent.buildCredentialsSecretRef(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}