package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusBuilder extends PrometheusFluent<PrometheusBuilder> implements VisitableBuilder<Prometheus,PrometheusBuilder>{

  PrometheusFluent<?> fluent;

  public PrometheusBuilder() {
    this(new Prometheus());
  }
  
  public PrometheusBuilder(PrometheusFluent<?> fluent) {
    this(fluent, new Prometheus());
  }
  
  public PrometheusBuilder(Prometheus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusBuilder(PrometheusFluent<?> fluent,Prometheus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Prometheus build() {
    Prometheus buildable = new Prometheus(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}