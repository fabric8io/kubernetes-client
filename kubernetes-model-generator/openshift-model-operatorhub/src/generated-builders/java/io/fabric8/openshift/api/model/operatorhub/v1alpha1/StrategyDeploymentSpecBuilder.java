package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StrategyDeploymentSpecBuilder extends StrategyDeploymentSpecFluent<StrategyDeploymentSpecBuilder> implements VisitableBuilder<StrategyDeploymentSpec,StrategyDeploymentSpecBuilder>{

  StrategyDeploymentSpecFluent<?> fluent;

  public StrategyDeploymentSpecBuilder() {
    this(new StrategyDeploymentSpec());
  }
  
  public StrategyDeploymentSpecBuilder(StrategyDeploymentSpecFluent<?> fluent) {
    this(fluent, new StrategyDeploymentSpec());
  }
  
  public StrategyDeploymentSpecBuilder(StrategyDeploymentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StrategyDeploymentSpecBuilder(StrategyDeploymentSpecFluent<?> fluent,StrategyDeploymentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StrategyDeploymentSpec build() {
    StrategyDeploymentSpec buildable = new StrategyDeploymentSpec(fluent.getLabel(), fluent.getName(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}