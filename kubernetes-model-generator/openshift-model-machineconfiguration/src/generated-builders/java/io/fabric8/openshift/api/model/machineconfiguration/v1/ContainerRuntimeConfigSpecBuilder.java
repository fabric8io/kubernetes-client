package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRuntimeConfigSpecBuilder extends ContainerRuntimeConfigSpecFluent<ContainerRuntimeConfigSpecBuilder> implements VisitableBuilder<ContainerRuntimeConfigSpec,ContainerRuntimeConfigSpecBuilder>{

  ContainerRuntimeConfigSpecFluent<?> fluent;

  public ContainerRuntimeConfigSpecBuilder() {
    this(new ContainerRuntimeConfigSpec());
  }
  
  public ContainerRuntimeConfigSpecBuilder(ContainerRuntimeConfigSpecFluent<?> fluent) {
    this(fluent, new ContainerRuntimeConfigSpec());
  }
  
  public ContainerRuntimeConfigSpecBuilder(ContainerRuntimeConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRuntimeConfigSpecBuilder(ContainerRuntimeConfigSpecFluent<?> fluent,ContainerRuntimeConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRuntimeConfigSpec build() {
    ContainerRuntimeConfigSpec buildable = new ContainerRuntimeConfigSpec(fluent.buildContainerRuntimeConfig(), fluent.buildMachineConfigPoolSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}