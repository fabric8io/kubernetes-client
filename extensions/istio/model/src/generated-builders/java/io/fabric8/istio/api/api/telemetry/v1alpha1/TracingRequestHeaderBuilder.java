package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingRequestHeaderBuilder extends TracingRequestHeaderFluent<TracingRequestHeaderBuilder> implements VisitableBuilder<TracingRequestHeader,TracingRequestHeaderBuilder>{

  TracingRequestHeaderFluent<?> fluent;

  public TracingRequestHeaderBuilder() {
    this(new TracingRequestHeader());
  }
  
  public TracingRequestHeaderBuilder(TracingRequestHeaderFluent<?> fluent) {
    this(fluent, new TracingRequestHeader());
  }
  
  public TracingRequestHeaderBuilder(TracingRequestHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingRequestHeaderBuilder(TracingRequestHeaderFluent<?> fluent,TracingRequestHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingRequestHeader build() {
    TracingRequestHeader buildable = new TracingRequestHeader(fluent.getDefaultValue(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}