package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabBindingBuilder extends GitLabBindingFluent<GitLabBindingBuilder> implements VisitableBuilder<GitLabBinding,GitLabBindingBuilder>{

  GitLabBindingFluent<?> fluent;

  public GitLabBindingBuilder() {
    this(new GitLabBinding());
  }
  
  public GitLabBindingBuilder(GitLabBindingFluent<?> fluent) {
    this(fluent, new GitLabBinding());
  }
  
  public GitLabBindingBuilder(GitLabBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabBindingBuilder(GitLabBindingFluent<?> fluent,GitLabBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabBinding build() {
    GitLabBinding buildable = new GitLabBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}