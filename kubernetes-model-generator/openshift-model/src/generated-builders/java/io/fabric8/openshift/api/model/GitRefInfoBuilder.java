package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitRefInfoBuilder extends GitRefInfoFluent<GitRefInfoBuilder> implements VisitableBuilder<GitRefInfo,GitRefInfoBuilder>{

  GitRefInfoFluent<?> fluent;

  public GitRefInfoBuilder() {
    this(new GitRefInfo());
  }
  
  public GitRefInfoBuilder(GitRefInfoFluent<?> fluent) {
    this(fluent, new GitRefInfo());
  }
  
  public GitRefInfoBuilder(GitRefInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitRefInfoBuilder(GitRefInfoFluent<?> fluent,GitRefInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitRefInfo build() {
    GitRefInfo buildable = new GitRefInfo(fluent.buildAuthor(), fluent.getCommit(), fluent.buildCommitter(), fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getMessage(), fluent.getNoProxy(), fluent.getRef(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}