package io.fabric8.knative.bindings.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabBindingSpecBuilder extends GitLabBindingSpecFluent<GitLabBindingSpecBuilder> implements VisitableBuilder<GitLabBindingSpec,GitLabBindingSpecBuilder>{

  GitLabBindingSpecFluent<?> fluent;

  public GitLabBindingSpecBuilder() {
    this(new GitLabBindingSpec());
  }
  
  public GitLabBindingSpecBuilder(GitLabBindingSpecFluent<?> fluent) {
    this(fluent, new GitLabBindingSpec());
  }
  
  public GitLabBindingSpecBuilder(GitLabBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabBindingSpecBuilder(GitLabBindingSpecFluent<?> fluent,GitLabBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabBindingSpec build() {
    GitLabBindingSpec buildable = new GitLabBindingSpec(fluent.buildAccessToken(), fluent.buildSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}