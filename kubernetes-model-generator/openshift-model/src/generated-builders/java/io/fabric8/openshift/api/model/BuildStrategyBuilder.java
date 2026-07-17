package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildStrategyBuilder extends BuildStrategyFluent<BuildStrategyBuilder> implements VisitableBuilder<BuildStrategy,BuildStrategyBuilder>{

  BuildStrategyFluent<?> fluent;

  public BuildStrategyBuilder() {
    this(new BuildStrategy());
  }
  
  public BuildStrategyBuilder(BuildStrategyFluent<?> fluent) {
    this(fluent, new BuildStrategy());
  }
  
  public BuildStrategyBuilder(BuildStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildStrategyBuilder(BuildStrategyFluent<?> fluent,BuildStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildStrategy build() {
    BuildStrategy buildable = new BuildStrategy(fluent.buildCustomStrategy(), fluent.buildDockerStrategy(), fluent.buildJenkinsPipelineStrategy(), fluent.buildSourceStrategy(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}