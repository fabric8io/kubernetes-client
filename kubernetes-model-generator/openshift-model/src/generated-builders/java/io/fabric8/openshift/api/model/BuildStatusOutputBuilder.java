package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildStatusOutputBuilder extends BuildStatusOutputFluent<BuildStatusOutputBuilder> implements VisitableBuilder<BuildStatusOutput,BuildStatusOutputBuilder>{

  BuildStatusOutputFluent<?> fluent;

  public BuildStatusOutputBuilder() {
    this(new BuildStatusOutput());
  }
  
  public BuildStatusOutputBuilder(BuildStatusOutputFluent<?> fluent) {
    this(fluent, new BuildStatusOutput());
  }
  
  public BuildStatusOutputBuilder(BuildStatusOutput instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildStatusOutputBuilder(BuildStatusOutputFluent<?> fluent,BuildStatusOutput instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildStatusOutput build() {
    BuildStatusOutput buildable = new BuildStatusOutput(fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}