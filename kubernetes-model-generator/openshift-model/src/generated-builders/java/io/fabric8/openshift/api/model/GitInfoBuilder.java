package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitInfoBuilder extends GitInfoFluent<GitInfoBuilder> implements VisitableBuilder<GitInfo,GitInfoBuilder>{

  GitInfoFluent<?> fluent;

  public GitInfoBuilder() {
    this(new GitInfo());
  }
  
  public GitInfoBuilder(GitInfoFluent<?> fluent) {
    this(fluent, new GitInfo());
  }
  
  public GitInfoBuilder(GitInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitInfoBuilder(GitInfoFluent<?> fluent,GitInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitInfo build() {
    GitInfo buildable = new GitInfo(fluent.buildAuthor(), fluent.getCommit(), fluent.buildCommitter(), fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getMessage(), fluent.getNoProxy(), fluent.getRef(), fluent.buildRefs(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}