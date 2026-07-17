package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BasicAuthIdentityProviderBuilder extends BasicAuthIdentityProviderFluent<BasicAuthIdentityProviderBuilder> implements VisitableBuilder<BasicAuthIdentityProvider,BasicAuthIdentityProviderBuilder>{

  BasicAuthIdentityProviderFluent<?> fluent;

  public BasicAuthIdentityProviderBuilder() {
    this(new BasicAuthIdentityProvider());
  }
  
  public BasicAuthIdentityProviderBuilder(BasicAuthIdentityProviderFluent<?> fluent) {
    this(fluent, new BasicAuthIdentityProvider());
  }
  
  public BasicAuthIdentityProviderBuilder(BasicAuthIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BasicAuthIdentityProviderBuilder(BasicAuthIdentityProviderFluent<?> fluent,BasicAuthIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BasicAuthIdentityProvider build() {
    BasicAuthIdentityProvider buildable = new BasicAuthIdentityProvider(fluent.buildCa(), fluent.buildTlsClientCert(), fluent.buildTlsClientKey(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}