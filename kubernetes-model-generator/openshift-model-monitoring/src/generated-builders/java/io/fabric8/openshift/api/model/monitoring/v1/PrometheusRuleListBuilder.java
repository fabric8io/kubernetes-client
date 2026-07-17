package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusRuleListBuilder extends PrometheusRuleListFluent<PrometheusRuleListBuilder> implements VisitableBuilder<PrometheusRuleList,PrometheusRuleListBuilder>{

  PrometheusRuleListFluent<?> fluent;

  public PrometheusRuleListBuilder() {
    this(new PrometheusRuleList());
  }
  
  public PrometheusRuleListBuilder(PrometheusRuleListFluent<?> fluent) {
    this(fluent, new PrometheusRuleList());
  }
  
  public PrometheusRuleListBuilder(PrometheusRuleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusRuleListBuilder(PrometheusRuleListFluent<?> fluent,PrometheusRuleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusRuleList build() {
    PrometheusRuleList buildable = new PrometheusRuleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}