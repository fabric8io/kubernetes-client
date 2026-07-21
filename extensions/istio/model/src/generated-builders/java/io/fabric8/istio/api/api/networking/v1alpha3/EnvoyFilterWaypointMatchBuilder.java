package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterWaypointMatchBuilder extends EnvoyFilterWaypointMatchFluent<EnvoyFilterWaypointMatchBuilder> implements VisitableBuilder<EnvoyFilterWaypointMatch,EnvoyFilterWaypointMatchBuilder>{

  EnvoyFilterWaypointMatchFluent<?> fluent;

  public EnvoyFilterWaypointMatchBuilder() {
    this(new EnvoyFilterWaypointMatch());
  }
  
  public EnvoyFilterWaypointMatchBuilder(EnvoyFilterWaypointMatchFluent<?> fluent) {
    this(fluent, new EnvoyFilterWaypointMatch());
  }
  
  public EnvoyFilterWaypointMatchBuilder(EnvoyFilterWaypointMatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterWaypointMatchBuilder(EnvoyFilterWaypointMatchFluent<?> fluent,EnvoyFilterWaypointMatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterWaypointMatch build() {
    EnvoyFilterWaypointMatch buildable = new EnvoyFilterWaypointMatch(fluent.buildFilter(), fluent.getPortNumber(), fluent.buildRoute());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}