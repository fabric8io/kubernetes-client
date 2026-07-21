package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusSourceSpecBuilder extends PrometheusSourceSpecFluent<PrometheusSourceSpecBuilder> implements VisitableBuilder<PrometheusSourceSpec,PrometheusSourceSpecBuilder>{

  PrometheusSourceSpecFluent<?> fluent;

  public PrometheusSourceSpecBuilder() {
    this(new PrometheusSourceSpec());
  }
  
  public PrometheusSourceSpecBuilder(PrometheusSourceSpecFluent<?> fluent) {
    this(fluent, new PrometheusSourceSpec());
  }
  
  public PrometheusSourceSpecBuilder(PrometheusSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusSourceSpecBuilder(PrometheusSourceSpecFluent<?> fluent,PrometheusSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusSourceSpec build() {
    PrometheusSourceSpec buildable = new PrometheusSourceSpec(fluent.getAuthTokenFile(), fluent.getCaCertConfigMap(), fluent.getPromQL(), fluent.getSchedule(), fluent.getServerURL(), fluent.getServiceAccountName(), fluent.buildSink(), fluent.getStep());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}