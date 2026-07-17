package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceBuildStrategyBuilder extends SourceBuildStrategyFluent<SourceBuildStrategyBuilder> implements VisitableBuilder<SourceBuildStrategy,SourceBuildStrategyBuilder>{

  SourceBuildStrategyFluent<?> fluent;

  public SourceBuildStrategyBuilder() {
    this(new SourceBuildStrategy());
  }
  
  public SourceBuildStrategyBuilder(SourceBuildStrategyFluent<?> fluent) {
    this(fluent, new SourceBuildStrategy());
  }
  
  public SourceBuildStrategyBuilder(SourceBuildStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceBuildStrategyBuilder(SourceBuildStrategyFluent<?> fluent,SourceBuildStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceBuildStrategy build() {
    SourceBuildStrategy buildable = new SourceBuildStrategy(fluent.buildEnv(), fluent.getForcePull(), fluent.buildFrom(), fluent.getIncremental(), fluent.buildPullSecret(), fluent.getScripts(), fluent.buildVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}