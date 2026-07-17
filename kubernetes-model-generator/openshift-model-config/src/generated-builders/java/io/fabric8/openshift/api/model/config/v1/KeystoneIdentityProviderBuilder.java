package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KeystoneIdentityProviderBuilder extends KeystoneIdentityProviderFluent<KeystoneIdentityProviderBuilder> implements VisitableBuilder<KeystoneIdentityProvider,KeystoneIdentityProviderBuilder>{

  KeystoneIdentityProviderFluent<?> fluent;

  public KeystoneIdentityProviderBuilder() {
    this(new KeystoneIdentityProvider());
  }
  
  public KeystoneIdentityProviderBuilder(KeystoneIdentityProviderFluent<?> fluent) {
    this(fluent, new KeystoneIdentityProvider());
  }
  
  public KeystoneIdentityProviderBuilder(KeystoneIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KeystoneIdentityProviderBuilder(KeystoneIdentityProviderFluent<?> fluent,KeystoneIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KeystoneIdentityProvider build() {
    KeystoneIdentityProvider buildable = new KeystoneIdentityProvider(fluent.buildCa(), fluent.getDomainName(), fluent.buildTlsClientCert(), fluent.buildTlsClientKey(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}