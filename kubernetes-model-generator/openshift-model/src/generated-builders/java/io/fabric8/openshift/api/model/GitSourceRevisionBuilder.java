package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitSourceRevisionBuilder extends GitSourceRevisionFluent<GitSourceRevisionBuilder> implements VisitableBuilder<GitSourceRevision,GitSourceRevisionBuilder>{

  GitSourceRevisionFluent<?> fluent;

  public GitSourceRevisionBuilder() {
    this(new GitSourceRevision());
  }
  
  public GitSourceRevisionBuilder(GitSourceRevisionFluent<?> fluent) {
    this(fluent, new GitSourceRevision());
  }
  
  public GitSourceRevisionBuilder(GitSourceRevision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitSourceRevisionBuilder(GitSourceRevisionFluent<?> fluent,GitSourceRevision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitSourceRevision build() {
    GitSourceRevision buildable = new GitSourceRevision(fluent.buildAuthor(), fluent.getCommit(), fluent.buildCommitter(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}