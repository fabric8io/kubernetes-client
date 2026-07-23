package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformIncidentDetectionSpecBuilder extends PlatformIncidentDetectionSpecFluent<PlatformIncidentDetectionSpecBuilder> implements VisitableBuilder<PlatformIncidentDetectionSpec,PlatformIncidentDetectionSpecBuilder>{

  PlatformIncidentDetectionSpecFluent<?> fluent;

  public PlatformIncidentDetectionSpecBuilder() {
    this(new PlatformIncidentDetectionSpec());
  }
  
  public PlatformIncidentDetectionSpecBuilder(PlatformIncidentDetectionSpecFluent<?> fluent) {
    this(fluent, new PlatformIncidentDetectionSpec());
  }
  
  public PlatformIncidentDetectionSpecBuilder(PlatformIncidentDetectionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformIncidentDetectionSpecBuilder(PlatformIncidentDetectionSpecFluent<?> fluent,PlatformIncidentDetectionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformIncidentDetectionSpec build() {
    PlatformIncidentDetectionSpec buildable = new PlatformIncidentDetectionSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}