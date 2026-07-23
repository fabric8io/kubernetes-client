package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenTelemetryCollectorSpecBuilder extends OpenTelemetryCollectorSpecFluent<OpenTelemetryCollectorSpecBuilder> implements VisitableBuilder<OpenTelemetryCollectorSpec,OpenTelemetryCollectorSpecBuilder>{

  OpenTelemetryCollectorSpecFluent<?> fluent;

  public OpenTelemetryCollectorSpecBuilder() {
    this(new OpenTelemetryCollectorSpec());
  }
  
  public OpenTelemetryCollectorSpecBuilder(OpenTelemetryCollectorSpecFluent<?> fluent) {
    this(fluent, new OpenTelemetryCollectorSpec());
  }
  
  public OpenTelemetryCollectorSpecBuilder(OpenTelemetryCollectorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenTelemetryCollectorSpecBuilder(OpenTelemetryCollectorSpecFluent<?> fluent,OpenTelemetryCollectorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenTelemetryCollectorSpec build() {
    OpenTelemetryCollectorSpec buildable = new OpenTelemetryCollectorSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}