package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JWTRuleBuilder extends JWTRuleFluent<JWTRuleBuilder> implements VisitableBuilder<JWTRule,JWTRuleBuilder>{

  JWTRuleFluent<?> fluent;

  public JWTRuleBuilder() {
    this(new JWTRule());
  }
  
  public JWTRuleBuilder(JWTRuleFluent<?> fluent) {
    this(fluent, new JWTRule());
  }
  
  public JWTRuleBuilder(JWTRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JWTRuleBuilder(JWTRuleFluent<?> fluent,JWTRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JWTRule build() {
    JWTRule buildable = new JWTRule(fluent.getAudiences(), fluent.getForwardOriginalToken(), fluent.getFromCookies(), fluent.buildFromHeaders(), fluent.getFromParams(), fluent.getIssuer(), fluent.getJwks(), fluent.getJwksUri(), fluent.buildOutputClaimToHeaders(), fluent.getOutputPayloadToHeader(), fluent.getSpaceDelimitedClaims(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}