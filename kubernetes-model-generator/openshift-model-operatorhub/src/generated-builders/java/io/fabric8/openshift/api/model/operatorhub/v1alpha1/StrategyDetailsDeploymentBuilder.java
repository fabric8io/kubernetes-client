package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StrategyDetailsDeploymentBuilder extends StrategyDetailsDeploymentFluent<StrategyDetailsDeploymentBuilder> implements VisitableBuilder<StrategyDetailsDeployment,StrategyDetailsDeploymentBuilder>{

  StrategyDetailsDeploymentFluent<?> fluent;

  public StrategyDetailsDeploymentBuilder() {
    this(new StrategyDetailsDeployment());
  }
  
  public StrategyDetailsDeploymentBuilder(StrategyDetailsDeploymentFluent<?> fluent) {
    this(fluent, new StrategyDetailsDeployment());
  }
  
  public StrategyDetailsDeploymentBuilder(StrategyDetailsDeployment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StrategyDetailsDeploymentBuilder(StrategyDetailsDeploymentFluent<?> fluent,StrategyDetailsDeployment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StrategyDetailsDeployment build() {
    StrategyDetailsDeployment buildable = new StrategyDetailsDeployment(fluent.buildClusterPermissions(), fluent.buildDeployments(), fluent.buildPermissions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}