package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerHTTPHeaderActionsBuilder extends IngressControllerHTTPHeaderActionsFluent<IngressControllerHTTPHeaderActionsBuilder> implements VisitableBuilder<IngressControllerHTTPHeaderActions,IngressControllerHTTPHeaderActionsBuilder>{

  IngressControllerHTTPHeaderActionsFluent<?> fluent;

  public IngressControllerHTTPHeaderActionsBuilder() {
    this(new IngressControllerHTTPHeaderActions());
  }
  
  public IngressControllerHTTPHeaderActionsBuilder(IngressControllerHTTPHeaderActionsFluent<?> fluent) {
    this(fluent, new IngressControllerHTTPHeaderActions());
  }
  
  public IngressControllerHTTPHeaderActionsBuilder(IngressControllerHTTPHeaderActions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerHTTPHeaderActionsBuilder(IngressControllerHTTPHeaderActionsFluent<?> fluent,IngressControllerHTTPHeaderActions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerHTTPHeaderActions build() {
    IngressControllerHTTPHeaderActions buildable = new IngressControllerHTTPHeaderActions(fluent.buildRequest(), fluent.buildResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}