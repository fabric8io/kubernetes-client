package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticationListBuilder extends AuthenticationListFluent<AuthenticationListBuilder> implements VisitableBuilder<AuthenticationList,AuthenticationListBuilder>{

  AuthenticationListFluent<?> fluent;

  public AuthenticationListBuilder() {
    this(new AuthenticationList());
  }
  
  public AuthenticationListBuilder(AuthenticationListFluent<?> fluent) {
    this(fluent, new AuthenticationList());
  }
  
  public AuthenticationListBuilder(AuthenticationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticationListBuilder(AuthenticationListFluent<?> fluent,AuthenticationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthenticationList build() {
    AuthenticationList buildable = new AuthenticationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}