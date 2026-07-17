package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerStatusBuilder extends IngressControllerStatusFluent<IngressControllerStatusBuilder> implements VisitableBuilder<IngressControllerStatus,IngressControllerStatusBuilder>{

  IngressControllerStatusFluent<?> fluent;

  public IngressControllerStatusBuilder() {
    this(new IngressControllerStatus());
  }
  
  public IngressControllerStatusBuilder(IngressControllerStatusFluent<?> fluent) {
    this(fluent, new IngressControllerStatus());
  }
  
  public IngressControllerStatusBuilder(IngressControllerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerStatusBuilder(IngressControllerStatusFluent<?> fluent,IngressControllerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerStatus build() {
    IngressControllerStatus buildable = new IngressControllerStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getDomain(), fluent.buildEndpointPublishingStrategy(), fluent.buildNamespaceSelector(), fluent.getObservedGeneration(), fluent.buildRouteSelector(), fluent.getSelector(), fluent.getTlsProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}