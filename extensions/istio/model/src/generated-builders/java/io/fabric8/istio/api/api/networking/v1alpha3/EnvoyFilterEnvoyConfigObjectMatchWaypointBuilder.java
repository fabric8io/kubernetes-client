package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder extends EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder> implements VisitableBuilder<EnvoyFilterEnvoyConfigObjectMatchWaypoint,EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder>{

  EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<?> fluent;

  public EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder() {
    this(new EnvoyFilterEnvoyConfigObjectMatchWaypoint());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder(EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<?> fluent) {
    this(fluent, new EnvoyFilterEnvoyConfigObjectMatchWaypoint());
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder(EnvoyFilterEnvoyConfigObjectMatchWaypoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterEnvoyConfigObjectMatchWaypointBuilder(EnvoyFilterEnvoyConfigObjectMatchWaypointFluent<?> fluent,EnvoyFilterEnvoyConfigObjectMatchWaypoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterEnvoyConfigObjectMatchWaypoint build() {
    EnvoyFilterEnvoyConfigObjectMatchWaypoint buildable = new EnvoyFilterEnvoyConfigObjectMatchWaypoint(fluent.buildWaypoint());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}