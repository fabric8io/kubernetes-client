package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenClaimValidationCELRuleBuilder extends TokenClaimValidationCELRuleFluent<TokenClaimValidationCELRuleBuilder> implements VisitableBuilder<TokenClaimValidationCELRule,TokenClaimValidationCELRuleBuilder>{

  TokenClaimValidationCELRuleFluent<?> fluent;

  public TokenClaimValidationCELRuleBuilder() {
    this(new TokenClaimValidationCELRule());
  }
  
  public TokenClaimValidationCELRuleBuilder(TokenClaimValidationCELRuleFluent<?> fluent) {
    this(fluent, new TokenClaimValidationCELRule());
  }
  
  public TokenClaimValidationCELRuleBuilder(TokenClaimValidationCELRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenClaimValidationCELRuleBuilder(TokenClaimValidationCELRuleFluent<?> fluent,TokenClaimValidationCELRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenClaimValidationCELRule build() {
    TokenClaimValidationCELRule buildable = new TokenClaimValidationCELRule(fluent.getExpression(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}