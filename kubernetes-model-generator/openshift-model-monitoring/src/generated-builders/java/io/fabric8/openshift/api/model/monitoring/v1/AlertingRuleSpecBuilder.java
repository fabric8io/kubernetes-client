package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertingRuleSpecBuilder extends AlertingRuleSpecFluent<AlertingRuleSpecBuilder> implements VisitableBuilder<AlertingRuleSpec,AlertingRuleSpecBuilder>{

  AlertingRuleSpecFluent<?> fluent;

  public AlertingRuleSpecBuilder() {
    this(new AlertingRuleSpec());
  }
  
  public AlertingRuleSpecBuilder(AlertingRuleSpecFluent<?> fluent) {
    this(fluent, new AlertingRuleSpec());
  }
  
  public AlertingRuleSpecBuilder(AlertingRuleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertingRuleSpecBuilder(AlertingRuleSpecFluent<?> fluent,AlertingRuleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertingRuleSpec build() {
    AlertingRuleSpec buildable = new AlertingRuleSpec(fluent.buildGroups());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}