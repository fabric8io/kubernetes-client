package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenRequestBuilder extends TokenRequestFluent<TokenRequestBuilder> implements VisitableBuilder<TokenRequest,TokenRequestBuilder>{

  TokenRequestFluent<?> fluent;

  public TokenRequestBuilder() {
    this(new TokenRequest());
  }
  
  public TokenRequestBuilder(TokenRequestFluent<?> fluent) {
    this(fluent, new TokenRequest());
  }
  
  public TokenRequestBuilder(TokenRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenRequestBuilder(TokenRequestFluent<?> fluent,TokenRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenRequest build() {
    TokenRequest buildable = new TokenRequest(fluent.getAudience(), fluent.getExpirationSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}