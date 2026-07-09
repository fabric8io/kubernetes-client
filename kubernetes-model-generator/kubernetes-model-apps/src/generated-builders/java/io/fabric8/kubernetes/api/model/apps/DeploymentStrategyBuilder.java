package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentStrategyBuilder extends DeploymentStrategyFluent<DeploymentStrategyBuilder> implements VisitableBuilder<DeploymentStrategy,DeploymentStrategyBuilder>{

  DeploymentStrategyFluent<?> fluent;

  public DeploymentStrategyBuilder() {
    this(new DeploymentStrategy());
  }
  
  public DeploymentStrategyBuilder(DeploymentStrategyFluent<?> fluent) {
    this(fluent, new DeploymentStrategy());
  }
  
  public DeploymentStrategyBuilder(DeploymentStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentStrategyBuilder(DeploymentStrategyFluent<?> fluent,DeploymentStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentStrategy build() {
    DeploymentStrategy buildable = new DeploymentStrategy(fluent.buildRollingUpdate(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}