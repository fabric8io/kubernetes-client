package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RollingUpdateDeploymentBuilder extends RollingUpdateDeploymentFluent<RollingUpdateDeploymentBuilder> implements VisitableBuilder<RollingUpdateDeployment,RollingUpdateDeploymentBuilder>{

  RollingUpdateDeploymentFluent<?> fluent;

  public RollingUpdateDeploymentBuilder() {
    this(new RollingUpdateDeployment());
  }
  
  public RollingUpdateDeploymentBuilder(RollingUpdateDeploymentFluent<?> fluent) {
    this(fluent, new RollingUpdateDeployment());
  }
  
  public RollingUpdateDeploymentBuilder(RollingUpdateDeployment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RollingUpdateDeploymentBuilder(RollingUpdateDeploymentFluent<?> fluent,RollingUpdateDeployment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RollingUpdateDeployment build() {
    RollingUpdateDeployment buildable = new RollingUpdateDeployment(fluent.buildMaxSurge(), fluent.buildMaxUnavailable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}