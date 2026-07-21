package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabBindingListBuilder extends GitLabBindingListFluent<GitLabBindingListBuilder> implements VisitableBuilder<GitLabBindingList,GitLabBindingListBuilder>{

  GitLabBindingListFluent<?> fluent;

  public GitLabBindingListBuilder() {
    this(new GitLabBindingList());
  }
  
  public GitLabBindingListBuilder(GitLabBindingListFluent<?> fluent) {
    this(fluent, new GitLabBindingList());
  }
  
  public GitLabBindingListBuilder(GitLabBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabBindingListBuilder(GitLabBindingListFluent<?> fluent,GitLabBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabBindingList build() {
    GitLabBindingList buildable = new GitLabBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}