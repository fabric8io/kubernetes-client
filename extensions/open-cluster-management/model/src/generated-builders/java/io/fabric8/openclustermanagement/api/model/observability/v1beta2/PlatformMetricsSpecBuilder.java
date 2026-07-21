package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformMetricsSpecBuilder extends PlatformMetricsSpecFluent<PlatformMetricsSpecBuilder> implements VisitableBuilder<PlatformMetricsSpec,PlatformMetricsSpecBuilder>{

  PlatformMetricsSpecFluent<?> fluent;

  public PlatformMetricsSpecBuilder() {
    this(new PlatformMetricsSpec());
  }
  
  public PlatformMetricsSpecBuilder(PlatformMetricsSpecFluent<?> fluent) {
    this(fluent, new PlatformMetricsSpec());
  }
  
  public PlatformMetricsSpecBuilder(PlatformMetricsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformMetricsSpecBuilder(PlatformMetricsSpecFluent<?> fluent,PlatformMetricsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformMetricsSpec build() {
    PlatformMetricsSpec buildable = new PlatformMetricsSpec(fluent.buildCollection(), fluent.buildUi());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}