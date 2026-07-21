package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingTracingSelectorBuilder extends TracingTracingSelectorFluent<TracingTracingSelectorBuilder> implements VisitableBuilder<TracingTracingSelector,TracingTracingSelectorBuilder>{

  TracingTracingSelectorFluent<?> fluent;

  public TracingTracingSelectorBuilder() {
    this(new TracingTracingSelector());
  }
  
  public TracingTracingSelectorBuilder(TracingTracingSelectorFluent<?> fluent) {
    this(fluent, new TracingTracingSelector());
  }
  
  public TracingTracingSelectorBuilder(TracingTracingSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingTracingSelectorBuilder(TracingTracingSelectorFluent<?> fluent,TracingTracingSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingTracingSelector build() {
    TracingTracingSelector buildable = new TracingTracingSelector(fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}