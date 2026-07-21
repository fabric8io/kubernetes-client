package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterWaypointMatchRouteMatchBuilder extends EnvoyFilterWaypointMatchRouteMatchFluent<EnvoyFilterWaypointMatchRouteMatchBuilder> implements VisitableBuilder<EnvoyFilterWaypointMatchRouteMatch,EnvoyFilterWaypointMatchRouteMatchBuilder>{

  EnvoyFilterWaypointMatchRouteMatchFluent<?> fluent;

  public EnvoyFilterWaypointMatchRouteMatchBuilder() {
    this(new EnvoyFilterWaypointMatchRouteMatch());
  }
  
  public EnvoyFilterWaypointMatchRouteMatchBuilder(EnvoyFilterWaypointMatchRouteMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterWaypointMatchRouteMatch());
  }
  
  public EnvoyFilterWaypointMatchRouteMatchBuilder(EnvoyFilterWaypointMatchRouteMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterWaypointMatchRouteMatchBuilder(EnvoyFilterWaypointMatchRouteMatchFluent<?> fluent,EnvoyFilterWaypointMatchRouteMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterWaypointMatchRouteMatch build() {
    EnvoyFilterWaypointMatchRouteMatch buildable = new EnvoyFilterWaypointMatchRouteMatch(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}