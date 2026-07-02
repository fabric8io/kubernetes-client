package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalVolumeSourceBuilder extends LocalVolumeSourceFluent<LocalVolumeSourceBuilder> implements VisitableBuilder<LocalVolumeSource,LocalVolumeSourceBuilder>{

  LocalVolumeSourceFluent<?> fluent;

  public LocalVolumeSourceBuilder() {
    this(new LocalVolumeSource());
  }
  
  public LocalVolumeSourceBuilder(LocalVolumeSourceFluent<?> fluent) {
    this(fluent, new LocalVolumeSource());
  }
  
  public LocalVolumeSourceBuilder(LocalVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalVolumeSourceBuilder(LocalVolumeSourceFluent<?> fluent,LocalVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalVolumeSource build() {
    LocalVolumeSource buildable = new LocalVolumeSource(fluent.getFsType(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}