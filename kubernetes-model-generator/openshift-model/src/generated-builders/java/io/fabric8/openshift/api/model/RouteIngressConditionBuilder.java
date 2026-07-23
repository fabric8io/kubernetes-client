package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteIngressConditionBuilder extends RouteIngressConditionFluent<RouteIngressConditionBuilder> implements VisitableBuilder<RouteIngressCondition,RouteIngressConditionBuilder>{

  RouteIngressConditionFluent<?> fluent;

  public RouteIngressConditionBuilder() {
    this(new RouteIngressCondition());
  }
  
  public RouteIngressConditionBuilder(RouteIngressConditionFluent<?> fluent) {
    this(fluent, new RouteIngressCondition());
  }
  
  public RouteIngressConditionBuilder(RouteIngressCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteIngressConditionBuilder(RouteIngressConditionFluent<?> fluent,RouteIngressCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteIngressCondition build() {
    RouteIngressCondition buildable = new RouteIngressCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}