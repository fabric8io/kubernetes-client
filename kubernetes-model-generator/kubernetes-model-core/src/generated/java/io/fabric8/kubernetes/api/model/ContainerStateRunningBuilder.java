package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerStateRunningBuilder extends ContainerStateRunningFluent<ContainerStateRunningBuilder> implements VisitableBuilder<ContainerStateRunning,ContainerStateRunningBuilder>{

  ContainerStateRunningFluent<?> fluent;

  public ContainerStateRunningBuilder() {
    this(new ContainerStateRunning());
  }
  
  public ContainerStateRunningBuilder(ContainerStateRunningFluent<?> fluent) {
    this(fluent, new ContainerStateRunning());
  }
  
  public ContainerStateRunningBuilder(ContainerStateRunning instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerStateRunningBuilder(ContainerStateRunningFluent<?> fluent,ContainerStateRunning instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerStateRunning build() {
    ContainerStateRunning buildable = new ContainerStateRunning(fluent.getStartedAt());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}