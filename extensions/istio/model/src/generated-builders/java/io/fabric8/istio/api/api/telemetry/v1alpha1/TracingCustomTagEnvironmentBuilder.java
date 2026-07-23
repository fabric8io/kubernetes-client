package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingCustomTagEnvironmentBuilder extends TracingCustomTagEnvironmentFluent<TracingCustomTagEnvironmentBuilder> implements VisitableBuilder<TracingCustomTagEnvironment,TracingCustomTagEnvironmentBuilder>{

  TracingCustomTagEnvironmentFluent<?> fluent;

  public TracingCustomTagEnvironmentBuilder() {
    this(new TracingCustomTagEnvironment());
  }
  
  public TracingCustomTagEnvironmentBuilder(TracingCustomTagEnvironmentFluent<?> fluent) {
    this(fluent, new TracingCustomTagEnvironment());
  }
  
  public TracingCustomTagEnvironmentBuilder(TracingCustomTagEnvironment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingCustomTagEnvironmentBuilder(TracingCustomTagEnvironmentFluent<?> fluent,TracingCustomTagEnvironment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingCustomTagEnvironment build() {
    TracingCustomTagEnvironment buildable = new TracingCustomTagEnvironment(fluent.buildEnvironment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}