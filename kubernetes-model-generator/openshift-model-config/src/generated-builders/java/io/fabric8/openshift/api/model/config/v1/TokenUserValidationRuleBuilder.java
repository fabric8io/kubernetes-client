package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenUserValidationRuleBuilder extends TokenUserValidationRuleFluent<TokenUserValidationRuleBuilder> implements VisitableBuilder<TokenUserValidationRule,TokenUserValidationRuleBuilder>{

  TokenUserValidationRuleFluent<?> fluent;

  public TokenUserValidationRuleBuilder() {
    this(new TokenUserValidationRule());
  }
  
  public TokenUserValidationRuleBuilder(TokenUserValidationRuleFluent<?> fluent) {
    this(fluent, new TokenUserValidationRule());
  }
  
  public TokenUserValidationRuleBuilder(TokenUserValidationRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenUserValidationRuleBuilder(TokenUserValidationRuleFluent<?> fluent,TokenUserValidationRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenUserValidationRule build() {
    TokenUserValidationRule buildable = new TokenUserValidationRule(fluent.getExpression(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}