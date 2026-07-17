package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildConfigStatusBuilder extends BuildConfigStatusFluent<BuildConfigStatusBuilder> implements VisitableBuilder<BuildConfigStatus,BuildConfigStatusBuilder>{

  BuildConfigStatusFluent<?> fluent;

  public BuildConfigStatusBuilder() {
    this(new BuildConfigStatus());
  }
  
  public BuildConfigStatusBuilder(BuildConfigStatusFluent<?> fluent) {
    this(fluent, new BuildConfigStatus());
  }
  
  public BuildConfigStatusBuilder(BuildConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildConfigStatusBuilder(BuildConfigStatusFluent<?> fluent,BuildConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildConfigStatus build() {
    BuildConfigStatus buildable = new BuildConfigStatus(fluent.buildImageChangeTriggers(), fluent.getLastVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}