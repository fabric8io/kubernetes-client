package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteStatusFieldsBuilder extends RouteStatusFieldsFluent<RouteStatusFieldsBuilder> implements VisitableBuilder<RouteStatusFields,RouteStatusFieldsBuilder>{

  RouteStatusFieldsFluent<?> fluent;

  public RouteStatusFieldsBuilder() {
    this(new RouteStatusFields());
  }
  
  public RouteStatusFieldsBuilder(RouteStatusFieldsFluent<?> fluent) {
    this(fluent, new RouteStatusFields());
  }
  
  public RouteStatusFieldsBuilder(RouteStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteStatusFieldsBuilder(RouteStatusFieldsFluent<?> fluent,RouteStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteStatusFields build() {
    RouteStatusFields buildable = new RouteStatusFields(fluent.buildAddress(), fluent.buildTraffic(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}