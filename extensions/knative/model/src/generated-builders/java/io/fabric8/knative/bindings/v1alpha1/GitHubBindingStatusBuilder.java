package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubBindingStatusBuilder extends GitHubBindingStatusFluent<GitHubBindingStatusBuilder> implements VisitableBuilder<GitHubBindingStatus,GitHubBindingStatusBuilder>{

  GitHubBindingStatusFluent<?> fluent;

  public GitHubBindingStatusBuilder() {
    this(new GitHubBindingStatus());
  }
  
  public GitHubBindingStatusBuilder(GitHubBindingStatusFluent<?> fluent) {
    this(fluent, new GitHubBindingStatus());
  }
  
  public GitHubBindingStatusBuilder(GitHubBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubBindingStatusBuilder(GitHubBindingStatusFluent<?> fluent,GitHubBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubBindingStatus build() {
    GitHubBindingStatus buildable = new GitHubBindingStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}