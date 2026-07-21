package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailedProvisionConfigBuilder extends FailedProvisionConfigFluent<FailedProvisionConfigBuilder> implements VisitableBuilder<FailedProvisionConfig,FailedProvisionConfigBuilder>{

  FailedProvisionConfigFluent<?> fluent;

  public FailedProvisionConfigBuilder() {
    this(new FailedProvisionConfig());
  }
  
  public FailedProvisionConfigBuilder(FailedProvisionConfigFluent<?> fluent) {
    this(fluent, new FailedProvisionConfig());
  }
  
  public FailedProvisionConfigBuilder(FailedProvisionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailedProvisionConfigBuilder(FailedProvisionConfigFluent<?> fluent,FailedProvisionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailedProvisionConfig build() {
    FailedProvisionConfig buildable = new FailedProvisionConfig(fluent.getSkipGatherLogs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}