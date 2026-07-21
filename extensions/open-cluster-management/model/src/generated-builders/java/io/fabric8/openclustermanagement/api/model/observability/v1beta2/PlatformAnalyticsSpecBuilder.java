package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformAnalyticsSpecBuilder extends PlatformAnalyticsSpecFluent<PlatformAnalyticsSpecBuilder> implements VisitableBuilder<PlatformAnalyticsSpec,PlatformAnalyticsSpecBuilder>{

  PlatformAnalyticsSpecFluent<?> fluent;

  public PlatformAnalyticsSpecBuilder() {
    this(new PlatformAnalyticsSpec());
  }
  
  public PlatformAnalyticsSpecBuilder(PlatformAnalyticsSpecFluent<?> fluent) {
    this(fluent, new PlatformAnalyticsSpec());
  }
  
  public PlatformAnalyticsSpecBuilder(PlatformAnalyticsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformAnalyticsSpecBuilder(PlatformAnalyticsSpecFluent<?> fluent,PlatformAnalyticsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformAnalyticsSpec build() {
    PlatformAnalyticsSpec buildable = new PlatformAnalyticsSpec(fluent.buildIncidentDetection(), fluent.buildNamespaceRightSizingRecommendation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}