package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoggingConfigBuilder extends LoggingConfigFluent<LoggingConfigBuilder> implements VisitableBuilder<LoggingConfig,LoggingConfigBuilder>{

  LoggingConfigFluent<?> fluent;

  public LoggingConfigBuilder() {
    this(new LoggingConfig());
  }
  
  public LoggingConfigBuilder(LoggingConfigFluent<?> fluent) {
    this(fluent, new LoggingConfig());
  }
  
  public LoggingConfigBuilder(LoggingConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoggingConfigBuilder(LoggingConfigFluent<?> fluent,LoggingConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoggingConfig build() {
    LoggingConfig buildable = new LoggingConfig(fluent.getLevel(), fluent.getVmodule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}