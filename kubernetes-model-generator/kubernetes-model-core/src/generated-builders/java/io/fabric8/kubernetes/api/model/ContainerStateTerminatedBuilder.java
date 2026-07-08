package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerStateTerminatedBuilder extends ContainerStateTerminatedFluent<ContainerStateTerminatedBuilder> implements VisitableBuilder<ContainerStateTerminated,ContainerStateTerminatedBuilder>{

  ContainerStateTerminatedFluent<?> fluent;

  public ContainerStateTerminatedBuilder() {
    this(new ContainerStateTerminated());
  }
  
  public ContainerStateTerminatedBuilder(ContainerStateTerminatedFluent<?> fluent) {
    this(fluent, new ContainerStateTerminated());
  }
  
  public ContainerStateTerminatedBuilder(ContainerStateTerminated instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerStateTerminatedBuilder(ContainerStateTerminatedFluent<?> fluent,ContainerStateTerminated instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerStateTerminated build() {
    ContainerStateTerminated buildable = new ContainerStateTerminated(fluent.getContainerID(), fluent.getExitCode(), fluent.getFinishedAt(), fluent.getMessage(), fluent.getReason(), fluent.getSignal(), fluent.getStartedAt());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}