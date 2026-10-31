package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformRightSizingRecommendationSpecBuilder extends PlatformRightSizingRecommendationSpecFluent<PlatformRightSizingRecommendationSpecBuilder> implements VisitableBuilder<PlatformRightSizingRecommendationSpec,PlatformRightSizingRecommendationSpecBuilder>{

  PlatformRightSizingRecommendationSpecFluent<?> fluent;

  public PlatformRightSizingRecommendationSpecBuilder() {
    this(new PlatformRightSizingRecommendationSpec());
  }
  
  public PlatformRightSizingRecommendationSpecBuilder(PlatformRightSizingRecommendationSpecFluent<?> fluent) {
    this(fluent, new PlatformRightSizingRecommendationSpec());
  }
  
  public PlatformRightSizingRecommendationSpecBuilder(PlatformRightSizingRecommendationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformRightSizingRecommendationSpecBuilder(PlatformRightSizingRecommendationSpecFluent<?> fluent,PlatformRightSizingRecommendationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformRightSizingRecommendationSpec build() {
    PlatformRightSizingRecommendationSpec buildable = new PlatformRightSizingRecommendationSpec(fluent.getEnabled(), fluent.getNamespaceBinding());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}