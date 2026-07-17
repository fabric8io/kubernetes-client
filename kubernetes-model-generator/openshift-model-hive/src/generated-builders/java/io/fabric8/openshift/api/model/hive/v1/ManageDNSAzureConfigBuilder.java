package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManageDNSAzureConfigBuilder extends ManageDNSAzureConfigFluent<ManageDNSAzureConfigBuilder> implements VisitableBuilder<ManageDNSAzureConfig,ManageDNSAzureConfigBuilder>{

  ManageDNSAzureConfigFluent<?> fluent;

  public ManageDNSAzureConfigBuilder() {
    this(new ManageDNSAzureConfig());
  }
  
  public ManageDNSAzureConfigBuilder(ManageDNSAzureConfigFluent<?> fluent) {
    this(fluent, new ManageDNSAzureConfig());
  }
  
  public ManageDNSAzureConfigBuilder(ManageDNSAzureConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManageDNSAzureConfigBuilder(ManageDNSAzureConfigFluent<?> fluent,ManageDNSAzureConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManageDNSAzureConfig build() {
    ManageDNSAzureConfig buildable = new ManageDNSAzureConfig(fluent.getCloudName(), fluent.buildCredentialsSecretRef(), fluent.getResourceGroupName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}