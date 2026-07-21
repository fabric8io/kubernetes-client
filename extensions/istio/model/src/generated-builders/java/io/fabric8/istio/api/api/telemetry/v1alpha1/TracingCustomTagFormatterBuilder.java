package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingCustomTagFormatterBuilder extends TracingCustomTagFormatterFluent<TracingCustomTagFormatterBuilder> implements VisitableBuilder<TracingCustomTagFormatter,TracingCustomTagFormatterBuilder>{

  TracingCustomTagFormatterFluent<?> fluent;

  public TracingCustomTagFormatterBuilder() {
    this(new TracingCustomTagFormatter());
  }
  
  public TracingCustomTagFormatterBuilder(TracingCustomTagFormatterFluent<?> fluent) {
    this(fluent, new TracingCustomTagFormatter());
  }
  
  public TracingCustomTagFormatterBuilder(TracingCustomTagFormatter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingCustomTagFormatterBuilder(TracingCustomTagFormatterFluent<?> fluent,TracingCustomTagFormatter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingCustomTagFormatter build() {
    TracingCustomTagFormatter buildable = new TracingCustomTagFormatter(fluent.buildFormatter());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}