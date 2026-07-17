package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RetainConfigBuilder extends RetainConfigFluent<RetainConfigBuilder> implements VisitableBuilder<RetainConfig,RetainConfigBuilder>{

  RetainConfigFluent<?> fluent;

  public RetainConfigBuilder() {
    this(new RetainConfig());
  }
  
  public RetainConfigBuilder(RetainConfigFluent<?> fluent) {
    this(fluent, new RetainConfig());
  }
  
  public RetainConfigBuilder(RetainConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RetainConfigBuilder(RetainConfigFluent<?> fluent,RetainConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RetainConfig build() {
    RetainConfig buildable = new RetainConfig(fluent.getRetentionPeriod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}