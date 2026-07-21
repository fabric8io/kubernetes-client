package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricSpecBuilder extends MetricSpecFluent<MetricSpecBuilder> implements VisitableBuilder<MetricSpec,MetricSpecBuilder>{

  MetricSpecFluent<?> fluent;

  public MetricSpecBuilder() {
    this(new MetricSpec());
  }
  
  public MetricSpecBuilder(MetricSpecFluent<?> fluent) {
    this(fluent, new MetricSpec());
  }
  
  public MetricSpecBuilder(MetricSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricSpecBuilder(MetricSpecFluent<?> fluent,MetricSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricSpec build() {
    MetricSpec buildable = new MetricSpec(fluent.getPanicWindow(), fluent.getScrapeTarget(), fluent.getStableWindow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}