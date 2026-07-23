package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AggregationRuleBuilder extends AggregationRuleFluent<AggregationRuleBuilder> implements VisitableBuilder<AggregationRule,AggregationRuleBuilder>{

  AggregationRuleFluent<?> fluent;

  public AggregationRuleBuilder() {
    this(new AggregationRule());
  }
  
  public AggregationRuleBuilder(AggregationRuleFluent<?> fluent) {
    this(fluent, new AggregationRule());
  }
  
  public AggregationRuleBuilder(AggregationRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AggregationRuleBuilder(AggregationRuleFluent<?> fluent,AggregationRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AggregationRule build() {
    AggregationRule buildable = new AggregationRule(fluent.buildClusterRoleSelectors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}