package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenRequiredClaimBuilder extends TokenRequiredClaimFluent<TokenRequiredClaimBuilder> implements VisitableBuilder<TokenRequiredClaim,TokenRequiredClaimBuilder>{

  TokenRequiredClaimFluent<?> fluent;

  public TokenRequiredClaimBuilder() {
    this(new TokenRequiredClaim());
  }
  
  public TokenRequiredClaimBuilder(TokenRequiredClaimFluent<?> fluent) {
    this(fluent, new TokenRequiredClaim());
  }
  
  public TokenRequiredClaimBuilder(TokenRequiredClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenRequiredClaimBuilder(TokenRequiredClaimFluent<?> fluent,TokenRequiredClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenRequiredClaim build() {
    TokenRequiredClaim buildable = new TokenRequiredClaim(fluent.getClaim(), fluent.getRequiredValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}