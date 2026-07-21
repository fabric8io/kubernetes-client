package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubSourceStatusBuilder extends GitHubSourceStatusFluent<GitHubSourceStatusBuilder> implements VisitableBuilder<GitHubSourceStatus,GitHubSourceStatusBuilder>{

  GitHubSourceStatusFluent<?> fluent;

  public GitHubSourceStatusBuilder() {
    this(new GitHubSourceStatus());
  }
  
  public GitHubSourceStatusBuilder(GitHubSourceStatusFluent<?> fluent) {
    this(fluent, new GitHubSourceStatus());
  }
  
  public GitHubSourceStatusBuilder(GitHubSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubSourceStatusBuilder(GitHubSourceStatusFluent<?> fluent,GitHubSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubSourceStatus build() {
    GitHubSourceStatus buildable = new GitHubSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri(), fluent.getWebhookIDKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}