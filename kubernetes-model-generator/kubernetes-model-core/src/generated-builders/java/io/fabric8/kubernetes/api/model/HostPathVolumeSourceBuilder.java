package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostPathVolumeSourceBuilder extends HostPathVolumeSourceFluent<HostPathVolumeSourceBuilder> implements VisitableBuilder<HostPathVolumeSource,HostPathVolumeSourceBuilder>{

  HostPathVolumeSourceFluent<?> fluent;

  public HostPathVolumeSourceBuilder() {
    this(new HostPathVolumeSource());
  }
  
  public HostPathVolumeSourceBuilder(HostPathVolumeSourceFluent<?> fluent) {
    this(fluent, new HostPathVolumeSource());
  }
  
  public HostPathVolumeSourceBuilder(HostPathVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostPathVolumeSourceBuilder(HostPathVolumeSourceFluent<?> fluent,HostPathVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostPathVolumeSource build() {
    HostPathVolumeSource buildable = new HostPathVolumeSource(fluent.getPath(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}