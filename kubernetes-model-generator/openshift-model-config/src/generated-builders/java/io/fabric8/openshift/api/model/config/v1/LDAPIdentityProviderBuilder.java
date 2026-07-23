package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LDAPIdentityProviderBuilder extends LDAPIdentityProviderFluent<LDAPIdentityProviderBuilder> implements VisitableBuilder<LDAPIdentityProvider,LDAPIdentityProviderBuilder>{

  LDAPIdentityProviderFluent<?> fluent;

  public LDAPIdentityProviderBuilder() {
    this(new LDAPIdentityProvider());
  }
  
  public LDAPIdentityProviderBuilder(LDAPIdentityProviderFluent<?> fluent) {
    this(fluent, new LDAPIdentityProvider());
  }
  
  public LDAPIdentityProviderBuilder(LDAPIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LDAPIdentityProviderBuilder(LDAPIdentityProviderFluent<?> fluent,LDAPIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LDAPIdentityProvider build() {
    LDAPIdentityProvider buildable = new LDAPIdentityProvider(fluent.buildAttributes(), fluent.getBindDN(), fluent.buildBindPassword(), fluent.buildCa(), fluent.getInsecure(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}