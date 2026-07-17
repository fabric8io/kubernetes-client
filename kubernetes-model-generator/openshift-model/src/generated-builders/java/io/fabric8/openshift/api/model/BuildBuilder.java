package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildBuilder extends BuildFluent<BuildBuilder> implements VisitableBuilder<Build,BuildBuilder>{

  BuildFluent<?> fluent;

  public BuildBuilder() {
    this(new Build());
  }
  
  public BuildBuilder(BuildFluent<?> fluent) {
    this(fluent, new Build());
  }
  
  public BuildBuilder(Build instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildBuilder(BuildFluent<?> fluent,Build instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Build build() {
    Build buildable = new Build(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}