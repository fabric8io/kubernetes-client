package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenClaimOrExpressionMappingBuilder extends TokenClaimOrExpressionMappingFluent<TokenClaimOrExpressionMappingBuilder> implements VisitableBuilder<TokenClaimOrExpressionMapping,TokenClaimOrExpressionMappingBuilder>{

  TokenClaimOrExpressionMappingFluent<?> fluent;

  public TokenClaimOrExpressionMappingBuilder() {
    this(new TokenClaimOrExpressionMapping());
  }
  
  public TokenClaimOrExpressionMappingBuilder(TokenClaimOrExpressionMappingFluent<?> fluent) {
    this(fluent, new TokenClaimOrExpressionMapping());
  }
  
  public TokenClaimOrExpressionMappingBuilder(TokenClaimOrExpressionMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenClaimOrExpressionMappingBuilder(TokenClaimOrExpressionMappingFluent<?> fluent,TokenClaimOrExpressionMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenClaimOrExpressionMapping build() {
    TokenClaimOrExpressionMapping buildable = new TokenClaimOrExpressionMapping(fluent.getClaim(), fluent.getExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}