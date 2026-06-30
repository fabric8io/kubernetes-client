package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CinderVolumeSourceBuilder extends CinderVolumeSourceFluent<CinderVolumeSourceBuilder> implements VisitableBuilder<CinderVolumeSource,CinderVolumeSourceBuilder>{

  CinderVolumeSourceFluent<?> fluent;

  public CinderVolumeSourceBuilder() {
    this(new CinderVolumeSource());
  }
  
  public CinderVolumeSourceBuilder(CinderVolumeSourceFluent<?> fluent) {
    this(fluent, new CinderVolumeSource());
  }
  
  public CinderVolumeSourceBuilder(CinderVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CinderVolumeSourceBuilder(CinderVolumeSourceFluent<?> fluent,CinderVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CinderVolumeSource build() {
    CinderVolumeSource buildable = new CinderVolumeSource(fluent.getFsType(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getVolumeID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}