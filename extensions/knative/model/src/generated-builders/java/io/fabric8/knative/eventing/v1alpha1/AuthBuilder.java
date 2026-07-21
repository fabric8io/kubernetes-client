package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthBuilder extends AuthFluent<AuthBuilder> implements VisitableBuilder<Auth,AuthBuilder>{

  AuthFluent<?> fluent;

  public AuthBuilder() {
    this(new Auth());
  }
  
  public AuthBuilder(AuthFluent<?> fluent) {
    this(fluent, new Auth());
  }
  
  public AuthBuilder(Auth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthBuilder(AuthFluent<?> fluent,Auth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Auth build() {
    Auth buildable = new Auth(fluent.buildSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}