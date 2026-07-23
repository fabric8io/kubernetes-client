package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerStateBuilder extends ContainerStateFluent<ContainerStateBuilder> implements VisitableBuilder<ContainerState,ContainerStateBuilder>{

  ContainerStateFluent<?> fluent;

  public ContainerStateBuilder() {
    this(new ContainerState());
  }
  
  public ContainerStateBuilder(ContainerStateFluent<?> fluent) {
    this(fluent, new ContainerState());
  }
  
  public ContainerStateBuilder(ContainerState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerStateBuilder(ContainerStateFluent<?> fluent,ContainerState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerState build() {
    ContainerState buildable = new ContainerState(fluent.buildRunning(), fluent.buildTerminated(), fluent.buildWaiting());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}