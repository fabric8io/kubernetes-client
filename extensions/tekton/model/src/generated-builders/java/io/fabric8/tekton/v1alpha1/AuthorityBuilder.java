package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthorityBuilder extends AuthorityFluent<AuthorityBuilder> implements VisitableBuilder<Authority,AuthorityBuilder>{

  AuthorityFluent<?> fluent;

  public AuthorityBuilder() {
    this(new Authority());
  }
  
  public AuthorityBuilder(AuthorityFluent<?> fluent) {
    this(fluent, new Authority());
  }
  
  public AuthorityBuilder(Authority instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthorityBuilder(AuthorityFluent<?> fluent,Authority instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Authority build() {
    Authority buildable = new Authority(fluent.buildKey(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}