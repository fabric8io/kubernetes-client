package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterWaypointMatchFilterMatchBuilder extends EnvoyFilterWaypointMatchFilterMatchFluent<EnvoyFilterWaypointMatchFilterMatchBuilder> implements VisitableBuilder<EnvoyFilterWaypointMatchFilterMatch,EnvoyFilterWaypointMatchFilterMatchBuilder>{

  EnvoyFilterWaypointMatchFilterMatchFluent<?> fluent;

  public EnvoyFilterWaypointMatchFilterMatchBuilder() {
    this(new EnvoyFilterWaypointMatchFilterMatch());
  }
  
  public EnvoyFilterWaypointMatchFilterMatchBuilder(EnvoyFilterWaypointMatchFilterMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterWaypointMatchFilterMatch());
  }
  
  public EnvoyFilterWaypointMatchFilterMatchBuilder(EnvoyFilterWaypointMatchFilterMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterWaypointMatchFilterMatchBuilder(EnvoyFilterWaypointMatchFilterMatchFluent<?> fluent,EnvoyFilterWaypointMatchFilterMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterWaypointMatchFilterMatch build() {
    EnvoyFilterWaypointMatchFilterMatch buildable = new EnvoyFilterWaypointMatchFilterMatch(fluent.getName(), fluent.buildSubFilter());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}