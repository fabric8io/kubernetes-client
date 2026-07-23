package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestHeaderIdentityProviderBuilder extends RequestHeaderIdentityProviderFluent<RequestHeaderIdentityProviderBuilder> implements VisitableBuilder<RequestHeaderIdentityProvider,RequestHeaderIdentityProviderBuilder>{

  RequestHeaderIdentityProviderFluent<?> fluent;

  public RequestHeaderIdentityProviderBuilder() {
    this(new RequestHeaderIdentityProvider());
  }
  
  public RequestHeaderIdentityProviderBuilder(RequestHeaderIdentityProviderFluent<?> fluent) {
    this(fluent, new RequestHeaderIdentityProvider());
  }
  
  public RequestHeaderIdentityProviderBuilder(RequestHeaderIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestHeaderIdentityProviderBuilder(RequestHeaderIdentityProviderFluent<?> fluent,RequestHeaderIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestHeaderIdentityProvider build() {
    RequestHeaderIdentityProvider buildable = new RequestHeaderIdentityProvider(fluent.buildCa(), fluent.getChallengeURL(), fluent.getClientCommonNames(), fluent.getEmailHeaders(), fluent.getHeaders(), fluent.getLoginURL(), fluent.getNameHeaders(), fluent.getPreferredUsernameHeaders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}