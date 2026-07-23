package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildSpecBuilder extends BuildSpecFluent<BuildSpecBuilder> implements VisitableBuilder<BuildSpec,BuildSpecBuilder>{

  BuildSpecFluent<?> fluent;

  public BuildSpecBuilder() {
    this(new BuildSpec());
  }
  
  public BuildSpecBuilder(BuildSpecFluent<?> fluent) {
    this(fluent, new BuildSpec());
  }
  
  public BuildSpecBuilder(BuildSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildSpecBuilder(BuildSpecFluent<?> fluent,BuildSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildSpec build() {
    BuildSpec buildable = new BuildSpec(fluent.getCompletionDeadlineSeconds(), fluent.getMountTrustedCA(), fluent.getNodeSelector(), fluent.buildOutput(), fluent.buildPostCommit(), fluent.buildResources(), fluent.buildRevision(), fluent.getServiceAccount(), fluent.buildSource(), fluent.buildStrategy(), fluent.buildTriggeredBy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}