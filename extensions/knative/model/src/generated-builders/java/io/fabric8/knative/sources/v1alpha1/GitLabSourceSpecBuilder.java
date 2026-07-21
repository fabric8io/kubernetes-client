package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitLabSourceSpecBuilder extends GitLabSourceSpecFluent<GitLabSourceSpecBuilder> implements VisitableBuilder<GitLabSourceSpec,GitLabSourceSpecBuilder>{

  GitLabSourceSpecFluent<?> fluent;

  public GitLabSourceSpecBuilder() {
    this(new GitLabSourceSpec());
  }
  
  public GitLabSourceSpecBuilder(GitLabSourceSpecFluent<?> fluent) {
    this(fluent, new GitLabSourceSpec());
  }
  
  public GitLabSourceSpecBuilder(GitLabSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitLabSourceSpecBuilder(GitLabSourceSpecFluent<?> fluent,GitLabSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitLabSourceSpec build() {
    GitLabSourceSpec buildable = new GitLabSourceSpec(fluent.buildAccessToken(), fluent.buildCeOverrides(), fluent.getEventTypes(), fluent.getProjectUrl(), fluent.buildSecretToken(), fluent.getServiceAccountName(), fluent.buildSink(), fluent.getSslverify());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}