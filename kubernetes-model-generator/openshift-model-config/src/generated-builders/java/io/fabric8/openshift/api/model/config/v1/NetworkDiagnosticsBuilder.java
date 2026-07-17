package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDiagnosticsBuilder extends NetworkDiagnosticsFluent<NetworkDiagnosticsBuilder> implements VisitableBuilder<NetworkDiagnostics,NetworkDiagnosticsBuilder>{

  NetworkDiagnosticsFluent<?> fluent;

  public NetworkDiagnosticsBuilder() {
    this(new NetworkDiagnostics());
  }
  
  public NetworkDiagnosticsBuilder(NetworkDiagnosticsFluent<?> fluent) {
    this(fluent, new NetworkDiagnostics());
  }
  
  public NetworkDiagnosticsBuilder(NetworkDiagnostics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDiagnosticsBuilder(NetworkDiagnosticsFluent<?> fluent,NetworkDiagnostics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDiagnostics build() {
    NetworkDiagnostics buildable = new NetworkDiagnostics(fluent.getMode(), fluent.buildSourcePlacement(), fluent.buildTargetPlacement());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}