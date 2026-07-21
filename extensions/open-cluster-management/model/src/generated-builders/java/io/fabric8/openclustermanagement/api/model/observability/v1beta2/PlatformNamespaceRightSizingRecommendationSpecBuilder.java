package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformNamespaceRightSizingRecommendationSpecBuilder extends PlatformNamespaceRightSizingRecommendationSpecFluent<PlatformNamespaceRightSizingRecommendationSpecBuilder> implements VisitableBuilder<PlatformNamespaceRightSizingRecommendationSpec,PlatformNamespaceRightSizingRecommendationSpecBuilder>{

  PlatformNamespaceRightSizingRecommendationSpecFluent<?> fluent;

  public PlatformNamespaceRightSizingRecommendationSpecBuilder() {
    this(new PlatformNamespaceRightSizingRecommendationSpec());
  }
  
  public PlatformNamespaceRightSizingRecommendationSpecBuilder(PlatformNamespaceRightSizingRecommendationSpecFluent<?> fluent) {
    this(fluent, new PlatformNamespaceRightSizingRecommendationSpec());
  }
  
  public PlatformNamespaceRightSizingRecommendationSpecBuilder(PlatformNamespaceRightSizingRecommendationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformNamespaceRightSizingRecommendationSpecBuilder(PlatformNamespaceRightSizingRecommendationSpecFluent<?> fluent,PlatformNamespaceRightSizingRecommendationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformNamespaceRightSizingRecommendationSpec build() {
    PlatformNamespaceRightSizingRecommendationSpec buildable = new PlatformNamespaceRightSizingRecommendationSpec(fluent.getEnabled(), fluent.getNamespaceBinding());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}