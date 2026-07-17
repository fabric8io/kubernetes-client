package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DelegatedAuthorizationBuilder extends DelegatedAuthorizationFluent<DelegatedAuthorizationBuilder> implements VisitableBuilder<DelegatedAuthorization,DelegatedAuthorizationBuilder>{

  DelegatedAuthorizationFluent<?> fluent;

  public DelegatedAuthorizationBuilder() {
    this(new DelegatedAuthorization());
  }
  
  public DelegatedAuthorizationBuilder(DelegatedAuthorizationFluent<?> fluent) {
    this(fluent, new DelegatedAuthorization());
  }
  
  public DelegatedAuthorizationBuilder(DelegatedAuthorization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DelegatedAuthorizationBuilder(DelegatedAuthorizationFluent<?> fluent,DelegatedAuthorization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DelegatedAuthorization build() {
    DelegatedAuthorization buildable = new DelegatedAuthorization(fluent.getDisabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}