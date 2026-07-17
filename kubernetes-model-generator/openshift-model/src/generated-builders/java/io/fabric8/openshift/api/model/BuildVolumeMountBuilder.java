package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildVolumeMountBuilder extends BuildVolumeMountFluent<BuildVolumeMountBuilder> implements VisitableBuilder<BuildVolumeMount,BuildVolumeMountBuilder>{

  BuildVolumeMountFluent<?> fluent;

  public BuildVolumeMountBuilder() {
    this(new BuildVolumeMount());
  }
  
  public BuildVolumeMountBuilder(BuildVolumeMountFluent<?> fluent) {
    this(fluent, new BuildVolumeMount());
  }
  
  public BuildVolumeMountBuilder(BuildVolumeMount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildVolumeMountBuilder(BuildVolumeMountFluent<?> fluent,BuildVolumeMount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildVolumeMount build() {
    BuildVolumeMount buildable = new BuildVolumeMount(fluent.getDestinationPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}