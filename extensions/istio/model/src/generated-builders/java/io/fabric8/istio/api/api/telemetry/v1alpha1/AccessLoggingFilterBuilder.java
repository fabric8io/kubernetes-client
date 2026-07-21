package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AccessLoggingFilterBuilder extends AccessLoggingFilterFluent<AccessLoggingFilterBuilder> implements VisitableBuilder<AccessLoggingFilter,AccessLoggingFilterBuilder>{

  AccessLoggingFilterFluent<?> fluent;

  public AccessLoggingFilterBuilder() {
    this(new AccessLoggingFilter());
  }
  
  public AccessLoggingFilterBuilder(AccessLoggingFilterFluent<?> fluent) {
    this(fluent, new AccessLoggingFilter());
  }
  
  public AccessLoggingFilterBuilder(AccessLoggingFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AccessLoggingFilterBuilder(AccessLoggingFilterFluent<?> fluent,AccessLoggingFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AccessLoggingFilter build() {
    AccessLoggingFilter buildable = new AccessLoggingFilter(fluent.getExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}