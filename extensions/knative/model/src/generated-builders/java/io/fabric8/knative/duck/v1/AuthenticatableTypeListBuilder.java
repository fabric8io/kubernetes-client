package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthenticatableTypeListBuilder extends AuthenticatableTypeListFluent<AuthenticatableTypeListBuilder> implements VisitableBuilder<AuthenticatableTypeList,AuthenticatableTypeListBuilder>{

  AuthenticatableTypeListFluent<?> fluent;

  public AuthenticatableTypeListBuilder() {
    this(new AuthenticatableTypeList());
  }
  
  public AuthenticatableTypeListBuilder(AuthenticatableTypeListFluent<?> fluent) {
    this(fluent, new AuthenticatableTypeList());
  }
  
  public AuthenticatableTypeListBuilder(AuthenticatableTypeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthenticatableTypeListBuilder(AuthenticatableTypeListFluent<?> fluent,AuthenticatableTypeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthenticatableTypeList build() {
    AuthenticatableTypeList buildable = new AuthenticatableTypeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}