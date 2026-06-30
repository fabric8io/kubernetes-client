package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlusterfsPersistentVolumeSourceBuilder extends GlusterfsPersistentVolumeSourceFluent<GlusterfsPersistentVolumeSourceBuilder> implements VisitableBuilder<GlusterfsPersistentVolumeSource,GlusterfsPersistentVolumeSourceBuilder>{

  GlusterfsPersistentVolumeSourceFluent<?> fluent;

  public GlusterfsPersistentVolumeSourceBuilder() {
    this(new GlusterfsPersistentVolumeSource());
  }
  
  public GlusterfsPersistentVolumeSourceBuilder(GlusterfsPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new GlusterfsPersistentVolumeSource());
  }
  
  public GlusterfsPersistentVolumeSourceBuilder(GlusterfsPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlusterfsPersistentVolumeSourceBuilder(GlusterfsPersistentVolumeSourceFluent<?> fluent,GlusterfsPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlusterfsPersistentVolumeSource build() {
    GlusterfsPersistentVolumeSource buildable = new GlusterfsPersistentVolumeSource(fluent.getEndpoints(), fluent.getEndpointsNamespace(), fluent.getPath(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}