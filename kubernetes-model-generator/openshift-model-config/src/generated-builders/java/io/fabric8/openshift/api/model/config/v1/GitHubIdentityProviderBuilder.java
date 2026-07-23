package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubIdentityProviderBuilder extends GitHubIdentityProviderFluent<GitHubIdentityProviderBuilder> implements VisitableBuilder<GitHubIdentityProvider,GitHubIdentityProviderBuilder>{

  GitHubIdentityProviderFluent<?> fluent;

  public GitHubIdentityProviderBuilder() {
    this(new GitHubIdentityProvider());
  }
  
  public GitHubIdentityProviderBuilder(GitHubIdentityProviderFluent<?> fluent) {
    this(fluent, new GitHubIdentityProvider());
  }
  
  public GitHubIdentityProviderBuilder(GitHubIdentityProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubIdentityProviderBuilder(GitHubIdentityProviderFluent<?> fluent,GitHubIdentityProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubIdentityProvider build() {
    GitHubIdentityProvider buildable = new GitHubIdentityProvider(fluent.buildCa(), fluent.getClientID(), fluent.buildClientSecret(), fluent.getHostname(), fluent.getOrganizations(), fluent.getTeams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}