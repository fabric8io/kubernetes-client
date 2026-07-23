package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthStatusBuilder extends AuthStatusFluent<AuthStatusBuilder> implements VisitableBuilder<AuthStatus,AuthStatusBuilder>{

  AuthStatusFluent<?> fluent;

  public AuthStatusBuilder() {
    this(new AuthStatus());
  }
  
  public AuthStatusBuilder(AuthStatusFluent<?> fluent) {
    this(fluent, new AuthStatus());
  }
  
  public AuthStatusBuilder(AuthStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthStatusBuilder(AuthStatusFluent<?> fluent,AuthStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthStatus build() {
    AuthStatus buildable = new AuthStatus(fluent.getServiceAccountName(), fluent.getServiceAccountNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}