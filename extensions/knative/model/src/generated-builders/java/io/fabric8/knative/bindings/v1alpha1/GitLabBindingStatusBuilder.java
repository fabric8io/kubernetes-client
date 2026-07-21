package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabBindingStatusBuilder extends GitLabBindingStatusFluent<GitLabBindingStatusBuilder> implements VisitableBuilder<GitLabBindingStatus,GitLabBindingStatusBuilder>{

  GitLabBindingStatusFluent<?> fluent;

  public GitLabBindingStatusBuilder() {
    this(new GitLabBindingStatus());
  }
  
  public GitLabBindingStatusBuilder(GitLabBindingStatusFluent<?> fluent) {
    this(fluent, new GitLabBindingStatus());
  }
  
  public GitLabBindingStatusBuilder(GitLabBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabBindingStatusBuilder(GitLabBindingStatusFluent<?> fluent,GitLabBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabBindingStatus build() {
    GitLabBindingStatus buildable = new GitLabBindingStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}