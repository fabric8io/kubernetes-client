package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenConfigBuilder extends TokenConfigFluent<TokenConfigBuilder> implements VisitableBuilder<TokenConfig,TokenConfigBuilder>{

  TokenConfigFluent<?> fluent;

  public TokenConfigBuilder() {
    this(new TokenConfig());
  }
  
  public TokenConfigBuilder(TokenConfigFluent<?> fluent) {
    this(fluent, new TokenConfig());
  }
  
  public TokenConfigBuilder(TokenConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenConfigBuilder(TokenConfigFluent<?> fluent,TokenConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenConfig build() {
    TokenConfig buildable = new TokenConfig(fluent.getExpirationSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}