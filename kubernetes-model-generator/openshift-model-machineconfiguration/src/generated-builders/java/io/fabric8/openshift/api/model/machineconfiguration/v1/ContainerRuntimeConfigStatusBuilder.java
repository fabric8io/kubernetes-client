package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRuntimeConfigStatusBuilder extends ContainerRuntimeConfigStatusFluent<ContainerRuntimeConfigStatusBuilder> implements VisitableBuilder<ContainerRuntimeConfigStatus,ContainerRuntimeConfigStatusBuilder>{

  ContainerRuntimeConfigStatusFluent<?> fluent;

  public ContainerRuntimeConfigStatusBuilder() {
    this(new ContainerRuntimeConfigStatus());
  }
  
  public ContainerRuntimeConfigStatusBuilder(ContainerRuntimeConfigStatusFluent<?> fluent) {
    this(fluent, new ContainerRuntimeConfigStatus());
  }
  
  public ContainerRuntimeConfigStatusBuilder(ContainerRuntimeConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRuntimeConfigStatusBuilder(ContainerRuntimeConfigStatusFluent<?> fluent,ContainerRuntimeConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRuntimeConfigStatus build() {
    ContainerRuntimeConfigStatus buildable = new ContainerRuntimeConfigStatus(fluent.buildConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}