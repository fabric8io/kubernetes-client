package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerImageBuilder extends ContainerImageFluent<ContainerImageBuilder> implements VisitableBuilder<ContainerImage,ContainerImageBuilder>{

  ContainerImageFluent<?> fluent;

  public ContainerImageBuilder() {
    this(new ContainerImage());
  }
  
  public ContainerImageBuilder(ContainerImageFluent<?> fluent) {
    this(fluent, new ContainerImage());
  }
  
  public ContainerImageBuilder(ContainerImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerImageBuilder(ContainerImageFluent<?> fluent,ContainerImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerImage build() {
    ContainerImage buildable = new ContainerImage(fluent.getNames(), fluent.getSizeBytes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}