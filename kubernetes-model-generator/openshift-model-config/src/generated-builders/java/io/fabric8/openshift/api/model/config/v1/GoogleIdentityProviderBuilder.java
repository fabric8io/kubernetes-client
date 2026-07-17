package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GoogleIdentityProviderBuilder extends GoogleIdentityProviderFluent<GoogleIdentityProviderBuilder> implements VisitableBuilder<GoogleIdentityProvider,GoogleIdentityProviderBuilder>{

  GoogleIdentityProviderFluent<?> fluent;

  public GoogleIdentityProviderBuilder() {
    this(new GoogleIdentityProvider());
  }
  
  public GoogleIdentityProviderBuilder(GoogleIdentityProviderFluent<?> fluent) {
    this(fluent, new GoogleIdentityProvider());
  }
  
  public GoogleIdentityProviderBuilder(GoogleIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GoogleIdentityProviderBuilder(GoogleIdentityProviderFluent<?> fluent,GoogleIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GoogleIdentityProvider build() {
    GoogleIdentityProvider buildable = new GoogleIdentityProvider(fluent.getClientID(), fluent.buildClientSecret(), fluent.getHostedDomain());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}