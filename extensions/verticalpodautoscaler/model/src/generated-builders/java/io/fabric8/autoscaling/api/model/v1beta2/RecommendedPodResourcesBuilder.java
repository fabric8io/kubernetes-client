package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RecommendedPodResourcesBuilder extends RecommendedPodResourcesFluent<RecommendedPodResourcesBuilder> implements VisitableBuilder<RecommendedPodResources,RecommendedPodResourcesBuilder>{

  RecommendedPodResourcesFluent<?> fluent;

  public RecommendedPodResourcesBuilder() {
    this(new RecommendedPodResources());
  }
  
  public RecommendedPodResourcesBuilder(RecommendedPodResourcesFluent<?> fluent) {
    this(fluent, new RecommendedPodResources());
  }
  
  public RecommendedPodResourcesBuilder(RecommendedPodResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RecommendedPodResourcesBuilder(RecommendedPodResourcesFluent<?> fluent,RecommendedPodResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RecommendedPodResources build() {
    RecommendedPodResources buildable = new RecommendedPodResources(fluent.buildContainerRecommendations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}