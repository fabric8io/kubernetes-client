package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DelegatedAuthenticationBuilder extends DelegatedAuthenticationFluent<DelegatedAuthenticationBuilder> implements VisitableBuilder<DelegatedAuthentication,DelegatedAuthenticationBuilder>{

  DelegatedAuthenticationFluent<?> fluent;

  public DelegatedAuthenticationBuilder() {
    this(new DelegatedAuthentication());
  }
  
  public DelegatedAuthenticationBuilder(DelegatedAuthenticationFluent<?> fluent) {
    this(fluent, new DelegatedAuthentication());
  }
  
  public DelegatedAuthenticationBuilder(DelegatedAuthentication instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DelegatedAuthenticationBuilder(DelegatedAuthenticationFluent<?> fluent,DelegatedAuthentication instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DelegatedAuthentication build() {
    DelegatedAuthentication buildable = new DelegatedAuthentication(fluent.getDisabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}