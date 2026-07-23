package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubBindingSpecBuilder extends GitHubBindingSpecFluent<GitHubBindingSpecBuilder> implements VisitableBuilder<GitHubBindingSpec,GitHubBindingSpecBuilder>{

  GitHubBindingSpecFluent<?> fluent;

  public GitHubBindingSpecBuilder() {
    this(new GitHubBindingSpec());
  }
  
  public GitHubBindingSpecBuilder(GitHubBindingSpecFluent<?> fluent) {
    this(fluent, new GitHubBindingSpec());
  }
  
  public GitHubBindingSpecBuilder(GitHubBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubBindingSpecBuilder(GitHubBindingSpecFluent<?> fluent,GitHubBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubBindingSpec build() {
    GitHubBindingSpec buildable = new GitHubBindingSpec(fluent.buildAccessToken(), fluent.buildSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}