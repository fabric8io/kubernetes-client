package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubSourceBuilder extends GitHubSourceFluent<GitHubSourceBuilder> implements VisitableBuilder<GitHubSource,GitHubSourceBuilder>{

  GitHubSourceFluent<?> fluent;

  public GitHubSourceBuilder() {
    this(new GitHubSource());
  }
  
  public GitHubSourceBuilder(GitHubSourceFluent<?> fluent) {
    this(fluent, new GitHubSource());
  }
  
  public GitHubSourceBuilder(GitHubSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubSourceBuilder(GitHubSourceFluent<?> fluent,GitHubSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubSource build() {
    GitHubSource buildable = new GitHubSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}