package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusRuleExcludeConfigBuilder extends PrometheusRuleExcludeConfigFluent<PrometheusRuleExcludeConfigBuilder> implements VisitableBuilder<PrometheusRuleExcludeConfig,PrometheusRuleExcludeConfigBuilder>{

  PrometheusRuleExcludeConfigFluent<?> fluent;

  public PrometheusRuleExcludeConfigBuilder() {
    this(new PrometheusRuleExcludeConfig());
  }
  
  public PrometheusRuleExcludeConfigBuilder(PrometheusRuleExcludeConfigFluent<?> fluent) {
    this(fluent, new PrometheusRuleExcludeConfig());
  }
  
  public PrometheusRuleExcludeConfigBuilder(PrometheusRuleExcludeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusRuleExcludeConfigBuilder(PrometheusRuleExcludeConfigFluent<?> fluent,PrometheusRuleExcludeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusRuleExcludeConfig build() {
    PrometheusRuleExcludeConfig buildable = new PrometheusRuleExcludeConfig(fluent.getRuleName(), fluent.getRuleNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}