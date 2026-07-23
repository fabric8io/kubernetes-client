package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildSourceBuilder extends BuildSourceFluent<BuildSourceBuilder> implements VisitableBuilder<BuildSource,BuildSourceBuilder>{

  BuildSourceFluent<?> fluent;

  public BuildSourceBuilder() {
    this(new BuildSource());
  }
  
  public BuildSourceBuilder(BuildSourceFluent<?> fluent) {
    this(fluent, new BuildSource());
  }
  
  public BuildSourceBuilder(BuildSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildSourceBuilder(BuildSourceFluent<?> fluent,BuildSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildSource build() {
    BuildSource buildable = new BuildSource(fluent.buildBinary(), fluent.buildConfigMaps(), fluent.getContextDir(), fluent.getDockerfile(), fluent.buildGit(), fluent.buildImages(), fluent.buildSecrets(), fluent.buildSourceSecret(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}