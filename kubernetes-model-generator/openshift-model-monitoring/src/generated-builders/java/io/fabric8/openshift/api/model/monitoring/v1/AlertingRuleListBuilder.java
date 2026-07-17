package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertingRuleListBuilder extends AlertingRuleListFluent<AlertingRuleListBuilder> implements VisitableBuilder<AlertingRuleList,AlertingRuleListBuilder>{

  AlertingRuleListFluent<?> fluent;

  public AlertingRuleListBuilder() {
    this(new AlertingRuleList());
  }
  
  public AlertingRuleListBuilder(AlertingRuleListFluent<?> fluent) {
    this(fluent, new AlertingRuleList());
  }
  
  public AlertingRuleListBuilder(AlertingRuleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertingRuleListBuilder(AlertingRuleListFluent<?> fluent,AlertingRuleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertingRuleList build() {
    AlertingRuleList buildable = new AlertingRuleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}