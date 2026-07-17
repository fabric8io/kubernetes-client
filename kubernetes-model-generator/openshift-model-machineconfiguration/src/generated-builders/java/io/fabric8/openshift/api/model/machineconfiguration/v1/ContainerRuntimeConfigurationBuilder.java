package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRuntimeConfigurationBuilder extends ContainerRuntimeConfigurationFluent<ContainerRuntimeConfigurationBuilder> implements VisitableBuilder<ContainerRuntimeConfiguration,ContainerRuntimeConfigurationBuilder>{

  ContainerRuntimeConfigurationFluent<?> fluent;

  public ContainerRuntimeConfigurationBuilder() {
    this(new ContainerRuntimeConfiguration());
  }
  
  public ContainerRuntimeConfigurationBuilder(ContainerRuntimeConfigurationFluent<?> fluent) {
    this(fluent, new ContainerRuntimeConfiguration());
  }
  
  public ContainerRuntimeConfigurationBuilder(ContainerRuntimeConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRuntimeConfigurationBuilder(ContainerRuntimeConfigurationFluent<?> fluent,ContainerRuntimeConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRuntimeConfiguration build() {
    ContainerRuntimeConfiguration buildable = new ContainerRuntimeConfiguration(fluent.getDefaultRuntime(), fluent.getLogLevel(), fluent.getLogSizeMax(), fluent.getOverlaySize(), fluent.getPidsLimit());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}