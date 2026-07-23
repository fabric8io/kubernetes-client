package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildVolumeBuilder extends BuildVolumeFluent<BuildVolumeBuilder> implements VisitableBuilder<BuildVolume,BuildVolumeBuilder>{

  BuildVolumeFluent<?> fluent;

  public BuildVolumeBuilder() {
    this(new BuildVolume());
  }
  
  public BuildVolumeBuilder(BuildVolumeFluent<?> fluent) {
    this(fluent, new BuildVolume());
  }
  
  public BuildVolumeBuilder(BuildVolume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildVolumeBuilder(BuildVolumeFluent<?> fluent,BuildVolume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildVolume build() {
    BuildVolume buildable = new BuildVolume(fluent.buildMounts(), fluent.getName(), fluent.buildSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}