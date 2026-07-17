package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomDeploymentStrategyParamsBuilder extends CustomDeploymentStrategyParamsFluent<CustomDeploymentStrategyParamsBuilder> implements VisitableBuilder<CustomDeploymentStrategyParams,CustomDeploymentStrategyParamsBuilder>{

  CustomDeploymentStrategyParamsFluent<?> fluent;

  public CustomDeploymentStrategyParamsBuilder() {
    this(new CustomDeploymentStrategyParams());
  }
  
  public CustomDeploymentStrategyParamsBuilder(CustomDeploymentStrategyParamsFluent<?> fluent) {
    this(fluent, new CustomDeploymentStrategyParams());
  }
  
  public CustomDeploymentStrategyParamsBuilder(CustomDeploymentStrategyParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomDeploymentStrategyParamsBuilder(CustomDeploymentStrategyParamsFluent<?> fluent,CustomDeploymentStrategyParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomDeploymentStrategyParams build() {
    CustomDeploymentStrategyParams buildable = new CustomDeploymentStrategyParams(fluent.getCommand(), fluent.buildEnvironment(), fluent.getImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}