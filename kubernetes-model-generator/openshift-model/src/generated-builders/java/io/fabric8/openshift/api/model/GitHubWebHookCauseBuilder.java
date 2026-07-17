package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubWebHookCauseBuilder extends GitHubWebHookCauseFluent<GitHubWebHookCauseBuilder> implements VisitableBuilder<GitHubWebHookCause,GitHubWebHookCauseBuilder>{

  GitHubWebHookCauseFluent<?> fluent;

  public GitHubWebHookCauseBuilder() {
    this(new GitHubWebHookCause());
  }
  
  public GitHubWebHookCauseBuilder(GitHubWebHookCauseFluent<?> fluent) {
    this(fluent, new GitHubWebHookCause());
  }
  
  public GitHubWebHookCauseBuilder(GitHubWebHookCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubWebHookCauseBuilder(GitHubWebHookCauseFluent<?> fluent,GitHubWebHookCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubWebHookCause build() {
    GitHubWebHookCause buildable = new GitHubWebHookCause(fluent.buildRevision(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}