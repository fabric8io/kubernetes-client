package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingCustomTagBuilder extends TracingCustomTagFluent<TracingCustomTagBuilder> implements VisitableBuilder<TracingCustomTag,TracingCustomTagBuilder>{

  TracingCustomTagFluent<?> fluent;

  public TracingCustomTagBuilder() {
    this(new TracingCustomTag());
  }
  
  public TracingCustomTagBuilder(TracingCustomTagFluent<?> fluent) {
    this(fluent, new TracingCustomTag());
  }
  
  public TracingCustomTagBuilder(TracingCustomTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingCustomTagBuilder(TracingCustomTagFluent<?> fluent,TracingCustomTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingCustomTag build() {
    TracingCustomTag buildable = new TracingCustomTag(fluent.buildType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}