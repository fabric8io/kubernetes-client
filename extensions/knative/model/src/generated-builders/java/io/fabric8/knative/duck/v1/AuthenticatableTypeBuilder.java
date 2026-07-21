package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticatableTypeBuilder extends AuthenticatableTypeFluent<AuthenticatableTypeBuilder> implements VisitableBuilder<AuthenticatableType,AuthenticatableTypeBuilder>{

  AuthenticatableTypeFluent<?> fluent;

  public AuthenticatableTypeBuilder() {
    this(new AuthenticatableType());
  }
  
  public AuthenticatableTypeBuilder(AuthenticatableTypeFluent<?> fluent) {
    this(fluent, new AuthenticatableType());
  }
  
  public AuthenticatableTypeBuilder(AuthenticatableType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticatableTypeBuilder(AuthenticatableTypeFluent<?> fluent,AuthenticatableType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthenticatableType build() {
    AuthenticatableType buildable = new AuthenticatableType(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}