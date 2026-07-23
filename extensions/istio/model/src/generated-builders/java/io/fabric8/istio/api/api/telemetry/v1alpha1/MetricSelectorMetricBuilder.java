package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricSelectorMetricBuilder extends MetricSelectorMetricFluent<MetricSelectorMetricBuilder> implements VisitableBuilder<MetricSelectorMetric,MetricSelectorMetricBuilder>{

  MetricSelectorMetricFluent<?> fluent;

  public MetricSelectorMetricBuilder() {
    this(new MetricSelectorMetric());
  }
  
  public MetricSelectorMetricBuilder(MetricSelectorMetricFluent<?> fluent) {
    this(fluent, new MetricSelectorMetric());
  }
  
  public MetricSelectorMetricBuilder(MetricSelectorMetric instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricSelectorMetricBuilder(MetricSelectorMetricFluent<?> fluent,MetricSelectorMetric instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricSelectorMetric build() {
    MetricSelectorMetric buildable = new MetricSelectorMetric(fluent.getMetric());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}