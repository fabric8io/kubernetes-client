package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerResourcePolicyBuilder extends ContainerResourcePolicyFluent<ContainerResourcePolicyBuilder> implements VisitableBuilder<ContainerResourcePolicy,ContainerResourcePolicyBuilder>{

  ContainerResourcePolicyFluent<?> fluent;

  public ContainerResourcePolicyBuilder() {
    this(new ContainerResourcePolicy());
  }
  
  public ContainerResourcePolicyBuilder(ContainerResourcePolicyFluent<?> fluent) {
    this(fluent, new ContainerResourcePolicy());
  }
  
  public ContainerResourcePolicyBuilder(ContainerResourcePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerResourcePolicyBuilder(ContainerResourcePolicyFluent<?> fluent,ContainerResourcePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerResourcePolicy build() {
    ContainerResourcePolicy buildable = new ContainerResourcePolicy(fluent.getContainerName(), fluent.getMaxAllowed(), fluent.getMinAllowed(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}