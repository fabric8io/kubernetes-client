package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabSourceListBuilder extends GitLabSourceListFluent<GitLabSourceListBuilder> implements VisitableBuilder<GitLabSourceList,GitLabSourceListBuilder>{

  GitLabSourceListFluent<?> fluent;

  public GitLabSourceListBuilder() {
    this(new GitLabSourceList());
  }
  
  public GitLabSourceListBuilder(GitLabSourceListFluent<?> fluent) {
    this(fluent, new GitLabSourceList());
  }
  
  public GitLabSourceListBuilder(GitLabSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabSourceListBuilder(GitLabSourceListFluent<?> fluent,GitLabSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabSourceList build() {
    GitLabSourceList buildable = new GitLabSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}