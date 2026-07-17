package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenIDIdentityProviderBuilder extends OpenIDIdentityProviderFluent<OpenIDIdentityProviderBuilder> implements VisitableBuilder<OpenIDIdentityProvider,OpenIDIdentityProviderBuilder>{

  OpenIDIdentityProviderFluent<?> fluent;

  public OpenIDIdentityProviderBuilder() {
    this(new OpenIDIdentityProvider());
  }
  
  public OpenIDIdentityProviderBuilder(OpenIDIdentityProviderFluent<?> fluent) {
    this(fluent, new OpenIDIdentityProvider());
  }
  
  public OpenIDIdentityProviderBuilder(OpenIDIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenIDIdentityProviderBuilder(OpenIDIdentityProviderFluent<?> fluent,OpenIDIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenIDIdentityProvider build() {
    OpenIDIdentityProvider buildable = new OpenIDIdentityProvider(fluent.buildCa(), fluent.buildClaims(), fluent.getClientID(), fluent.buildClientSecret(), fluent.getExtraAuthorizeParameters(), fluent.getExtraScopes(), fluent.getIssuer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}