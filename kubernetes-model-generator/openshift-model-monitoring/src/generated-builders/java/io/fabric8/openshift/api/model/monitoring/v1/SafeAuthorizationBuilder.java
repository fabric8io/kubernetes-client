package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SafeAuthorizationBuilder extends SafeAuthorizationFluent<SafeAuthorizationBuilder> implements VisitableBuilder<SafeAuthorization,SafeAuthorizationBuilder>{

  SafeAuthorizationFluent<?> fluent;

  public SafeAuthorizationBuilder() {
    this(new SafeAuthorization());
  }
  
  public SafeAuthorizationBuilder(SafeAuthorizationFluent<?> fluent) {
    this(fluent, new SafeAuthorization());
  }
  
  public SafeAuthorizationBuilder(SafeAuthorization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SafeAuthorizationBuilder(SafeAuthorizationFluent<?> fluent,SafeAuthorization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SafeAuthorization build() {
    SafeAuthorization buildable = new SafeAuthorization(fluent.getCredentials(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}