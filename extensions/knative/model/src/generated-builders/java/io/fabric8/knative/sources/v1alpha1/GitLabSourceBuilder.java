package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabSourceBuilder extends GitLabSourceFluent<GitLabSourceBuilder> implements VisitableBuilder<GitLabSource,GitLabSourceBuilder>{

  GitLabSourceFluent<?> fluent;

  public GitLabSourceBuilder() {
    this(new GitLabSource());
  }
  
  public GitLabSourceBuilder(GitLabSourceFluent<?> fluent) {
    this(fluent, new GitLabSource());
  }
  
  public GitLabSourceBuilder(GitLabSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabSourceBuilder(GitLabSourceFluent<?> fluent,GitLabSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabSource build() {
    GitLabSource buildable = new GitLabSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}