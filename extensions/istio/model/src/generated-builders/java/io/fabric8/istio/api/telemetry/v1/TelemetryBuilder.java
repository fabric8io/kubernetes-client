package io.fabric8.istio.api.telemetry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TelemetryBuilder extends TelemetryFluent<TelemetryBuilder> implements VisitableBuilder<Telemetry,TelemetryBuilder>{

  TelemetryFluent<?> fluent;

  public TelemetryBuilder() {
    this(new Telemetry());
  }
  
  public TelemetryBuilder(TelemetryFluent<?> fluent) {
    this(fluent, new Telemetry());
  }
  
  public TelemetryBuilder(Telemetry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TelemetryBuilder(TelemetryFluent<?> fluent,Telemetry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Telemetry build() {
    Telemetry buildable = new Telemetry(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}