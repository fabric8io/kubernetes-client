package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticationStatusBuilder extends AuthenticationStatusFluent<AuthenticationStatusBuilder> implements VisitableBuilder<AuthenticationStatus,AuthenticationStatusBuilder>{

  AuthenticationStatusFluent<?> fluent;

  public AuthenticationStatusBuilder() {
    this(new AuthenticationStatus());
  }
  
  public AuthenticationStatusBuilder(AuthenticationStatusFluent<?> fluent) {
    this(fluent, new AuthenticationStatus());
  }
  
  public AuthenticationStatusBuilder(AuthenticationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticationStatusBuilder(AuthenticationStatusFluent<?> fluent,AuthenticationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthenticationStatus build() {
    AuthenticationStatus buildable = new AuthenticationStatus(fluent.buildIntegratedOAuthMetadata(), fluent.buildOidcClients());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}