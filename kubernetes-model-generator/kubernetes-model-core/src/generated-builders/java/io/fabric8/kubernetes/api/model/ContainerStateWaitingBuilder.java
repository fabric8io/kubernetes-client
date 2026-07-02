package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerStateWaitingBuilder extends ContainerStateWaitingFluent<ContainerStateWaitingBuilder> implements VisitableBuilder<ContainerStateWaiting,ContainerStateWaitingBuilder>{

  ContainerStateWaitingFluent<?> fluent;

  public ContainerStateWaitingBuilder() {
    this(new ContainerStateWaiting());
  }
  
  public ContainerStateWaitingBuilder(ContainerStateWaitingFluent<?> fluent) {
    this(fluent, new ContainerStateWaiting());
  }
  
  public ContainerStateWaitingBuilder(ContainerStateWaiting instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerStateWaitingBuilder(ContainerStateWaitingFluent<?> fluent,ContainerStateWaiting instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerStateWaiting build() {
    ContainerStateWaiting buildable = new ContainerStateWaiting(fluent.getMessage(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}