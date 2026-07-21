package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubBindingListBuilder extends GitHubBindingListFluent<GitHubBindingListBuilder> implements VisitableBuilder<GitHubBindingList,GitHubBindingListBuilder>{

  GitHubBindingListFluent<?> fluent;

  public GitHubBindingListBuilder() {
    this(new GitHubBindingList());
  }
  
  public GitHubBindingListBuilder(GitHubBindingListFluent<?> fluent) {
    this(fluent, new GitHubBindingList());
  }
  
  public GitHubBindingListBuilder(GitHubBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubBindingListBuilder(GitHubBindingListFluent<?> fluent,GitHubBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubBindingList build() {
    GitHubBindingList buildable = new GitHubBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}