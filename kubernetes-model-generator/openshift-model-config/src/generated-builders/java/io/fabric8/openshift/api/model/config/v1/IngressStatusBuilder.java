package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressStatusBuilder extends IngressStatusFluent<IngressStatusBuilder> implements VisitableBuilder<IngressStatus,IngressStatusBuilder>{

  IngressStatusFluent<?> fluent;

  public IngressStatusBuilder() {
    this(new IngressStatus());
  }
  
  public IngressStatusBuilder(IngressStatusFluent<?> fluent) {
    this(fluent, new IngressStatus());
  }
  
  public IngressStatusBuilder(IngressStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressStatusBuilder(IngressStatusFluent<?> fluent,IngressStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressStatus build() {
    IngressStatus buildable = new IngressStatus(fluent.buildComponentRoutes(), fluent.getDefaultPlacement());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}