package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerHTTPHeaderActionUnionBuilder extends IngressControllerHTTPHeaderActionUnionFluent<IngressControllerHTTPHeaderActionUnionBuilder> implements VisitableBuilder<IngressControllerHTTPHeaderActionUnion,IngressControllerHTTPHeaderActionUnionBuilder>{

  IngressControllerHTTPHeaderActionUnionFluent<?> fluent;

  public IngressControllerHTTPHeaderActionUnionBuilder() {
    this(new IngressControllerHTTPHeaderActionUnion());
  }
  
  public IngressControllerHTTPHeaderActionUnionBuilder(IngressControllerHTTPHeaderActionUnionFluent<?> fluent) {
    this(fluent, new IngressControllerHTTPHeaderActionUnion());
  }
  
  public IngressControllerHTTPHeaderActionUnionBuilder(IngressControllerHTTPHeaderActionUnion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerHTTPHeaderActionUnionBuilder(IngressControllerHTTPHeaderActionUnionFluent<?> fluent,IngressControllerHTTPHeaderActionUnion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerHTTPHeaderActionUnion build() {
    IngressControllerHTTPHeaderActionUnion buildable = new IngressControllerHTTPHeaderActionUnion(fluent.buildSet(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}