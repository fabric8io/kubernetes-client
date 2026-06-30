package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GitRepoVolumeSourceBuilder extends GitRepoVolumeSourceFluent<GitRepoVolumeSourceBuilder> implements VisitableBuilder<GitRepoVolumeSource,GitRepoVolumeSourceBuilder>{

  GitRepoVolumeSourceFluent<?> fluent;

  public GitRepoVolumeSourceBuilder() {
    this(new GitRepoVolumeSource());
  }
  
  public GitRepoVolumeSourceBuilder(GitRepoVolumeSourceFluent<?> fluent) {
    this(fluent, new GitRepoVolumeSource());
  }
  
  public GitRepoVolumeSourceBuilder(GitRepoVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GitRepoVolumeSourceBuilder(GitRepoVolumeSourceFluent<?> fluent,GitRepoVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GitRepoVolumeSource build() {
    GitRepoVolumeSource buildable = new GitRepoVolumeSource(fluent.getDirectory(), fluent.getRepository(), fluent.getRevision());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}