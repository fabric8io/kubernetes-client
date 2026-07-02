package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RootPathsBuilder extends RootPathsFluent<RootPathsBuilder> implements VisitableBuilder<RootPaths,RootPathsBuilder>{

  RootPathsFluent<?> fluent;

  public RootPathsBuilder() {
    this(new RootPaths());
  }
  
  public RootPathsBuilder(RootPathsFluent<?> fluent) {
    this(fluent, new RootPaths());
  }
  
  public RootPathsBuilder(RootPaths instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RootPathsBuilder(RootPathsFluent<?> fluent,RootPaths instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RootPaths build() {
    RootPaths buildable = new RootPaths(fluent.getPaths());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}