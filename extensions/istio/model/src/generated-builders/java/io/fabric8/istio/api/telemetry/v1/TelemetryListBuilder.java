package io.fabric8.istio.api.telemetry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TelemetryListBuilder extends TelemetryListFluent<TelemetryListBuilder> implements VisitableBuilder<TelemetryList,TelemetryListBuilder>{

  TelemetryListFluent<?> fluent;

  public TelemetryListBuilder() {
    this(new TelemetryList());
  }
  
  public TelemetryListBuilder(TelemetryListFluent<?> fluent) {
    this(fluent, new TelemetryList());
  }
  
  public TelemetryListBuilder(TelemetryList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TelemetryListBuilder(TelemetryListFluent<?> fluent,TelemetryList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TelemetryList build() {
    TelemetryList buildable = new TelemetryList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}