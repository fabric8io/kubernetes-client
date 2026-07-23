package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricsBuilder extends MetricsFluent<MetricsBuilder> implements VisitableBuilder<Metrics,MetricsBuilder>{

  MetricsFluent<?> fluent;

  public MetricsBuilder() {
    this(new Metrics());
  }
  
  public MetricsBuilder(MetricsFluent<?> fluent) {
    this(fluent, new Metrics());
  }
  
  public MetricsBuilder(Metrics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricsBuilder(MetricsFluent<?> fluent,Metrics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metrics build() {
    Metrics buildable = new Metrics(fluent.buildOverrides(), fluent.buildProviders(), fluent.getReportingInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}