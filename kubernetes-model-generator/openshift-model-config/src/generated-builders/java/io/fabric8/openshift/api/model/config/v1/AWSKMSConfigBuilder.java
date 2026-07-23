package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSKMSConfigBuilder extends AWSKMSConfigFluent<AWSKMSConfigBuilder> implements VisitableBuilder<AWSKMSConfig,AWSKMSConfigBuilder>{

  AWSKMSConfigFluent<?> fluent;

  public AWSKMSConfigBuilder() {
    this(new AWSKMSConfig());
  }
  
  public AWSKMSConfigBuilder(AWSKMSConfigFluent<?> fluent) {
    this(fluent, new AWSKMSConfig());
  }
  
  public AWSKMSConfigBuilder(AWSKMSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSKMSConfigBuilder(AWSKMSConfigFluent<?> fluent,AWSKMSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSKMSConfig build() {
    AWSKMSConfig buildable = new AWSKMSConfig(fluent.getKeyARN(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}