package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerRestartRuleBuilder extends ContainerRestartRuleFluent<ContainerRestartRuleBuilder> implements VisitableBuilder<ContainerRestartRule,ContainerRestartRuleBuilder>{

  ContainerRestartRuleFluent<?> fluent;

  public ContainerRestartRuleBuilder() {
    this(new ContainerRestartRule());
  }
  
  public ContainerRestartRuleBuilder(ContainerRestartRuleFluent<?> fluent) {
    this(fluent, new ContainerRestartRule());
  }
  
  public ContainerRestartRuleBuilder(ContainerRestartRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerRestartRuleBuilder(ContainerRestartRuleFluent<?> fluent,ContainerRestartRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerRestartRule build() {
    ContainerRestartRule buildable = new ContainerRestartRule(fluent.getAction(), fluent.buildExitCodes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}