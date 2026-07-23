package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteTargetReferenceBuilder extends RouteTargetReferenceFluent<RouteTargetReferenceBuilder> implements VisitableBuilder<RouteTargetReference,RouteTargetReferenceBuilder>{

  RouteTargetReferenceFluent<?> fluent;

  public RouteTargetReferenceBuilder() {
    this(new RouteTargetReference());
  }
  
  public RouteTargetReferenceBuilder(RouteTargetReferenceFluent<?> fluent) {
    this(fluent, new RouteTargetReference());
  }
  
  public RouteTargetReferenceBuilder(RouteTargetReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteTargetReferenceBuilder(RouteTargetReferenceFluent<?> fluent,RouteTargetReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteTargetReference build() {
    RouteTargetReference buildable = new RouteTargetReference(fluent.getKind(), fluent.getName(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}