package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubSourceListBuilder extends GitHubSourceListFluent<GitHubSourceListBuilder> implements VisitableBuilder<GitHubSourceList,GitHubSourceListBuilder>{

  GitHubSourceListFluent<?> fluent;

  public GitHubSourceListBuilder() {
    this(new GitHubSourceList());
  }
  
  public GitHubSourceListBuilder(GitHubSourceListFluent<?> fluent) {
    this(fluent, new GitHubSourceList());
  }
  
  public GitHubSourceListBuilder(GitHubSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubSourceListBuilder(GitHubSourceListFluent<?> fluent,GitHubSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubSourceList build() {
    GitHubSourceList buildable = new GitHubSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}