package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricSelectorCustomMetricBuilder extends MetricSelectorCustomMetricFluent<MetricSelectorCustomMetricBuilder> implements VisitableBuilder<MetricSelectorCustomMetric,MetricSelectorCustomMetricBuilder>{

  MetricSelectorCustomMetricFluent<?> fluent;

  public MetricSelectorCustomMetricBuilder() {
    this(new MetricSelectorCustomMetric());
  }
  
  public MetricSelectorCustomMetricBuilder(MetricSelectorCustomMetricFluent<?> fluent) {
    this(fluent, new MetricSelectorCustomMetric());
  }
  
  public MetricSelectorCustomMetricBuilder(MetricSelectorCustomMetric instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricSelectorCustomMetricBuilder(MetricSelectorCustomMetricFluent<?> fluent,MetricSelectorCustomMetric instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricSelectorCustomMetric build() {
    MetricSelectorCustomMetric buildable = new MetricSelectorCustomMetric(fluent.getCustomMetric());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}