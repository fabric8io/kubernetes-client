package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerPortBuilder extends ContainerPortFluent<ContainerPortBuilder> implements VisitableBuilder<ContainerPort,ContainerPortBuilder>{

  ContainerPortFluent<?> fluent;

  public ContainerPortBuilder() {
    this(new ContainerPort());
  }
  
  public ContainerPortBuilder(ContainerPortFluent<?> fluent) {
    this(fluent, new ContainerPort());
  }
  
  public ContainerPortBuilder(ContainerPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerPortBuilder(ContainerPortFluent<?> fluent,ContainerPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerPort build() {
    ContainerPort buildable = new ContainerPort(fluent.getContainerPort(), fluent.getHostIP(), fluent.getHostPort(), fluent.getName(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}