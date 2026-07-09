package io.fabric8.kubernetes.api.model.authentication.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenReviewStatusBuilder extends TokenReviewStatusFluent<TokenReviewStatusBuilder> implements VisitableBuilder<TokenReviewStatus,TokenReviewStatusBuilder>{

  TokenReviewStatusFluent<?> fluent;

  public TokenReviewStatusBuilder() {
    this(new TokenReviewStatus());
  }
  
  public TokenReviewStatusBuilder(TokenReviewStatusFluent<?> fluent) {
    this(fluent, new TokenReviewStatus());
  }
  
  public TokenReviewStatusBuilder(TokenReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenReviewStatusBuilder(TokenReviewStatusFluent<?> fluent,TokenReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenReviewStatus build() {
    TokenReviewStatus buildable = new TokenReviewStatus(fluent.getAudiences(), fluent.getAuthenticated(), fluent.getError(), fluent.buildUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}