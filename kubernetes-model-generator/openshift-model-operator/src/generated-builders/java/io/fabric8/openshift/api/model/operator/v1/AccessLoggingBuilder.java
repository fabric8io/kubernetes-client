package io.fabric8.openshift.api.model.operator.v1;

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
    AccessLogging buildable = new AccessLogging(fluent.buildDestination(), fluent.buildHttpCaptureCookies(), fluent.buildHttpCaptureHeaders(), fluent.getHttpLogFormat(), fluent.getLogEmptyRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}