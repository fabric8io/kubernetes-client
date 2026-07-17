package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthorizationBuilder extends AuthorizationFluent<AuthorizationBuilder> implements VisitableBuilder<Authorization,AuthorizationBuilder>{

  AuthorizationFluent<?> fluent;

  public AuthorizationBuilder() {
    this(new Authorization());
  }
  
  public AuthorizationBuilder(AuthorizationFluent<?> fluent) {
    this(fluent, new Authorization());
  }
  
  public AuthorizationBuilder(Authorization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthorizationBuilder(AuthorizationFluent<?> fluent,Authorization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Authorization build() {
    Authorization buildable = new Authorization(fluent.getCredentials(), fluent.getCredentialsFile(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}