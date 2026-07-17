package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDiagnosticsTargetPlacementBuilder extends NetworkDiagnosticsTargetPlacementFluent<NetworkDiagnosticsTargetPlacementBuilder> implements VisitableBuilder<NetworkDiagnosticsTargetPlacement,NetworkDiagnosticsTargetPlacementBuilder>{

  NetworkDiagnosticsTargetPlacementFluent<?> fluent;

  public NetworkDiagnosticsTargetPlacementBuilder() {
    this(new NetworkDiagnosticsTargetPlacement());
  }
  
  public NetworkDiagnosticsTargetPlacementBuilder(NetworkDiagnosticsTargetPlacementFluent<?> fluent) {
    this(fluent, new NetworkDiagnosticsTargetPlacement());
  }
  
  public NetworkDiagnosticsTargetPlacementBuilder(NetworkDiagnosticsTargetPlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDiagnosticsTargetPlacementBuilder(NetworkDiagnosticsTargetPlacementFluent<?> fluent,NetworkDiagnosticsTargetPlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDiagnosticsTargetPlacement build() {
    NetworkDiagnosticsTargetPlacement buildable = new NetworkDiagnosticsTargetPlacement(fluent.getNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}