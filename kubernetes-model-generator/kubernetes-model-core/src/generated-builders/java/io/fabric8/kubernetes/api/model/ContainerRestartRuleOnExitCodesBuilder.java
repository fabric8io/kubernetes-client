package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRestartRuleOnExitCodesBuilder extends ContainerRestartRuleOnExitCodesFluent<ContainerRestartRuleOnExitCodesBuilder> implements VisitableBuilder<ContainerRestartRuleOnExitCodes,ContainerRestartRuleOnExitCodesBuilder>{

  ContainerRestartRuleOnExitCodesFluent<?> fluent;

  public ContainerRestartRuleOnExitCodesBuilder() {
    this(new ContainerRestartRuleOnExitCodes());
  }
  
  public ContainerRestartRuleOnExitCodesBuilder(ContainerRestartRuleOnExitCodesFluent<?> fluent) {
    this(fluent, new ContainerRestartRuleOnExitCodes());
  }
  
  public ContainerRestartRuleOnExitCodesBuilder(ContainerRestartRuleOnExitCodes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRestartRuleOnExitCodesBuilder(ContainerRestartRuleOnExitCodesFluent<?> fluent,ContainerRestartRuleOnExitCodes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRestartRuleOnExitCodes build() {
    ContainerRestartRuleOnExitCodes buildable = new ContainerRestartRuleOnExitCodes(fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}