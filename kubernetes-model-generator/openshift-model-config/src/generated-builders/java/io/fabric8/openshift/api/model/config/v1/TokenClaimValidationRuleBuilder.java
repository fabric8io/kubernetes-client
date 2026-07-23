package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenClaimValidationRuleBuilder extends TokenClaimValidationRuleFluent<TokenClaimValidationRuleBuilder> implements VisitableBuilder<TokenClaimValidationRule,TokenClaimValidationRuleBuilder>{

  TokenClaimValidationRuleFluent<?> fluent;

  public TokenClaimValidationRuleBuilder() {
    this(new TokenClaimValidationRule());
  }
  
  public TokenClaimValidationRuleBuilder(TokenClaimValidationRuleFluent<?> fluent) {
    this(fluent, new TokenClaimValidationRule());
  }
  
  public TokenClaimValidationRuleBuilder(TokenClaimValidationRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenClaimValidationRuleBuilder(TokenClaimValidationRuleFluent<?> fluent,TokenClaimValidationRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenClaimValidationRule build() {
    TokenClaimValidationRule buildable = new TokenClaimValidationRule(fluent.buildRequiredClaim(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}