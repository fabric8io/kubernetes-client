package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRuntimeConfigConditionBuilder extends ContainerRuntimeConfigConditionFluent<ContainerRuntimeConfigConditionBuilder> implements VisitableBuilder<ContainerRuntimeConfigCondition,ContainerRuntimeConfigConditionBuilder>{

  ContainerRuntimeConfigConditionFluent<?> fluent;

  public ContainerRuntimeConfigConditionBuilder() {
    this(new ContainerRuntimeConfigCondition());
  }
  
  public ContainerRuntimeConfigConditionBuilder(ContainerRuntimeConfigConditionFluent<?> fluent) {
    this(fluent, new ContainerRuntimeConfigCondition());
  }
  
  public ContainerRuntimeConfigConditionBuilder(ContainerRuntimeConfigCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRuntimeConfigConditionBuilder(ContainerRuntimeConfigConditionFluent<?> fluent,ContainerRuntimeConfigCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRuntimeConfigCondition build() {
    ContainerRuntimeConfigCondition buildable = new ContainerRuntimeConfigCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}