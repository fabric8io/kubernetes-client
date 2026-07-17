package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusWebSpecBuilder extends PrometheusWebSpecFluent<PrometheusWebSpecBuilder> implements VisitableBuilder<PrometheusWebSpec,PrometheusWebSpecBuilder>{

  PrometheusWebSpecFluent<?> fluent;

  public PrometheusWebSpecBuilder() {
    this(new PrometheusWebSpec());
  }
  
  public PrometheusWebSpecBuilder(PrometheusWebSpecFluent<?> fluent) {
    this(fluent, new PrometheusWebSpec());
  }
  
  public PrometheusWebSpecBuilder(PrometheusWebSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusWebSpecBuilder(PrometheusWebSpecFluent<?> fluent,PrometheusWebSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusWebSpec build() {
    PrometheusWebSpec buildable = new PrometheusWebSpec(fluent.buildHttpConfig(), fluent.getMaxConnections(), fluent.getPageTitle(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}