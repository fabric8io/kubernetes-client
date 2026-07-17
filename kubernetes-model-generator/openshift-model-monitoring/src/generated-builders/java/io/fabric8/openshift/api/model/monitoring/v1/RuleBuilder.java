package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuleBuilder extends RuleFluent<RuleBuilder> implements VisitableBuilder<Rule,RuleBuilder>{

  RuleFluent<?> fluent;

  public RuleBuilder() {
    this(new Rule());
  }
  
  public RuleBuilder(RuleFluent<?> fluent) {
    this(fluent, new Rule());
  }
  
  public RuleBuilder(Rule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuleBuilder(RuleFluent<?> fluent,Rule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Rule build() {
    Rule buildable = new Rule(fluent.getAlert(), fluent.getAnnotations(), fluent.buildExpr(), fluent.getFor(), fluent.getKeepFiringFor(), fluent.getLabels(), fluent.getRecord());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}