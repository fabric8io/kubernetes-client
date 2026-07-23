package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthorizationPolicyProviderBuilder extends AuthorizationPolicyProviderFluent<AuthorizationPolicyProviderBuilder> implements VisitableBuilder<AuthorizationPolicyProvider,AuthorizationPolicyProviderBuilder>{

  AuthorizationPolicyProviderFluent<?> fluent;

  public AuthorizationPolicyProviderBuilder() {
    this(new AuthorizationPolicyProvider());
  }
  
  public AuthorizationPolicyProviderBuilder(AuthorizationPolicyProviderFluent<?> fluent) {
    this(fluent, new AuthorizationPolicyProvider());
  }
  
  public AuthorizationPolicyProviderBuilder(AuthorizationPolicyProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthorizationPolicyProviderBuilder(AuthorizationPolicyProviderFluent<?> fluent,AuthorizationPolicyProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthorizationPolicyProvider build() {
    AuthorizationPolicyProvider buildable = new AuthorizationPolicyProvider(fluent.buildProvider());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}