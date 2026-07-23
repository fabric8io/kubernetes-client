package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder extends EnvoyFilterWaypointMatchFilterMatchSubFilterMatchFluent<EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder> implements VisitableBuilder<EnvoyFilterWaypointMatchFilterMatchSubFilterMatch,EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder>{

  EnvoyFilterWaypointMatchFilterMatchSubFilterMatchFluent<?> fluent;

  public EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder() {
    this(new EnvoyFilterWaypointMatchFilterMatchSubFilterMatch());
  }
  
  public EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder(EnvoyFilterWaypointMatchFilterMatchSubFilterMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterWaypointMatchFilterMatchSubFilterMatch());
  }
  
  public EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder(EnvoyFilterWaypointMatchFilterMatchSubFilterMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterWaypointMatchFilterMatchSubFilterMatchBuilder(EnvoyFilterWaypointMatchFilterMatchSubFilterMatchFluent<?> fluent,EnvoyFilterWaypointMatchFilterMatchSubFilterMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterWaypointMatchFilterMatchSubFilterMatch build() {
    EnvoyFilterWaypointMatchFilterMatchSubFilterMatch buildable = new EnvoyFilterWaypointMatchFilterMatchSubFilterMatch(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}