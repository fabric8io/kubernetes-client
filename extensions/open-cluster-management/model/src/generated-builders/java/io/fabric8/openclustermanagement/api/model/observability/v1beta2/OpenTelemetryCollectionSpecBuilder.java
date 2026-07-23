package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenTelemetryCollectionSpecBuilder extends OpenTelemetryCollectionSpecFluent<OpenTelemetryCollectionSpecBuilder> implements VisitableBuilder<OpenTelemetryCollectionSpec,OpenTelemetryCollectionSpecBuilder>{

  OpenTelemetryCollectionSpecFluent<?> fluent;

  public OpenTelemetryCollectionSpecBuilder() {
    this(new OpenTelemetryCollectionSpec());
  }
  
  public OpenTelemetryCollectionSpecBuilder(OpenTelemetryCollectionSpecFluent<?> fluent) {
    this(fluent, new OpenTelemetryCollectionSpec());
  }
  
  public OpenTelemetryCollectionSpecBuilder(OpenTelemetryCollectionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenTelemetryCollectionSpecBuilder(OpenTelemetryCollectionSpecFluent<?> fluent,OpenTelemetryCollectionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenTelemetryCollectionSpec build() {
    OpenTelemetryCollectionSpec buildable = new OpenTelemetryCollectionSpec(fluent.buildCollector(), fluent.buildInstrumentation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}