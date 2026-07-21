package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingCustomTagLiteralBuilder extends TracingCustomTagLiteralFluent<TracingCustomTagLiteralBuilder> implements VisitableBuilder<TracingCustomTagLiteral,TracingCustomTagLiteralBuilder>{

  TracingCustomTagLiteralFluent<?> fluent;

  public TracingCustomTagLiteralBuilder() {
    this(new TracingCustomTagLiteral());
  }
  
  public TracingCustomTagLiteralBuilder(TracingCustomTagLiteralFluent<?> fluent) {
    this(fluent, new TracingCustomTagLiteral());
  }
  
  public TracingCustomTagLiteralBuilder(TracingCustomTagLiteral instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingCustomTagLiteralBuilder(TracingCustomTagLiteralFluent<?> fluent,TracingCustomTagLiteral instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingCustomTagLiteral build() {
    TracingCustomTagLiteral buildable = new TracingCustomTagLiteral(fluent.buildLiteral());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}