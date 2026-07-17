package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RecreateDeploymentStrategyParamsBuilder extends RecreateDeploymentStrategyParamsFluent<RecreateDeploymentStrategyParamsBuilder> implements VisitableBuilder<RecreateDeploymentStrategyParams,RecreateDeploymentStrategyParamsBuilder>{

  RecreateDeploymentStrategyParamsFluent<?> fluent;

  public RecreateDeploymentStrategyParamsBuilder() {
    this(new RecreateDeploymentStrategyParams());
  }
  
  public RecreateDeploymentStrategyParamsBuilder(RecreateDeploymentStrategyParamsFluent<?> fluent) {
    this(fluent, new RecreateDeploymentStrategyParams());
  }
  
  public RecreateDeploymentStrategyParamsBuilder(RecreateDeploymentStrategyParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RecreateDeploymentStrategyParamsBuilder(RecreateDeploymentStrategyParamsFluent<?> fluent,RecreateDeploymentStrategyParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RecreateDeploymentStrategyParams build() {
    RecreateDeploymentStrategyParams buildable = new RecreateDeploymentStrategyParams(fluent.buildMid(), fluent.buildPost(), fluent.buildPre(), fluent.getTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}