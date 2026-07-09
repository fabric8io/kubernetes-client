package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyRuleBuilder extends PolicyRuleFluent<PolicyRuleBuilder> implements VisitableBuilder<PolicyRule,PolicyRuleBuilder>{

  PolicyRuleFluent<?> fluent;

  public PolicyRuleBuilder() {
    this(new PolicyRule());
  }
  
  public PolicyRuleBuilder(PolicyRuleFluent<?> fluent) {
    this(fluent, new PolicyRule());
  }
  
  public PolicyRuleBuilder(PolicyRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyRuleBuilder(PolicyRuleFluent<?> fluent,PolicyRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyRule build() {
    PolicyRule buildable = new PolicyRule(fluent.getApiGroups(), fluent.getNonResourceURLs(), fluent.getResourceNames(), fluent.getResources(), fluent.getVerbs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}