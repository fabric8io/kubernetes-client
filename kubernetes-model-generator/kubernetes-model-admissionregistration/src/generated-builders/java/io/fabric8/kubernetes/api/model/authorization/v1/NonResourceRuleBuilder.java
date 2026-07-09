package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NonResourceRuleBuilder extends NonResourceRuleFluent<NonResourceRuleBuilder> implements VisitableBuilder<NonResourceRule,NonResourceRuleBuilder>{

  NonResourceRuleFluent<?> fluent;

  public NonResourceRuleBuilder() {
    this(new NonResourceRule());
  }
  
  public NonResourceRuleBuilder(NonResourceRuleFluent<?> fluent) {
    this(fluent, new NonResourceRule());
  }
  
  public NonResourceRuleBuilder(NonResourceRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NonResourceRuleBuilder(NonResourceRuleFluent<?> fluent,NonResourceRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NonResourceRule build() {
    NonResourceRule buildable = new NonResourceRule(fluent.getNonResourceURLs(), fluent.getVerbs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}