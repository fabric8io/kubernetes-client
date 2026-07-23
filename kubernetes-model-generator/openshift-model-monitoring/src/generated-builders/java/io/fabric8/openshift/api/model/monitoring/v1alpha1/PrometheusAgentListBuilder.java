package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusAgentListBuilder extends PrometheusAgentListFluent<PrometheusAgentListBuilder> implements VisitableBuilder<PrometheusAgentList,PrometheusAgentListBuilder>{

  PrometheusAgentListFluent<?> fluent;

  public PrometheusAgentListBuilder() {
    this(new PrometheusAgentList());
  }
  
  public PrometheusAgentListBuilder(PrometheusAgentListFluent<?> fluent) {
    this(fluent, new PrometheusAgentList());
  }
  
  public PrometheusAgentListBuilder(PrometheusAgentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusAgentListBuilder(PrometheusAgentListFluent<?> fluent,PrometheusAgentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusAgentList build() {
    PrometheusAgentList buildable = new PrometheusAgentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}