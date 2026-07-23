package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticationBuilder extends AuthenticationFluent<AuthenticationBuilder> implements VisitableBuilder<Authentication,AuthenticationBuilder>{

  AuthenticationFluent<?> fluent;

  public AuthenticationBuilder() {
    this(new Authentication());
  }
  
  public AuthenticationBuilder(AuthenticationFluent<?> fluent) {
    this(fluent, new Authentication());
  }
  
  public AuthenticationBuilder(Authentication instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticationBuilder(AuthenticationFluent<?> fluent,Authentication instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Authentication build() {
    Authentication buildable = new Authentication(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}