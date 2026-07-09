package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodMetricsBuilder extends PodMetricsFluent<PodMetricsBuilder> implements VisitableBuilder<PodMetrics,PodMetricsBuilder>{

  PodMetricsFluent<?> fluent;

  public PodMetricsBuilder() {
    this(new PodMetrics());
  }
  
  public PodMetricsBuilder(PodMetricsFluent<?> fluent) {
    this(fluent, new PodMetrics());
  }
  
  public PodMetricsBuilder(PodMetrics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodMetricsBuilder(PodMetricsFluent<?> fluent,PodMetrics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodMetrics build() {
    PodMetrics buildable = new PodMetrics(fluent.getApiVersion(), fluent.buildContainers(), fluent.getKind(), fluent.buildMetadata(), fluent.getTimestamp(), fluent.getWindow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}