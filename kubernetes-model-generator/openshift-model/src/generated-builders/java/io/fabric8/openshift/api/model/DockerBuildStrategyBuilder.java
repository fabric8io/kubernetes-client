package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DockerBuildStrategyBuilder extends DockerBuildStrategyFluent<DockerBuildStrategyBuilder> implements VisitableBuilder<DockerBuildStrategy,DockerBuildStrategyBuilder>{

  DockerBuildStrategyFluent<?> fluent;

  public DockerBuildStrategyBuilder() {
    this(new DockerBuildStrategy());
  }
  
  public DockerBuildStrategyBuilder(DockerBuildStrategyFluent<?> fluent) {
    this(fluent, new DockerBuildStrategy());
  }
  
  public DockerBuildStrategyBuilder(DockerBuildStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DockerBuildStrategyBuilder(DockerBuildStrategyFluent<?> fluent,DockerBuildStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DockerBuildStrategy build() {
    DockerBuildStrategy buildable = new DockerBuildStrategy(fluent.buildBuildArgs(), fluent.getDockerfilePath(), fluent.buildEnv(), fluent.getForcePull(), fluent.buildFrom(), fluent.getImageOptimizationPolicy(), fluent.getNoCache(), fluent.buildPullSecret(), fluent.buildVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}