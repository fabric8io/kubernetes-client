package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusSourceBuilder extends PrometheusSourceFluent<PrometheusSourceBuilder> implements VisitableBuilder<PrometheusSource,PrometheusSourceBuilder>{

  PrometheusSourceFluent<?> fluent;

  public PrometheusSourceBuilder() {
    this(new PrometheusSource());
  }
  
  public PrometheusSourceBuilder(PrometheusSourceFluent<?> fluent) {
    this(fluent, new PrometheusSource());
  }
  
  public PrometheusSourceBuilder(PrometheusSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusSourceBuilder(PrometheusSourceFluent<?> fluent,PrometheusSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusSource build() {
    PrometheusSource buildable = new PrometheusSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}