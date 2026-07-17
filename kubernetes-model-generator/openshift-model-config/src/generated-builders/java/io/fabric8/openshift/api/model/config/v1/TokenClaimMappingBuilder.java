package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenClaimMappingBuilder extends TokenClaimMappingFluent<TokenClaimMappingBuilder> implements VisitableBuilder<TokenClaimMapping,TokenClaimMappingBuilder>{

  TokenClaimMappingFluent<?> fluent;

  public TokenClaimMappingBuilder() {
    this(new TokenClaimMapping());
  }
  
  public TokenClaimMappingBuilder(TokenClaimMappingFluent<?> fluent) {
    this(fluent, new TokenClaimMapping());
  }
  
  public TokenClaimMappingBuilder(TokenClaimMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenClaimMappingBuilder(TokenClaimMappingFluent<?> fluent,TokenClaimMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenClaimMapping build() {
    TokenClaimMapping buildable = new TokenClaimMapping(fluent.getClaim());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}