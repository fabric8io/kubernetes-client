package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NonResourcePolicyRuleBuilder extends NonResourcePolicyRuleFluent<NonResourcePolicyRuleBuilder> implements VisitableBuilder<NonResourcePolicyRule,NonResourcePolicyRuleBuilder>{

  NonResourcePolicyRuleFluent<?> fluent;

  public NonResourcePolicyRuleBuilder() {
    this(new NonResourcePolicyRule());
  }
  
  public NonResourcePolicyRuleBuilder(NonResourcePolicyRuleFluent<?> fluent) {
    this(fluent, new NonResourcePolicyRule());
  }
  
  public NonResourcePolicyRuleBuilder(NonResourcePolicyRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NonResourcePolicyRuleBuilder(NonResourcePolicyRuleFluent<?> fluent,NonResourcePolicyRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NonResourcePolicyRule build() {
    NonResourcePolicyRule buildable = new NonResourcePolicyRule(fluent.getNonResourceURLs(), fluent.getVerbs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}