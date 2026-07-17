package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabIdentityProviderBuilder extends GitLabIdentityProviderFluent<GitLabIdentityProviderBuilder> implements VisitableBuilder<GitLabIdentityProvider,GitLabIdentityProviderBuilder>{

  GitLabIdentityProviderFluent<?> fluent;

  public GitLabIdentityProviderBuilder() {
    this(new GitLabIdentityProvider());
  }
  
  public GitLabIdentityProviderBuilder(GitLabIdentityProviderFluent<?> fluent) {
    this(fluent, new GitLabIdentityProvider());
  }
  
  public GitLabIdentityProviderBuilder(GitLabIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabIdentityProviderBuilder(GitLabIdentityProviderFluent<?> fluent,GitLabIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabIdentityProvider build() {
    GitLabIdentityProvider buildable = new GitLabIdentityProvider(fluent.buildCa(), fluent.getClientID(), fluent.buildClientSecret(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}