package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusRuleBuilder extends PrometheusRuleFluent<PrometheusRuleBuilder> implements VisitableBuilder<PrometheusRule,PrometheusRuleBuilder>{

  PrometheusRuleFluent<?> fluent;

  public PrometheusRuleBuilder() {
    this(new PrometheusRule());
  }
  
  public PrometheusRuleBuilder(PrometheusRuleFluent<?> fluent) {
    this(fluent, new PrometheusRule());
  }
  
  public PrometheusRuleBuilder(PrometheusRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusRuleBuilder(PrometheusRuleFluent<?> fluent,PrometheusRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusRule build() {
    PrometheusRule buildable = new PrometheusRule(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}