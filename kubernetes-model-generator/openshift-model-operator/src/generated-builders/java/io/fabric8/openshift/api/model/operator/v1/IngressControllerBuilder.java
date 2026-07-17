package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerBuilder extends IngressControllerFluent<IngressControllerBuilder> implements VisitableBuilder<IngressController,IngressControllerBuilder>{

  IngressControllerFluent<?> fluent;

  public IngressControllerBuilder() {
    this(new IngressController());
  }
  
  public IngressControllerBuilder(IngressControllerFluent<?> fluent) {
    this(fluent, new IngressController());
  }
  
  public IngressControllerBuilder(IngressController instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerBuilder(IngressControllerFluent<?> fluent,IngressController instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressController build() {
    IngressController buildable = new IngressController(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}