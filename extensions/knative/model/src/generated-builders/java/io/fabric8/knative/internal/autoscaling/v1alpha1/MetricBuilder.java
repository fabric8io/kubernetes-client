package io.fabric8.knative.internal.autoscaling.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricBuilder extends MetricFluent<MetricBuilder> implements VisitableBuilder<Metric,MetricBuilder>{

  MetricFluent<?> fluent;

  public MetricBuilder() {
    this(new Metric());
  }
  
  public MetricBuilder(MetricFluent<?> fluent) {
    this(fluent, new Metric());
  }
  
  public MetricBuilder(Metric instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricBuilder(MetricFluent<?> fluent,Metric instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metric build() {
    Metric buildable = new Metric(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}