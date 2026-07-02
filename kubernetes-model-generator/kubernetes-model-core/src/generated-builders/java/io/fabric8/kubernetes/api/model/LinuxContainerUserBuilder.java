package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LinuxContainerUserBuilder extends LinuxContainerUserFluent<LinuxContainerUserBuilder> implements VisitableBuilder<LinuxContainerUser,LinuxContainerUserBuilder>{

  LinuxContainerUserFluent<?> fluent;

  public LinuxContainerUserBuilder() {
    this(new LinuxContainerUser());
  }
  
  public LinuxContainerUserBuilder(LinuxContainerUserFluent<?> fluent) {
    this(fluent, new LinuxContainerUser());
  }
  
  public LinuxContainerUserBuilder(LinuxContainerUser instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LinuxContainerUserBuilder(LinuxContainerUserFluent<?> fluent,LinuxContainerUser instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LinuxContainerUser build() {
    LinuxContainerUser buildable = new LinuxContainerUser(fluent.getGid(), fluent.getSupplementalGroups(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}