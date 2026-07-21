package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerSourceListBuilder extends ContainerSourceListFluent<ContainerSourceListBuilder> implements VisitableBuilder<ContainerSourceList,ContainerSourceListBuilder>{

  ContainerSourceListFluent<?> fluent;

  public ContainerSourceListBuilder() {
    this(new ContainerSourceList());
  }
  
  public ContainerSourceListBuilder(ContainerSourceListFluent<?> fluent) {
    this(fluent, new ContainerSourceList());
  }
  
  public ContainerSourceListBuilder(ContainerSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerSourceListBuilder(ContainerSourceListFluent<?> fluent,ContainerSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerSourceList build() {
    ContainerSourceList buildable = new ContainerSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}