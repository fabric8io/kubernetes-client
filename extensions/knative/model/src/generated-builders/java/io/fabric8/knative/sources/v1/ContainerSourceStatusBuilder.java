package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerSourceStatusBuilder extends ContainerSourceStatusFluent<ContainerSourceStatusBuilder> implements VisitableBuilder<ContainerSourceStatus,ContainerSourceStatusBuilder>{

  ContainerSourceStatusFluent<?> fluent;

  public ContainerSourceStatusBuilder() {
    this(new ContainerSourceStatus());
  }
  
  public ContainerSourceStatusBuilder(ContainerSourceStatusFluent<?> fluent) {
    this(fluent, new ContainerSourceStatus());
  }
  
  public ContainerSourceStatusBuilder(ContainerSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerSourceStatusBuilder(ContainerSourceStatusFluent<?> fluent,ContainerSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerSourceStatus build() {
    ContainerSourceStatus buildable = new ContainerSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}