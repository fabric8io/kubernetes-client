package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerResourceMetricSourceBuilder extends ContainerResourceMetricSourceFluent<ContainerResourceMetricSourceBuilder> implements VisitableBuilder<ContainerResourceMetricSource,ContainerResourceMetricSourceBuilder>{

  ContainerResourceMetricSourceFluent<?> fluent;

  public ContainerResourceMetricSourceBuilder() {
    this(new ContainerResourceMetricSource());
  }
  
  public ContainerResourceMetricSourceBuilder(ContainerResourceMetricSourceFluent<?> fluent) {
    this(fluent, new ContainerResourceMetricSource());
  }
  
  public ContainerResourceMetricSourceBuilder(ContainerResourceMetricSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerResourceMetricSourceBuilder(ContainerResourceMetricSourceFluent<?> fluent,ContainerResourceMetricSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerResourceMetricSource build() {
    ContainerResourceMetricSource buildable = new ContainerResourceMetricSource(fluent.getContainer(), fluent.getName(), fluent.getTargetAverageUtilization(), fluent.getTargetAverageValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}