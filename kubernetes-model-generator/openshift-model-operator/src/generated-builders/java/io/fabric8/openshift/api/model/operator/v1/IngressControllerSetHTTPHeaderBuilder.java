package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerSetHTTPHeaderBuilder extends IngressControllerSetHTTPHeaderFluent<IngressControllerSetHTTPHeaderBuilder> implements VisitableBuilder<IngressControllerSetHTTPHeader,IngressControllerSetHTTPHeaderBuilder>{

  IngressControllerSetHTTPHeaderFluent<?> fluent;

  public IngressControllerSetHTTPHeaderBuilder() {
    this(new IngressControllerSetHTTPHeader());
  }
  
  public IngressControllerSetHTTPHeaderBuilder(IngressControllerSetHTTPHeaderFluent<?> fluent) {
    this(fluent, new IngressControllerSetHTTPHeader());
  }
  
  public IngressControllerSetHTTPHeaderBuilder(IngressControllerSetHTTPHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerSetHTTPHeaderBuilder(IngressControllerSetHTTPHeaderFluent<?> fluent,IngressControllerSetHTTPHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerSetHTTPHeader build() {
    IngressControllerSetHTTPHeader buildable = new IngressControllerSetHTTPHeader(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}