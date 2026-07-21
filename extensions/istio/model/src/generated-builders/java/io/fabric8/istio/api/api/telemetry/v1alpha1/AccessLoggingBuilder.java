package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AccessLoggingBuilder extends AccessLoggingFluent<AccessLoggingBuilder> implements VisitableBuilder<AccessLogging,AccessLoggingBuilder>{

  AccessLoggingFluent<?> fluent;

  public AccessLoggingBuilder() {
    this(new AccessLogging());
  }
  
  public AccessLoggingBuilder(AccessLoggingFluent<?> fluent) {
    this(fluent, new AccessLogging());
  }
  
  public AccessLoggingBuilder(AccessLogging instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AccessLoggingBuilder(AccessLoggingFluent<?> fluent,AccessLogging instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AccessLogging build() {
    AccessLogging buildable = new AccessLogging(fluent.getDisabled(), fluent.buildFilter(), fluent.buildMatch(), fluent.buildProviders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}