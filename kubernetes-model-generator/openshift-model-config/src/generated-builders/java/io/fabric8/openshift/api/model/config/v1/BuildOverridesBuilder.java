package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildOverridesBuilder extends BuildOverridesFluent<BuildOverridesBuilder> implements VisitableBuilder<BuildOverrides,BuildOverridesBuilder>{

  BuildOverridesFluent<?> fluent;

  public BuildOverridesBuilder() {
    this(new BuildOverrides());
  }
  
  public BuildOverridesBuilder(BuildOverridesFluent<?> fluent) {
    this(fluent, new BuildOverrides());
  }
  
  public BuildOverridesBuilder(BuildOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildOverridesBuilder(BuildOverridesFluent<?> fluent,BuildOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildOverrides build() {
    BuildOverrides buildable = new BuildOverrides(fluent.getForcePull(), fluent.buildImageLabels(), fluent.getNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}