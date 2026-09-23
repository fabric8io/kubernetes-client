package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequesterBuilder extends RequesterFluent<RequesterBuilder> implements VisitableBuilder<Requester,RequesterBuilder>{

  RequesterFluent<?> fluent;

  public RequesterBuilder() {
    this(new Requester());
  }
  
  public RequesterBuilder(RequesterFluent<?> fluent) {
    this(fluent, new Requester());
  }
  
  public RequesterBuilder(Requester instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequesterBuilder(RequesterFluent<?> fluent,Requester instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Requester build() {
    Requester buildable = new Requester(fluent.getIntent(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}