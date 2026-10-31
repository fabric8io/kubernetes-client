package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformMetricsDefaultSpecBuilder extends PlatformMetricsDefaultSpecFluent<PlatformMetricsDefaultSpecBuilder> implements VisitableBuilder<PlatformMetricsDefaultSpec,PlatformMetricsDefaultSpecBuilder>{

  PlatformMetricsDefaultSpecFluent<?> fluent;

  public PlatformMetricsDefaultSpecBuilder() {
    this(new PlatformMetricsDefaultSpec());
  }
  
  public PlatformMetricsDefaultSpecBuilder(PlatformMetricsDefaultSpecFluent<?> fluent) {
    this(fluent, new PlatformMetricsDefaultSpec());
  }
  
  public PlatformMetricsDefaultSpecBuilder(PlatformMetricsDefaultSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformMetricsDefaultSpecBuilder(PlatformMetricsDefaultSpecFluent<?> fluent,PlatformMetricsDefaultSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformMetricsDefaultSpec build() {
    PlatformMetricsDefaultSpec buildable = new PlatformMetricsDefaultSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}