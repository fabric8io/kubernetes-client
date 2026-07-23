package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceMetricStatusBuilder extends ResourceMetricStatusFluent<ResourceMetricStatusBuilder> implements VisitableBuilder<ResourceMetricStatus,ResourceMetricStatusBuilder>{

  ResourceMetricStatusFluent<?> fluent;

  public ResourceMetricStatusBuilder() {
    this(new ResourceMetricStatus());
  }
  
  public ResourceMetricStatusBuilder(ResourceMetricStatusFluent<?> fluent) {
    this(fluent, new ResourceMetricStatus());
  }
  
  public ResourceMetricStatusBuilder(ResourceMetricStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceMetricStatusBuilder(ResourceMetricStatusFluent<?> fluent,ResourceMetricStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceMetricStatus build() {
    ResourceMetricStatus buildable = new ResourceMetricStatus(fluent.getCurrentAverageUtilization(), fluent.getCurrentAverageValue(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}