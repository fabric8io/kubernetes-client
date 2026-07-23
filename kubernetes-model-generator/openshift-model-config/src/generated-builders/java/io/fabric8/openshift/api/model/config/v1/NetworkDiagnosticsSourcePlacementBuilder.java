package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDiagnosticsSourcePlacementBuilder extends NetworkDiagnosticsSourcePlacementFluent<NetworkDiagnosticsSourcePlacementBuilder> implements VisitableBuilder<NetworkDiagnosticsSourcePlacement,NetworkDiagnosticsSourcePlacementBuilder>{

  NetworkDiagnosticsSourcePlacementFluent<?> fluent;

  public NetworkDiagnosticsSourcePlacementBuilder() {
    this(new NetworkDiagnosticsSourcePlacement());
  }
  
  public NetworkDiagnosticsSourcePlacementBuilder(NetworkDiagnosticsSourcePlacementFluent<?> fluent) {
    this(fluent, new NetworkDiagnosticsSourcePlacement());
  }
  
  public NetworkDiagnosticsSourcePlacementBuilder(NetworkDiagnosticsSourcePlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDiagnosticsSourcePlacementBuilder(NetworkDiagnosticsSourcePlacementFluent<?> fluent,NetworkDiagnosticsSourcePlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDiagnosticsSourcePlacement build() {
    NetworkDiagnosticsSourcePlacement buildable = new NetworkDiagnosticsSourcePlacement(fluent.getNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}