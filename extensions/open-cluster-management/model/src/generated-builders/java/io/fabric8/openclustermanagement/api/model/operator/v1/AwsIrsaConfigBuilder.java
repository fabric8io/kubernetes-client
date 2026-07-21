package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsIrsaConfigBuilder extends AwsIrsaConfigFluent<AwsIrsaConfigBuilder> implements VisitableBuilder<AwsIrsaConfig,AwsIrsaConfigBuilder>{

  AwsIrsaConfigFluent<?> fluent;

  public AwsIrsaConfigBuilder() {
    this(new AwsIrsaConfig());
  }
  
  public AwsIrsaConfigBuilder(AwsIrsaConfigFluent<?> fluent) {
    this(fluent, new AwsIrsaConfig());
  }
  
  public AwsIrsaConfigBuilder(AwsIrsaConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsIrsaConfigBuilder(AwsIrsaConfigFluent<?> fluent,AwsIrsaConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AwsIrsaConfig build() {
    AwsIrsaConfig buildable = new AwsIrsaConfig(fluent.getAutoApprovedIdentities(), fluent.getHubClusterArn(), fluent.getTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}