package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenRequestStatusBuilder extends TokenRequestStatusFluent<TokenRequestStatusBuilder> implements VisitableBuilder<TokenRequestStatus,TokenRequestStatusBuilder>{

  TokenRequestStatusFluent<?> fluent;

  public TokenRequestStatusBuilder() {
    this(new TokenRequestStatus());
  }
  
  public TokenRequestStatusBuilder(TokenRequestStatusFluent<?> fluent) {
    this(fluent, new TokenRequestStatus());
  }
  
  public TokenRequestStatusBuilder(TokenRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenRequestStatusBuilder(TokenRequestStatusFluent<?> fluent,TokenRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenRequestStatus build() {
    TokenRequestStatus buildable = new TokenRequestStatus(fluent.getExpirationTimestamp(), fluent.getToken());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}