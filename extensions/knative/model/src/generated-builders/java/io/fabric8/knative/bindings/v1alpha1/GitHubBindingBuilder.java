package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubBindingBuilder extends GitHubBindingFluent<GitHubBindingBuilder> implements VisitableBuilder<GitHubBinding,GitHubBindingBuilder>{

  GitHubBindingFluent<?> fluent;

  public GitHubBindingBuilder() {
    this(new GitHubBinding());
  }
  
  public GitHubBindingBuilder(GitHubBindingFluent<?> fluent) {
    this(fluent, new GitHubBinding());
  }
  
  public GitHubBindingBuilder(GitHubBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubBindingBuilder(GitHubBindingFluent<?> fluent,GitHubBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubBinding build() {
    GitHubBinding buildable = new GitHubBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}