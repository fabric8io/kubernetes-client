package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitBuildSourceBuilder extends GitBuildSourceFluent<GitBuildSourceBuilder> implements VisitableBuilder<GitBuildSource,GitBuildSourceBuilder>{

  GitBuildSourceFluent<?> fluent;

  public GitBuildSourceBuilder() {
    this(new GitBuildSource());
  }
  
  public GitBuildSourceBuilder(GitBuildSourceFluent<?> fluent) {
    this(fluent, new GitBuildSource());
  }
  
  public GitBuildSourceBuilder(GitBuildSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitBuildSourceBuilder(GitBuildSourceFluent<?> fluent,GitBuildSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitBuildSource build() {
    GitBuildSource buildable = new GitBuildSource(fluent.getHttpProxy(), fluent.getHttpsProxy(), fluent.getNoProxy(), fluent.getRef(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}