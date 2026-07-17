package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildStatusBuilder extends BuildStatusFluent<BuildStatusBuilder> implements VisitableBuilder<BuildStatus,BuildStatusBuilder>{

  BuildStatusFluent<?> fluent;

  public BuildStatusBuilder() {
    this(new BuildStatus());
  }
  
  public BuildStatusBuilder(BuildStatusFluent<?> fluent) {
    this(fluent, new BuildStatus());
  }
  
  public BuildStatusBuilder(BuildStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildStatusBuilder(BuildStatusFluent<?> fluent,BuildStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildStatus build() {
    BuildStatus buildable = new BuildStatus(fluent.getCancelled(), fluent.getCompletionTimestamp(), fluent.buildConditions(), fluent.buildConfig(), fluent.getDuration(), fluent.getLogSnippet(), fluent.getMessage(), fluent.buildOutput(), fluent.getOutputDockerImageReference(), fluent.getPhase(), fluent.getReason(), fluent.buildStages(), fluent.getStartTimestamp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}