package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AccessLoggingLogSelectorBuilder extends AccessLoggingLogSelectorFluent<AccessLoggingLogSelectorBuilder> implements VisitableBuilder<AccessLoggingLogSelector,AccessLoggingLogSelectorBuilder>{

  AccessLoggingLogSelectorFluent<?> fluent;

  public AccessLoggingLogSelectorBuilder() {
    this(new AccessLoggingLogSelector());
  }
  
  public AccessLoggingLogSelectorBuilder(AccessLoggingLogSelectorFluent<?> fluent) {
    this(fluent, new AccessLoggingLogSelector());
  }
  
  public AccessLoggingLogSelectorBuilder(AccessLoggingLogSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AccessLoggingLogSelectorBuilder(AccessLoggingLogSelectorFluent<?> fluent,AccessLoggingLogSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AccessLoggingLogSelector build() {
    AccessLoggingLogSelector buildable = new AccessLoggingLogSelector(fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}