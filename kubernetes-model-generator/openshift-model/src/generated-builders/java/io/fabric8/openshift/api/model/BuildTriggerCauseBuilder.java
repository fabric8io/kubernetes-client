package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildTriggerCauseBuilder extends BuildTriggerCauseFluent<BuildTriggerCauseBuilder> implements VisitableBuilder<BuildTriggerCause,BuildTriggerCauseBuilder>{

  BuildTriggerCauseFluent<?> fluent;

  public BuildTriggerCauseBuilder() {
    this(new BuildTriggerCause());
  }
  
  public BuildTriggerCauseBuilder(BuildTriggerCauseFluent<?> fluent) {
    this(fluent, new BuildTriggerCause());
  }
  
  public BuildTriggerCauseBuilder(BuildTriggerCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildTriggerCauseBuilder(BuildTriggerCauseFluent<?> fluent,BuildTriggerCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildTriggerCause build() {
    BuildTriggerCause buildable = new BuildTriggerCause(fluent.buildBitbucketWebHook(), fluent.buildGenericWebHook(), fluent.buildGithubWebHook(), fluent.buildGitlabWebHook(), fluent.buildImageChangeBuild(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}