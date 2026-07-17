package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildConfigSpecBuilder extends BuildConfigSpecFluent<BuildConfigSpecBuilder> implements VisitableBuilder<BuildConfigSpec,BuildConfigSpecBuilder>{

  BuildConfigSpecFluent<?> fluent;

  public BuildConfigSpecBuilder() {
    this(new BuildConfigSpec());
  }
  
  public BuildConfigSpecBuilder(BuildConfigSpecFluent<?> fluent) {
    this(fluent, new BuildConfigSpec());
  }
  
  public BuildConfigSpecBuilder(BuildConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildConfigSpecBuilder(BuildConfigSpecFluent<?> fluent,BuildConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildConfigSpec build() {
    BuildConfigSpec buildable = new BuildConfigSpec(fluent.getCompletionDeadlineSeconds(), fluent.getFailedBuildsHistoryLimit(), fluent.getMountTrustedCA(), fluent.getNodeSelector(), fluent.buildOutput(), fluent.buildPostCommit(), fluent.buildResources(), fluent.buildRevision(), fluent.getRunPolicy(), fluent.getServiceAccount(), fluent.buildSource(), fluent.buildStrategy(), fluent.getSuccessfulBuildsHistoryLimit(), fluent.buildTriggers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}