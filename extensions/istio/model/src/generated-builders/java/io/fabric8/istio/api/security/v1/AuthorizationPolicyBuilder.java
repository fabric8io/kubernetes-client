package io.fabric8.istio.api.security.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthorizationPolicyBuilder extends AuthorizationPolicyFluent<AuthorizationPolicyBuilder> implements VisitableBuilder<AuthorizationPolicy,AuthorizationPolicyBuilder>{

  AuthorizationPolicyFluent<?> fluent;

  public AuthorizationPolicyBuilder() {
    this(new AuthorizationPolicy());
  }
  
  public AuthorizationPolicyBuilder(AuthorizationPolicyFluent<?> fluent) {
    this(fluent, new AuthorizationPolicy());
  }
  
  public AuthorizationPolicyBuilder(AuthorizationPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthorizationPolicyBuilder(AuthorizationPolicyFluent<?> fluent,AuthorizationPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthorizationPolicy build() {
    AuthorizationPolicy buildable = new AuthorizationPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}