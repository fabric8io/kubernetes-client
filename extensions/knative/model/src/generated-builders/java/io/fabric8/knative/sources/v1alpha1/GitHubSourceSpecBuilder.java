package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitHubSourceSpecBuilder extends GitHubSourceSpecFluent<GitHubSourceSpecBuilder> implements VisitableBuilder<GitHubSourceSpec,GitHubSourceSpecBuilder>{

  GitHubSourceSpecFluent<?> fluent;

  public GitHubSourceSpecBuilder() {
    this(new GitHubSourceSpec());
  }
  
  public GitHubSourceSpecBuilder(GitHubSourceSpecFluent<?> fluent) {
    this(fluent, new GitHubSourceSpec());
  }
  
  public GitHubSourceSpecBuilder(GitHubSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitHubSourceSpecBuilder(GitHubSourceSpecFluent<?> fluent,GitHubSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitHubSourceSpec build() {
    GitHubSourceSpec buildable = new GitHubSourceSpec(fluent.buildAccessToken(), fluent.buildCeOverrides(), fluent.getEventTypes(), fluent.getGithubAPIURL(), fluent.getOwnerAndRepository(), fluent.buildSecretToken(), fluent.getSecure(), fluent.getServiceAccountName(), fluent.buildSink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}