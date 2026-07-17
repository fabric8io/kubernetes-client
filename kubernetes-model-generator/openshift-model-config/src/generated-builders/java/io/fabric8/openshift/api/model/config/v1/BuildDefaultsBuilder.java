package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildDefaultsBuilder extends BuildDefaultsFluent<BuildDefaultsBuilder> implements VisitableBuilder<BuildDefaults,BuildDefaultsBuilder>{

  BuildDefaultsFluent<?> fluent;

  public BuildDefaultsBuilder() {
    this(new BuildDefaults());
  }
  
  public BuildDefaultsBuilder(BuildDefaultsFluent<?> fluent) {
    this(fluent, new BuildDefaults());
  }
  
  public BuildDefaultsBuilder(BuildDefaults instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildDefaultsBuilder(BuildDefaultsFluent<?> fluent,BuildDefaults instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildDefaults build() {
    BuildDefaults buildable = new BuildDefaults(fluent.buildDefaultProxy(), fluent.buildEnv(), fluent.buildGitProxy(), fluent.buildImageLabels(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}