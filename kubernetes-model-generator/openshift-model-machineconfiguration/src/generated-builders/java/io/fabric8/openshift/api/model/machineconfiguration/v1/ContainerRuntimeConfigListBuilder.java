package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRuntimeConfigListBuilder extends ContainerRuntimeConfigListFluent<ContainerRuntimeConfigListBuilder> implements VisitableBuilder<ContainerRuntimeConfigList,ContainerRuntimeConfigListBuilder>{

  ContainerRuntimeConfigListFluent<?> fluent;

  public ContainerRuntimeConfigListBuilder() {
    this(new ContainerRuntimeConfigList());
  }
  
  public ContainerRuntimeConfigListBuilder(ContainerRuntimeConfigListFluent<?> fluent) {
    this(fluent, new ContainerRuntimeConfigList());
  }
  
  public ContainerRuntimeConfigListBuilder(ContainerRuntimeConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRuntimeConfigListBuilder(ContainerRuntimeConfigListFluent<?> fluent,ContainerRuntimeConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRuntimeConfigList build() {
    ContainerRuntimeConfigList buildable = new ContainerRuntimeConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}