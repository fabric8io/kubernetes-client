package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalDNSAWSConfigBuilder extends ExternalDNSAWSConfigFluent<ExternalDNSAWSConfigBuilder> implements VisitableBuilder<ExternalDNSAWSConfig,ExternalDNSAWSConfigBuilder>{

  ExternalDNSAWSConfigFluent<?> fluent;

  public ExternalDNSAWSConfigBuilder() {
    this(new ExternalDNSAWSConfig());
  }
  
  public ExternalDNSAWSConfigBuilder(ExternalDNSAWSConfigFluent<?> fluent) {
    this(fluent, new ExternalDNSAWSConfig());
  }
  
  public ExternalDNSAWSConfigBuilder(ExternalDNSAWSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalDNSAWSConfigBuilder(ExternalDNSAWSConfigFluent<?> fluent,ExternalDNSAWSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalDNSAWSConfig build() {
    ExternalDNSAWSConfig buildable = new ExternalDNSAWSConfig(fluent.buildCredentials());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}