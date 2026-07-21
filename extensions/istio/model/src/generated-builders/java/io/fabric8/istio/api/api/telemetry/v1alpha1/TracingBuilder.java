package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingBuilder extends TracingFluent<TracingBuilder> implements VisitableBuilder<Tracing,TracingBuilder>{

  TracingFluent<?> fluent;

  public TracingBuilder() {
    this(new Tracing());
  }
  
  public TracingBuilder(TracingFluent<?> fluent) {
    this(fluent, new Tracing());
  }
  
  public TracingBuilder(Tracing instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingBuilder(TracingFluent<?> fluent,Tracing instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Tracing build() {
    Tracing buildable = new Tracing(fluent.getCustomTags(), fluent.getDisableContextPropagation(), fluent.getDisableSpanReporting(), fluent.getEnableIstioTags(), fluent.buildMatch(), fluent.buildProviders(), fluent.getRandomSamplingPercentage(), fluent.getUseRequestIdForTraceSampling());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}