package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenReviewBuilder extends TokenReviewFluent<TokenReviewBuilder> implements VisitableBuilder<TokenReview,TokenReviewBuilder>{

  TokenReviewFluent<?> fluent;

  public TokenReviewBuilder() {
    this(new TokenReview());
  }
  
  public TokenReviewBuilder(TokenReviewFluent<?> fluent) {
    this(fluent, new TokenReview());
  }
  
  public TokenReviewBuilder(TokenReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenReviewBuilder(TokenReviewFluent<?> fluent,TokenReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenReview build() {
    TokenReview buildable = new TokenReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}