package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerResourceMetricStatusBuilder extends ContainerResourceMetricStatusFluent<ContainerResourceMetricStatusBuilder> implements VisitableBuilder<ContainerResourceMetricStatus,ContainerResourceMetricStatusBuilder>{

  ContainerResourceMetricStatusFluent<?> fluent;

  public ContainerResourceMetricStatusBuilder() {
    this(new ContainerResourceMetricStatus());
  }
  
  public ContainerResourceMetricStatusBuilder(ContainerResourceMetricStatusFluent<?> fluent) {
    this(fluent, new ContainerResourceMetricStatus());
  }
  
  public ContainerResourceMetricStatusBuilder(ContainerResourceMetricStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerResourceMetricStatusBuilder(ContainerResourceMetricStatusFluent<?> fluent,ContainerResourceMetricStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerResourceMetricStatus build() {
    ContainerResourceMetricStatus buildable = new ContainerResourceMetricStatus(fluent.getContainer(), fluent.buildCurrent(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}