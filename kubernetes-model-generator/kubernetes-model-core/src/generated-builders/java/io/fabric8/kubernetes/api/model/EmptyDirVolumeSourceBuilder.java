package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmptyDirVolumeSourceBuilder extends EmptyDirVolumeSourceFluent<EmptyDirVolumeSourceBuilder> implements VisitableBuilder<EmptyDirVolumeSource,EmptyDirVolumeSourceBuilder>{

  EmptyDirVolumeSourceFluent<?> fluent;

  public EmptyDirVolumeSourceBuilder() {
    this(new EmptyDirVolumeSource());
  }
  
  public EmptyDirVolumeSourceBuilder(EmptyDirVolumeSourceFluent<?> fluent) {
    this(fluent, new EmptyDirVolumeSource());
  }
  
  public EmptyDirVolumeSourceBuilder(EmptyDirVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmptyDirVolumeSourceBuilder(EmptyDirVolumeSourceFluent<?> fluent,EmptyDirVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmptyDirVolumeSource build() {
    EmptyDirVolumeSource buildable = new EmptyDirVolumeSource(fluent.getMedium(), fluent.buildSizeLimit());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}