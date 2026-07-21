package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingCustomTagHeaderBuilder extends TracingCustomTagHeaderFluent<TracingCustomTagHeaderBuilder> implements VisitableBuilder<TracingCustomTagHeader,TracingCustomTagHeaderBuilder>{

  TracingCustomTagHeaderFluent<?> fluent;

  public TracingCustomTagHeaderBuilder() {
    this(new TracingCustomTagHeader());
  }
  
  public TracingCustomTagHeaderBuilder(TracingCustomTagHeaderFluent<?> fluent) {
    this(fluent, new TracingCustomTagHeader());
  }
  
  public TracingCustomTagHeaderBuilder(TracingCustomTagHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingCustomTagHeaderBuilder(TracingCustomTagHeaderFluent<?> fluent,TracingCustomTagHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingCustomTagHeader build() {
    TracingCustomTagHeader buildable = new TracingCustomTagHeader(fluent.buildHeader());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}