package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingFormatterBuilder extends TracingFormatterFluent<TracingFormatterBuilder> implements VisitableBuilder<TracingFormatter,TracingFormatterBuilder>{

  TracingFormatterFluent<?> fluent;

  public TracingFormatterBuilder() {
    this(new TracingFormatter());
  }
  
  public TracingFormatterBuilder(TracingFormatterFluent<?> fluent) {
    this(fluent, new TracingFormatter());
  }
  
  public TracingFormatterBuilder(TracingFormatter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingFormatterBuilder(TracingFormatterFluent<?> fluent,TracingFormatter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingFormatter build() {
    TracingFormatter buildable = new TracingFormatter(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}