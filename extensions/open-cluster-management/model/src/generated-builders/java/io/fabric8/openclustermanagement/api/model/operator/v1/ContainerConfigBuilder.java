package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerConfigBuilder extends ContainerConfigFluent<ContainerConfigBuilder> implements VisitableBuilder<ContainerConfig,ContainerConfigBuilder>{

  ContainerConfigFluent<?> fluent;

  public ContainerConfigBuilder() {
    this(new ContainerConfig());
  }
  
  public ContainerConfigBuilder(ContainerConfigFluent<?> fluent) {
    this(fluent, new ContainerConfig());
  }
  
  public ContainerConfigBuilder(ContainerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerConfigBuilder(ContainerConfigFluent<?> fluent,ContainerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerConfig build() {
    ContainerConfig buildable = new ContainerConfig(fluent.buildEnv(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}