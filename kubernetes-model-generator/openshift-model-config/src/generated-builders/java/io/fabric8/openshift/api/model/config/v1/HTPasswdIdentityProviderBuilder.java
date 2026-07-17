package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTPasswdIdentityProviderBuilder extends HTPasswdIdentityProviderFluent<HTPasswdIdentityProviderBuilder> implements VisitableBuilder<HTPasswdIdentityProvider,HTPasswdIdentityProviderBuilder>{

  HTPasswdIdentityProviderFluent<?> fluent;

  public HTPasswdIdentityProviderBuilder() {
    this(new HTPasswdIdentityProvider());
  }
  
  public HTPasswdIdentityProviderBuilder(HTPasswdIdentityProviderFluent<?> fluent) {
    this(fluent, new HTPasswdIdentityProvider());
  }
  
  public HTPasswdIdentityProviderBuilder(HTPasswdIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTPasswdIdentityProviderBuilder(HTPasswdIdentityProviderFluent<?> fluent,HTPasswdIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTPasswdIdentityProvider build() {
    HTPasswdIdentityProvider buildable = new HTPasswdIdentityProvider(fluent.buildFileData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}