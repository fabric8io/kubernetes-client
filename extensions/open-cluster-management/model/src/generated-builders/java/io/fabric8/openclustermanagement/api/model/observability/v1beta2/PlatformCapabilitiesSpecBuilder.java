package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformCapabilitiesSpecBuilder extends PlatformCapabilitiesSpecFluent<PlatformCapabilitiesSpecBuilder> implements VisitableBuilder<PlatformCapabilitiesSpec,PlatformCapabilitiesSpecBuilder>{

  PlatformCapabilitiesSpecFluent<?> fluent;

  public PlatformCapabilitiesSpecBuilder() {
    this(new PlatformCapabilitiesSpec());
  }
  
  public PlatformCapabilitiesSpecBuilder(PlatformCapabilitiesSpecFluent<?> fluent) {
    this(fluent, new PlatformCapabilitiesSpec());
  }
  
  public PlatformCapabilitiesSpecBuilder(PlatformCapabilitiesSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformCapabilitiesSpecBuilder(PlatformCapabilitiesSpecFluent<?> fluent,PlatformCapabilitiesSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformCapabilitiesSpec build() {
    PlatformCapabilitiesSpec buildable = new PlatformCapabilitiesSpec(fluent.buildAnalytics(), fluent.buildLogs(), fluent.buildMetrics());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}