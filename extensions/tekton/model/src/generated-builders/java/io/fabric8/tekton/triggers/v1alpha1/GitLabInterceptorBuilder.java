package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabInterceptorBuilder extends GitLabInterceptorFluent<GitLabInterceptorBuilder> implements VisitableBuilder<GitLabInterceptor,GitLabInterceptorBuilder>{

  GitLabInterceptorFluent<?> fluent;

  public GitLabInterceptorBuilder() {
    this(new GitLabInterceptor());
  }
  
  public GitLabInterceptorBuilder(GitLabInterceptorFluent<?> fluent) {
    this(fluent, new GitLabInterceptor());
  }
  
  public GitLabInterceptorBuilder(GitLabInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabInterceptorBuilder(GitLabInterceptorFluent<?> fluent,GitLabInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabInterceptor build() {
    GitLabInterceptor buildable = new GitLabInterceptor(fluent.getEventTypes(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}