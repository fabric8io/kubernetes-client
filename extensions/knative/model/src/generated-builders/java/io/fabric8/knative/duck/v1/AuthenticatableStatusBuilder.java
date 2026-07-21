package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticatableStatusBuilder extends AuthenticatableStatusFluent<AuthenticatableStatusBuilder> implements VisitableBuilder<AuthenticatableStatus,AuthenticatableStatusBuilder>{

  AuthenticatableStatusFluent<?> fluent;

  public AuthenticatableStatusBuilder() {
    this(new AuthenticatableStatus());
  }
  
  public AuthenticatableStatusBuilder(AuthenticatableStatusFluent<?> fluent) {
    this(fluent, new AuthenticatableStatus());
  }
  
  public AuthenticatableStatusBuilder(AuthenticatableStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticatableStatusBuilder(AuthenticatableStatusFluent<?> fluent,AuthenticatableStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthenticatableStatus build() {
    AuthenticatableStatus buildable = new AuthenticatableStatus(fluent.buildAuth());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}