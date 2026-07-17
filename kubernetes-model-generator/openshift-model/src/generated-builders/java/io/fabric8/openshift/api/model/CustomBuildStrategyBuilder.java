package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomBuildStrategyBuilder extends CustomBuildStrategyFluent<CustomBuildStrategyBuilder> implements VisitableBuilder<CustomBuildStrategy,CustomBuildStrategyBuilder>{

  CustomBuildStrategyFluent<?> fluent;

  public CustomBuildStrategyBuilder() {
    this(new CustomBuildStrategy());
  }
  
  public CustomBuildStrategyBuilder(CustomBuildStrategyFluent<?> fluent) {
    this(fluent, new CustomBuildStrategy());
  }
  
  public CustomBuildStrategyBuilder(CustomBuildStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomBuildStrategyBuilder(CustomBuildStrategyFluent<?> fluent,CustomBuildStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomBuildStrategy build() {
    CustomBuildStrategy buildable = new CustomBuildStrategy(fluent.getBuildAPIVersion(), fluent.buildEnv(), fluent.getExposeDockerSocket(), fluent.getForcePull(), fluent.buildFrom(), fluent.buildPullSecret(), fluent.buildSecrets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}