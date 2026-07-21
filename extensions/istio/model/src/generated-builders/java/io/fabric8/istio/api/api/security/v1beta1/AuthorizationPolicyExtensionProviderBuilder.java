package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthorizationPolicyExtensionProviderBuilder extends AuthorizationPolicyExtensionProviderFluent<AuthorizationPolicyExtensionProviderBuilder> implements VisitableBuilder<AuthorizationPolicyExtensionProvider,AuthorizationPolicyExtensionProviderBuilder>{

  AuthorizationPolicyExtensionProviderFluent<?> fluent;

  public AuthorizationPolicyExtensionProviderBuilder() {
    this(new AuthorizationPolicyExtensionProvider());
  }
  
  public AuthorizationPolicyExtensionProviderBuilder(AuthorizationPolicyExtensionProviderFluent<?> fluent) {
    this(fluent, new AuthorizationPolicyExtensionProvider());
  }
  
  public AuthorizationPolicyExtensionProviderBuilder(AuthorizationPolicyExtensionProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthorizationPolicyExtensionProviderBuilder(AuthorizationPolicyExtensionProviderFluent<?> fluent,AuthorizationPolicyExtensionProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthorizationPolicyExtensionProvider build() {
    AuthorizationPolicyExtensionProvider buildable = new AuthorizationPolicyExtensionProvider(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}