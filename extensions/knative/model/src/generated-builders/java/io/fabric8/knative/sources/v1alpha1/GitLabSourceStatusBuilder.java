package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabSourceStatusBuilder extends GitLabSourceStatusFluent<GitLabSourceStatusBuilder> implements VisitableBuilder<GitLabSourceStatus,GitLabSourceStatusBuilder>{

  GitLabSourceStatusFluent<?> fluent;

  public GitLabSourceStatusBuilder() {
    this(new GitLabSourceStatus());
  }
  
  public GitLabSourceStatusBuilder(GitLabSourceStatusFluent<?> fluent) {
    this(fluent, new GitLabSourceStatus());
  }
  
  public GitLabSourceStatusBuilder(GitLabSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabSourceStatusBuilder(GitLabSourceStatusFluent<?> fluent,GitLabSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabSourceStatus build() {
    GitLabSourceStatus buildable = new GitLabSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri(), fluent.getWebhookID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}