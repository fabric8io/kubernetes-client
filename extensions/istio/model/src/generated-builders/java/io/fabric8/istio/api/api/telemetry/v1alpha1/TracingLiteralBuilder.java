package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingLiteralBuilder extends TracingLiteralFluent<TracingLiteralBuilder> implements VisitableBuilder<TracingLiteral,TracingLiteralBuilder>{

  TracingLiteralFluent<?> fluent;

  public TracingLiteralBuilder() {
    this(new TracingLiteral());
  }
  
  public TracingLiteralBuilder(TracingLiteralFluent<?> fluent) {
    this(fluent, new TracingLiteral());
  }
  
  public TracingLiteralBuilder(TracingLiteral instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingLiteralBuilder(TracingLiteralFluent<?> fluent,TracingLiteral instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingLiteral build() {
    TracingLiteral buildable = new TracingLiteral(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}