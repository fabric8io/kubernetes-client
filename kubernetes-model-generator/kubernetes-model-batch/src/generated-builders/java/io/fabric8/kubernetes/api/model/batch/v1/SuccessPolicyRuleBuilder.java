package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SuccessPolicyRuleBuilder extends SuccessPolicyRuleFluent<SuccessPolicyRuleBuilder> implements VisitableBuilder<SuccessPolicyRule,SuccessPolicyRuleBuilder>{

  SuccessPolicyRuleFluent<?> fluent;

  public SuccessPolicyRuleBuilder() {
    this(new SuccessPolicyRule());
  }
  
  public SuccessPolicyRuleBuilder(SuccessPolicyRuleFluent<?> fluent) {
    this(fluent, new SuccessPolicyRule());
  }
  
  public SuccessPolicyRuleBuilder(SuccessPolicyRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SuccessPolicyRuleBuilder(SuccessPolicyRuleFluent<?> fluent,SuccessPolicyRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SuccessPolicyRule build() {
    SuccessPolicyRule buildable = new SuccessPolicyRule(fluent.getSucceededCount(), fluent.getSucceededIndexes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}