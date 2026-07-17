package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerHTTPHeaderBuilder extends IngressControllerHTTPHeaderFluent<IngressControllerHTTPHeaderBuilder> implements VisitableBuilder<IngressControllerHTTPHeader,IngressControllerHTTPHeaderBuilder>{

  IngressControllerHTTPHeaderFluent<?> fluent;

  public IngressControllerHTTPHeaderBuilder() {
    this(new IngressControllerHTTPHeader());
  }
  
  public IngressControllerHTTPHeaderBuilder(IngressControllerHTTPHeaderFluent<?> fluent) {
    this(fluent, new IngressControllerHTTPHeader());
  }
  
  public IngressControllerHTTPHeaderBuilder(IngressControllerHTTPHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerHTTPHeaderBuilder(IngressControllerHTTPHeaderFluent<?> fluent,IngressControllerHTTPHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerHTTPHeader build() {
    IngressControllerHTTPHeader buildable = new IngressControllerHTTPHeader(fluent.buildAction(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}