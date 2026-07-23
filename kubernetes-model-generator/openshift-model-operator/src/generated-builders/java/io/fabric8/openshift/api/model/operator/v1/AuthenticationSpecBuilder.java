package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticationSpecBuilder extends AuthenticationSpecFluent<AuthenticationSpecBuilder> implements VisitableBuilder<AuthenticationSpec,AuthenticationSpecBuilder>{

  AuthenticationSpecFluent<?> fluent;

  public AuthenticationSpecBuilder() {
    this(new AuthenticationSpec());
  }
  
  public AuthenticationSpecBuilder(AuthenticationSpecFluent<?> fluent) {
    this(fluent, new AuthenticationSpec());
  }
  
  public AuthenticationSpecBuilder(AuthenticationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticationSpecBuilder(AuthenticationSpecFluent<?> fluent,AuthenticationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthenticationSpec build() {
    AuthenticationSpec buildable = new AuthenticationSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}