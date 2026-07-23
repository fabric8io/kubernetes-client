package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricSelectorBuilder extends MetricSelectorFluent<MetricSelectorBuilder> implements VisitableBuilder<MetricSelector,MetricSelectorBuilder>{

  MetricSelectorFluent<?> fluent;

  public MetricSelectorBuilder() {
    this(new MetricSelector());
  }
  
  public MetricSelectorBuilder(MetricSelectorFluent<?> fluent) {
    this(fluent, new MetricSelector());
  }
  
  public MetricSelectorBuilder(MetricSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricSelectorBuilder(MetricSelectorFluent<?> fluent,MetricSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricSelector build() {
    MetricSelector buildable = new MetricSelector(fluent.buildMetricMatch(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}