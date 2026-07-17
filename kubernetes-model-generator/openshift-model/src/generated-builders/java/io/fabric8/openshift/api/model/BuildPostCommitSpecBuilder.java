package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildPostCommitSpecBuilder extends BuildPostCommitSpecFluent<BuildPostCommitSpecBuilder> implements VisitableBuilder<BuildPostCommitSpec,BuildPostCommitSpecBuilder>{

  BuildPostCommitSpecFluent<?> fluent;

  public BuildPostCommitSpecBuilder() {
    this(new BuildPostCommitSpec());
  }
  
  public BuildPostCommitSpecBuilder(BuildPostCommitSpecFluent<?> fluent) {
    this(fluent, new BuildPostCommitSpec());
  }
  
  public BuildPostCommitSpecBuilder(BuildPostCommitSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildPostCommitSpecBuilder(BuildPostCommitSpecFluent<?> fluent,BuildPostCommitSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildPostCommitSpec build() {
    BuildPostCommitSpec buildable = new BuildPostCommitSpec(fluent.getArgs(), fluent.getCommand(), fluent.getScript());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}