package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildVolumeSourceBuilder extends BuildVolumeSourceFluent<BuildVolumeSourceBuilder> implements VisitableBuilder<BuildVolumeSource,BuildVolumeSourceBuilder>{

  BuildVolumeSourceFluent<?> fluent;

  public BuildVolumeSourceBuilder() {
    this(new BuildVolumeSource());
  }
  
  public BuildVolumeSourceBuilder(BuildVolumeSourceFluent<?> fluent) {
    this(fluent, new BuildVolumeSource());
  }
  
  public BuildVolumeSourceBuilder(BuildVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildVolumeSourceBuilder(BuildVolumeSourceFluent<?> fluent,BuildVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildVolumeSource build() {
    BuildVolumeSource buildable = new BuildVolumeSource(fluent.getConfigMap(), fluent.getCsi(), fluent.getSecret(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}