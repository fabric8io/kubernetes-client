package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteConfigBuilder extends RouteConfigFluent<RouteConfigBuilder> implements VisitableBuilder<RouteConfig,RouteConfigBuilder>{

  RouteConfigFluent<?> fluent;

  public RouteConfigBuilder() {
    this(new RouteConfig());
  }
  
  public RouteConfigBuilder(RouteConfigFluent<?> fluent) {
    this(fluent, new RouteConfig());
  }
  
  public RouteConfigBuilder(RouteConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteConfigBuilder(RouteConfigFluent<?> fluent,RouteConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteConfig build() {
    RouteConfig buildable = new RouteConfig(fluent.getCaBundle(), fluent.getHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}