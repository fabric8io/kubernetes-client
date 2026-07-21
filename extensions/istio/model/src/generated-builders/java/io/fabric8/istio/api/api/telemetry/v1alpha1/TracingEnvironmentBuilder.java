package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingEnvironmentBuilder extends TracingEnvironmentFluent<TracingEnvironmentBuilder> implements VisitableBuilder<TracingEnvironment,TracingEnvironmentBuilder>{

  TracingEnvironmentFluent<?> fluent;

  public TracingEnvironmentBuilder() {
    this(new TracingEnvironment());
  }
  
  public TracingEnvironmentBuilder(TracingEnvironmentFluent<?> fluent) {
    this(fluent, new TracingEnvironment());
  }
  
  public TracingEnvironmentBuilder(TracingEnvironment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingEnvironmentBuilder(TracingEnvironmentFluent<?> fluent,TracingEnvironment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingEnvironment build() {
    TracingEnvironment buildable = new TracingEnvironment(fluent.getDefaultValue(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}