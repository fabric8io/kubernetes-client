package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusRuleSpecBuilder extends PrometheusRuleSpecFluent<PrometheusRuleSpecBuilder> implements VisitableBuilder<PrometheusRuleSpec,PrometheusRuleSpecBuilder>{

  PrometheusRuleSpecFluent<?> fluent;

  public PrometheusRuleSpecBuilder() {
    this(new PrometheusRuleSpec());
  }
  
  public PrometheusRuleSpecBuilder(PrometheusRuleSpecFluent<?> fluent) {
    this(fluent, new PrometheusRuleSpec());
  }
  
  public PrometheusRuleSpecBuilder(PrometheusRuleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusRuleSpecBuilder(PrometheusRuleSpecFluent<?> fluent,PrometheusRuleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusRuleSpec build() {
    PrometheusRuleSpec buildable = new PrometheusRuleSpec(fluent.buildGroups());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}