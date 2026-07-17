package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildStatusOutputToBuilder extends BuildStatusOutputToFluent<BuildStatusOutputToBuilder> implements VisitableBuilder<BuildStatusOutputTo,BuildStatusOutputToBuilder>{

  BuildStatusOutputToFluent<?> fluent;

  public BuildStatusOutputToBuilder() {
    this(new BuildStatusOutputTo());
  }
  
  public BuildStatusOutputToBuilder(BuildStatusOutputToFluent<?> fluent) {
    this(fluent, new BuildStatusOutputTo());
  }
  
  public BuildStatusOutputToBuilder(BuildStatusOutputTo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildStatusOutputToBuilder(BuildStatusOutputToFluent<?> fluent,BuildStatusOutputTo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildStatusOutputTo build() {
    BuildStatusOutputTo buildable = new BuildStatusOutputTo(fluent.getImageDigest());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}