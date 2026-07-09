package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceMetricSourceBuilder extends ResourceMetricSourceFluent<ResourceMetricSourceBuilder> implements VisitableBuilder<ResourceMetricSource,ResourceMetricSourceBuilder>{

  ResourceMetricSourceFluent<?> fluent;

  public ResourceMetricSourceBuilder() {
    this(new ResourceMetricSource());
  }
  
  public ResourceMetricSourceBuilder(ResourceMetricSourceFluent<?> fluent) {
    this(fluent, new ResourceMetricSource());
  }
  
  public ResourceMetricSourceBuilder(ResourceMetricSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceMetricSourceBuilder(ResourceMetricSourceFluent<?> fluent,ResourceMetricSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceMetricSource build() {
    ResourceMetricSource buildable = new ResourceMetricSource(fluent.getName(), fluent.buildTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}