package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RollingDeploymentStrategyParamsBuilder extends RollingDeploymentStrategyParamsFluent<RollingDeploymentStrategyParamsBuilder> implements VisitableBuilder<RollingDeploymentStrategyParams,RollingDeploymentStrategyParamsBuilder>{

  RollingDeploymentStrategyParamsFluent<?> fluent;

  public RollingDeploymentStrategyParamsBuilder() {
    this(new RollingDeploymentStrategyParams());
  }
  
  public RollingDeploymentStrategyParamsBuilder(RollingDeploymentStrategyParamsFluent<?> fluent) {
    this(fluent, new RollingDeploymentStrategyParams());
  }
  
  public RollingDeploymentStrategyParamsBuilder(RollingDeploymentStrategyParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RollingDeploymentStrategyParamsBuilder(RollingDeploymentStrategyParamsFluent<?> fluent,RollingDeploymentStrategyParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RollingDeploymentStrategyParams build() {
    RollingDeploymentStrategyParams buildable = new RollingDeploymentStrategyParams(fluent.getIntervalSeconds(), fluent.buildMaxSurge(), fluent.buildMaxUnavailable(), fluent.buildPost(), fluent.buildPre(), fluent.getTimeoutSeconds(), fluent.getUpdatePeriodSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}