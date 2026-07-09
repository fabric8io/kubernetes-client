package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodMetricsListBuilder extends PodMetricsListFluent<PodMetricsListBuilder> implements VisitableBuilder<PodMetricsList,PodMetricsListBuilder>{

  PodMetricsListFluent<?> fluent;

  public PodMetricsListBuilder() {
    this(new PodMetricsList());
  }
  
  public PodMetricsListBuilder(PodMetricsListFluent<?> fluent) {
    this(fluent, new PodMetricsList());
  }
  
  public PodMetricsListBuilder(PodMetricsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodMetricsListBuilder(PodMetricsListFluent<?> fluent,PodMetricsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodMetricsList build() {
    PodMetricsList buildable = new PodMetricsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}