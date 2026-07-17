package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusRuleRefBuilder extends PrometheusRuleRefFluent<PrometheusRuleRefBuilder> implements VisitableBuilder<PrometheusRuleRef,PrometheusRuleRefBuilder>{

  PrometheusRuleRefFluent<?> fluent;

  public PrometheusRuleRefBuilder() {
    this(new PrometheusRuleRef());
  }
  
  public PrometheusRuleRefBuilder(PrometheusRuleRefFluent<?> fluent) {
    this(fluent, new PrometheusRuleRef());
  }
  
  public PrometheusRuleRefBuilder(PrometheusRuleRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusRuleRefBuilder(PrometheusRuleRefFluent<?> fluent,PrometheusRuleRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusRuleRef build() {
    PrometheusRuleRef buildable = new PrometheusRuleRef(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}