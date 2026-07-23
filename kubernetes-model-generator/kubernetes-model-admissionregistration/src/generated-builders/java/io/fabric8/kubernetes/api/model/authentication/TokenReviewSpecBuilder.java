package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenReviewSpecBuilder extends TokenReviewSpecFluent<TokenReviewSpecBuilder> implements VisitableBuilder<TokenReviewSpec,TokenReviewSpecBuilder>{

  TokenReviewSpecFluent<?> fluent;

  public TokenReviewSpecBuilder() {
    this(new TokenReviewSpec());
  }
  
  public TokenReviewSpecBuilder(TokenReviewSpecFluent<?> fluent) {
    this(fluent, new TokenReviewSpec());
  }
  
  public TokenReviewSpecBuilder(TokenReviewSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenReviewSpecBuilder(TokenReviewSpecFluent<?> fluent,TokenReviewSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenReviewSpec build() {
    TokenReviewSpec buildable = new TokenReviewSpec(fluent.getAudiences(), fluent.getToken());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}