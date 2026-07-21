package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerSourceBuilder extends ContainerSourceFluent<ContainerSourceBuilder> implements VisitableBuilder<ContainerSource,ContainerSourceBuilder>{

  ContainerSourceFluent<?> fluent;

  public ContainerSourceBuilder() {
    this(new ContainerSource());
  }
  
  public ContainerSourceBuilder(ContainerSourceFluent<?> fluent) {
    this(fluent, new ContainerSource());
  }
  
  public ContainerSourceBuilder(ContainerSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerSourceBuilder(ContainerSourceFluent<?> fluent,ContainerSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerSource build() {
    ContainerSource buildable = new ContainerSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}