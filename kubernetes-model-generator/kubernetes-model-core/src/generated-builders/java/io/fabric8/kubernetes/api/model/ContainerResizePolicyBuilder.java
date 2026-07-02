package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerResizePolicyBuilder extends ContainerResizePolicyFluent<ContainerResizePolicyBuilder> implements VisitableBuilder<ContainerResizePolicy,ContainerResizePolicyBuilder>{

  ContainerResizePolicyFluent<?> fluent;

  public ContainerResizePolicyBuilder() {
    this(new ContainerResizePolicy());
  }
  
  public ContainerResizePolicyBuilder(ContainerResizePolicyFluent<?> fluent) {
    this(fluent, new ContainerResizePolicy());
  }
  
  public ContainerResizePolicyBuilder(ContainerResizePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerResizePolicyBuilder(ContainerResizePolicyFluent<?> fluent,ContainerResizePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerResizePolicy build() {
    ContainerResizePolicy buildable = new ContainerResizePolicy(fluent.getResourceName(), fluent.getRestartPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}