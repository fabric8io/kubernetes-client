package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthProviderConfigBuilder extends AuthProviderConfigFluent<AuthProviderConfigBuilder> implements VisitableBuilder<AuthProviderConfig,AuthProviderConfigBuilder>{

  AuthProviderConfigFluent<?> fluent;

  public AuthProviderConfigBuilder() {
    this(new AuthProviderConfig());
  }
  
  public AuthProviderConfigBuilder(AuthProviderConfigFluent<?> fluent) {
    this(fluent, new AuthProviderConfig());
  }
  
  public AuthProviderConfigBuilder(AuthProviderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthProviderConfigBuilder(AuthProviderConfigFluent<?> fluent,AuthProviderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthProviderConfig build() {
    AuthProviderConfig buildable = new AuthProviderConfig(fluent.getConfig(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}