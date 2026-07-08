package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerUserBuilder extends ContainerUserFluent<ContainerUserBuilder> implements VisitableBuilder<ContainerUser,ContainerUserBuilder>{

  ContainerUserFluent<?> fluent;

  public ContainerUserBuilder() {
    this(new ContainerUser());
  }
  
  public ContainerUserBuilder(ContainerUserFluent<?> fluent) {
    this(fluent, new ContainerUser());
  }
  
  public ContainerUserBuilder(ContainerUser instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerUserBuilder(ContainerUserFluent<?> fluent,ContainerUser instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerUser build() {
    ContainerUser buildable = new ContainerUser(fluent.buildLinux());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}