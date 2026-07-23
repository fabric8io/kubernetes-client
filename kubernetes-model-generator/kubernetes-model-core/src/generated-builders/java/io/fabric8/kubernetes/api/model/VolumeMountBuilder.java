package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeMountBuilder extends VolumeMountFluent<VolumeMountBuilder> implements VisitableBuilder<VolumeMount,VolumeMountBuilder>{

  VolumeMountFluent<?> fluent;

  public VolumeMountBuilder() {
    this(new VolumeMount());
  }
  
  public VolumeMountBuilder(VolumeMountFluent<?> fluent) {
    this(fluent, new VolumeMount());
  }
  
  public VolumeMountBuilder(VolumeMount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeMountBuilder(VolumeMountFluent<?> fluent,VolumeMount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeMount build() {
    VolumeMount buildable = new VolumeMount(fluent.getMountPath(), fluent.getMountPropagation(), fluent.getName(), fluent.getReadOnly(), fluent.getRecursiveReadOnly(), fluent.getSubPath(), fluent.getSubPathExpr());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}