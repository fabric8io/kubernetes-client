package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RecommendedContainerResourcesBuilder extends RecommendedContainerResourcesFluent<RecommendedContainerResourcesBuilder> implements VisitableBuilder<RecommendedContainerResources,RecommendedContainerResourcesBuilder>{

  RecommendedContainerResourcesFluent<?> fluent;

  public RecommendedContainerResourcesBuilder() {
    this(new RecommendedContainerResources());
  }
  
  public RecommendedContainerResourcesBuilder(RecommendedContainerResourcesFluent<?> fluent) {
    this(fluent, new RecommendedContainerResources());
  }
  
  public RecommendedContainerResourcesBuilder(RecommendedContainerResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RecommendedContainerResourcesBuilder(RecommendedContainerResourcesFluent<?> fluent,RecommendedContainerResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RecommendedContainerResources build() {
    RecommendedContainerResources buildable = new RecommendedContainerResources(fluent.getContainerName(), fluent.getLowerBound(), fluent.getTarget(), fluent.getUncappedTarget(), fluent.getUpperBound());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}