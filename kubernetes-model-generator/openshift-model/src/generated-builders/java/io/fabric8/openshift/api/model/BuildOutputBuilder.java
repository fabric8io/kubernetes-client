package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildOutputBuilder extends BuildOutputFluent<BuildOutputBuilder> implements VisitableBuilder<BuildOutput,BuildOutputBuilder>{

  BuildOutputFluent<?> fluent;

  public BuildOutputBuilder() {
    this(new BuildOutput());
  }
  
  public BuildOutputBuilder(BuildOutputFluent<?> fluent) {
    this(fluent, new BuildOutput());
  }
  
  public BuildOutputBuilder(BuildOutput instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildOutputBuilder(BuildOutputFluent<?> fluent,BuildOutput instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildOutput build() {
    BuildOutput buildable = new BuildOutput(fluent.buildImageLabels(), fluent.buildPushSecret(), fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}