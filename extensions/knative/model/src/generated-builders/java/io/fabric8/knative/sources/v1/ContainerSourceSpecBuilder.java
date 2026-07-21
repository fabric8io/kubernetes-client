package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerSourceSpecBuilder extends ContainerSourceSpecFluent<ContainerSourceSpecBuilder> implements VisitableBuilder<ContainerSourceSpec,ContainerSourceSpecBuilder>{

  ContainerSourceSpecFluent<?> fluent;

  public ContainerSourceSpecBuilder() {
    this(new ContainerSourceSpec());
  }
  
  public ContainerSourceSpecBuilder(ContainerSourceSpecFluent<?> fluent) {
    this(fluent, new ContainerSourceSpec());
  }
  
  public ContainerSourceSpecBuilder(ContainerSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerSourceSpecBuilder(ContainerSourceSpecFluent<?> fluent,ContainerSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerSourceSpec build() {
    ContainerSourceSpec buildable = new ContainerSourceSpec(fluent.buildCeOverrides(), fluent.buildSink(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}