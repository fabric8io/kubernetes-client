package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LoggingDestinationBuilder extends LoggingDestinationFluent<LoggingDestinationBuilder> implements VisitableBuilder<LoggingDestination,LoggingDestinationBuilder>{

  LoggingDestinationFluent<?> fluent;

  public LoggingDestinationBuilder() {
    this(new LoggingDestination());
  }
  
  public LoggingDestinationBuilder(LoggingDestinationFluent<?> fluent) {
    this(fluent, new LoggingDestination());
  }
  
  public LoggingDestinationBuilder(LoggingDestination instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LoggingDestinationBuilder(LoggingDestinationFluent<?> fluent,LoggingDestination instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LoggingDestination build() {
    LoggingDestination buildable = new LoggingDestination(fluent.buildContainer(), fluent.buildSyslog(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}