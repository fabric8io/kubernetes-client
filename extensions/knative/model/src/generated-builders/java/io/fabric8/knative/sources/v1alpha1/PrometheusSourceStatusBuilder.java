package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusSourceStatusBuilder extends PrometheusSourceStatusFluent<PrometheusSourceStatusBuilder> implements VisitableBuilder<PrometheusSourceStatus,PrometheusSourceStatusBuilder>{

  PrometheusSourceStatusFluent<?> fluent;

  public PrometheusSourceStatusBuilder() {
    this(new PrometheusSourceStatus());
  }
  
  public PrometheusSourceStatusBuilder(PrometheusSourceStatusFluent<?> fluent) {
    this(fluent, new PrometheusSourceStatus());
  }
  
  public PrometheusSourceStatusBuilder(PrometheusSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusSourceStatusBuilder(PrometheusSourceStatusFluent<?> fluent,PrometheusSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusSourceStatus build() {
    PrometheusSourceStatus buildable = new PrometheusSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}