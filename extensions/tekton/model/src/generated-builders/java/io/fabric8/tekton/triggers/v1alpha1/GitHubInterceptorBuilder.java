package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubInterceptorBuilder extends GitHubInterceptorFluent<GitHubInterceptorBuilder> implements VisitableBuilder<GitHubInterceptor,GitHubInterceptorBuilder>{

  GitHubInterceptorFluent<?> fluent;

  public GitHubInterceptorBuilder() {
    this(new GitHubInterceptor());
  }
  
  public GitHubInterceptorBuilder(GitHubInterceptorFluent<?> fluent) {
    this(fluent, new GitHubInterceptor());
  }
  
  public GitHubInterceptorBuilder(GitHubInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubInterceptorBuilder(GitHubInterceptorFluent<?> fluent,GitHubInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubInterceptor build() {
    GitHubInterceptor buildable = new GitHubInterceptor(fluent.getEventTypes(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}