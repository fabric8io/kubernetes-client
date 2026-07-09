package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenRequestSpecBuilder extends TokenRequestSpecFluent<TokenRequestSpecBuilder> implements VisitableBuilder<TokenRequestSpec,TokenRequestSpecBuilder>{

  TokenRequestSpecFluent<?> fluent;

  public TokenRequestSpecBuilder() {
    this(new TokenRequestSpec());
  }
  
  public TokenRequestSpecBuilder(TokenRequestSpecFluent<?> fluent) {
    this(fluent, new TokenRequestSpec());
  }
  
  public TokenRequestSpecBuilder(TokenRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenRequestSpecBuilder(TokenRequestSpecFluent<?> fluent,TokenRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenRequestSpec build() {
    TokenRequestSpec buildable = new TokenRequestSpec(fluent.getAudiences(), fluent.buildBoundObjectRef(), fluent.getExpirationSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}