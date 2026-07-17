package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertingRuleBuilder extends AlertingRuleFluent<AlertingRuleBuilder> implements VisitableBuilder<AlertingRule,AlertingRuleBuilder>{

  AlertingRuleFluent<?> fluent;

  public AlertingRuleBuilder() {
    this(new AlertingRule());
  }
  
  public AlertingRuleBuilder(AlertingRuleFluent<?> fluent) {
    this(fluent, new AlertingRule());
  }
  
  public AlertingRuleBuilder(AlertingRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertingRuleBuilder(AlertingRuleFluent<?> fluent,AlertingRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertingRule build() {
    AlertingRule buildable = new AlertingRule(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}