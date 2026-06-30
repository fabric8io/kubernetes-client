package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlusterfsVolumeSourceBuilder extends GlusterfsVolumeSourceFluent<GlusterfsVolumeSourceBuilder> implements VisitableBuilder<GlusterfsVolumeSource,GlusterfsVolumeSourceBuilder>{

  GlusterfsVolumeSourceFluent<?> fluent;

  public GlusterfsVolumeSourceBuilder() {
    this(new GlusterfsVolumeSource());
  }
  
  public GlusterfsVolumeSourceBuilder(GlusterfsVolumeSourceFluent<?> fluent) {
    this(fluent, new GlusterfsVolumeSource());
  }
  
  public GlusterfsVolumeSourceBuilder(GlusterfsVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlusterfsVolumeSourceBuilder(GlusterfsVolumeSourceFluent<?> fluent,GlusterfsVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlusterfsVolumeSource build() {
    GlusterfsVolumeSource buildable = new GlusterfsVolumeSource(fluent.getEndpoints(), fluent.getPath(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}