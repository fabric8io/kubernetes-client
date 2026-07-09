package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerMetricsBuilder extends ContainerMetricsFluent<ContainerMetricsBuilder> implements VisitableBuilder<ContainerMetrics,ContainerMetricsBuilder>{

  ContainerMetricsFluent<?> fluent;

  public ContainerMetricsBuilder() {
    this(new ContainerMetrics());
  }
  
  public ContainerMetricsBuilder(ContainerMetricsFluent<?> fluent) {
    this(fluent, new ContainerMetrics());
  }
  
  public ContainerMetricsBuilder(ContainerMetrics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerMetricsBuilder(ContainerMetricsFluent<?> fluent,ContainerMetrics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerMetrics build() {
    ContainerMetrics buildable = new ContainerMetrics(fluent.getName(), fluent.getUsage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}