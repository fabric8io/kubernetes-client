package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabWebHookCauseBuilder extends GitLabWebHookCauseFluent<GitLabWebHookCauseBuilder> implements VisitableBuilder<GitLabWebHookCause,GitLabWebHookCauseBuilder>{

  GitLabWebHookCauseFluent<?> fluent;

  public GitLabWebHookCauseBuilder() {
    this(new GitLabWebHookCause());
  }
  
  public GitLabWebHookCauseBuilder(GitLabWebHookCauseFluent<?> fluent) {
    this(fluent, new GitLabWebHookCause());
  }
  
  public GitLabWebHookCauseBuilder(GitLabWebHookCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabWebHookCauseBuilder(GitLabWebHookCauseFluent<?> fluent,GitLabWebHookCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabWebHookCause build() {
    GitLabWebHookCause buildable = new GitLabWebHookCause(fluent.buildRevision(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}