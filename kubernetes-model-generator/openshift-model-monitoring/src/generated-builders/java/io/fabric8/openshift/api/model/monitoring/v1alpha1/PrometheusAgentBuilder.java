package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusAgentBuilder extends PrometheusAgentFluent<PrometheusAgentBuilder> implements VisitableBuilder<PrometheusAgent,PrometheusAgentBuilder>{

  PrometheusAgentFluent<?> fluent;

  public PrometheusAgentBuilder() {
    this(new PrometheusAgent());
  }
  
  public PrometheusAgentBuilder(PrometheusAgentFluent<?> fluent) {
    this(fluent, new PrometheusAgent());
  }
  
  public PrometheusAgentBuilder(PrometheusAgent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusAgentBuilder(PrometheusAgentFluent<?> fluent,PrometheusAgent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusAgent build() {
    PrometheusAgent buildable = new PrometheusAgent(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}