package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenIssuerBuilder extends TokenIssuerFluent<TokenIssuerBuilder> implements VisitableBuilder<TokenIssuer,TokenIssuerBuilder>{

  TokenIssuerFluent<?> fluent;

  public TokenIssuerBuilder() {
    this(new TokenIssuer());
  }
  
  public TokenIssuerBuilder(TokenIssuerFluent<?> fluent) {
    this(fluent, new TokenIssuer());
  }
  
  public TokenIssuerBuilder(TokenIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenIssuerBuilder(TokenIssuerFluent<?> fluent,TokenIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenIssuer build() {
    TokenIssuer buildable = new TokenIssuer(fluent.getAudiences(), fluent.buildIssuerCertificateAuthority(), fluent.getIssuerURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}