package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertingRuleStatusBuilder extends AlertingRuleStatusFluent<AlertingRuleStatusBuilder> implements VisitableBuilder<AlertingRuleStatus,AlertingRuleStatusBuilder>{

  AlertingRuleStatusFluent<?> fluent;

  public AlertingRuleStatusBuilder() {
    this(new AlertingRuleStatus());
  }
  
  public AlertingRuleStatusBuilder(AlertingRuleStatusFluent<?> fluent) {
    this(fluent, new AlertingRuleStatus());
  }
  
  public AlertingRuleStatusBuilder(AlertingRuleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertingRuleStatusBuilder(AlertingRuleStatusFluent<?> fluent,AlertingRuleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertingRuleStatus build() {
    AlertingRuleStatus buildable = new AlertingRuleStatus(fluent.getObservedGeneration(), fluent.buildPrometheusRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}