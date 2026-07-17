package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRuntimeConfigBuilder extends ContainerRuntimeConfigFluent<ContainerRuntimeConfigBuilder> implements VisitableBuilder<ContainerRuntimeConfig,ContainerRuntimeConfigBuilder>{

  ContainerRuntimeConfigFluent<?> fluent;

  public ContainerRuntimeConfigBuilder() {
    this(new ContainerRuntimeConfig());
  }
  
  public ContainerRuntimeConfigBuilder(ContainerRuntimeConfigFluent<?> fluent) {
    this(fluent, new ContainerRuntimeConfig());
  }
  
  public ContainerRuntimeConfigBuilder(ContainerRuntimeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRuntimeConfigBuilder(ContainerRuntimeConfigFluent<?> fluent,ContainerRuntimeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRuntimeConfig build() {
    ContainerRuntimeConfig buildable = new ContainerRuntimeConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}