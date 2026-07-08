package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerStatusBuilder extends ContainerStatusFluent<ContainerStatusBuilder> implements VisitableBuilder<ContainerStatus,ContainerStatusBuilder>{

  ContainerStatusFluent<?> fluent;

  public ContainerStatusBuilder() {
    this(new ContainerStatus());
  }
  
  public ContainerStatusBuilder(ContainerStatusFluent<?> fluent) {
    this(fluent, new ContainerStatus());
  }
  
  public ContainerStatusBuilder(ContainerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerStatusBuilder(ContainerStatusFluent<?> fluent,ContainerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerStatus build() {
    ContainerStatus buildable = new ContainerStatus(fluent.getAllocatedResources(), fluent.buildAllocatedResourcesStatus(), fluent.getContainerID(), fluent.getImage(), fluent.getImageID(), fluent.buildLastState(), fluent.getName(), fluent.getReady(), fluent.buildResources(), fluent.getRestartCount(), fluent.getStarted(), fluent.buildState(), fluent.getStopSignal(), fluent.buildUser(), fluent.buildVolumeMounts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}