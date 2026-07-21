package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformMetricsCollectionSpecBuilder extends PlatformMetricsCollectionSpecFluent<PlatformMetricsCollectionSpecBuilder> implements VisitableBuilder<PlatformMetricsCollectionSpec,PlatformMetricsCollectionSpecBuilder>{

  PlatformMetricsCollectionSpecFluent<?> fluent;

  public PlatformMetricsCollectionSpecBuilder() {
    this(new PlatformMetricsCollectionSpec());
  }
  
  public PlatformMetricsCollectionSpecBuilder(PlatformMetricsCollectionSpecFluent<?> fluent) {
    this(fluent, new PlatformMetricsCollectionSpec());
  }
  
  public PlatformMetricsCollectionSpecBuilder(PlatformMetricsCollectionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformMetricsCollectionSpecBuilder(PlatformMetricsCollectionSpecFluent<?> fluent,PlatformMetricsCollectionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformMetricsCollectionSpec build() {
    PlatformMetricsCollectionSpec buildable = new PlatformMetricsCollectionSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}