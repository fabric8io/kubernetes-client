package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerSelectorBuilder extends ContainerSelectorFluent<ContainerSelectorBuilder> implements VisitableBuilder<ContainerSelector,ContainerSelectorBuilder>{

  ContainerSelectorFluent<?> fluent;

  public ContainerSelectorBuilder() {
    this(new ContainerSelector());
  }
  
  public ContainerSelectorBuilder(ContainerSelectorFluent<?> fluent) {
    this(fluent, new ContainerSelector());
  }
  
  public ContainerSelectorBuilder(ContainerSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerSelectorBuilder(ContainerSelectorFluent<?> fluent,ContainerSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerSelector build() {
    ContainerSelector buildable = new ContainerSelector(fluent.getContainerNames(), fluent.getMode(), fluent.buildSelector(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}