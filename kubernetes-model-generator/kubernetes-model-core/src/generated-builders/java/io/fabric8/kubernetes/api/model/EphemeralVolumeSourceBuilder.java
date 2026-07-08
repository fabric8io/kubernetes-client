package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EphemeralVolumeSourceBuilder extends EphemeralVolumeSourceFluent<EphemeralVolumeSourceBuilder> implements VisitableBuilder<EphemeralVolumeSource,EphemeralVolumeSourceBuilder>{

  EphemeralVolumeSourceFluent<?> fluent;

  public EphemeralVolumeSourceBuilder() {
    this(new EphemeralVolumeSource());
  }
  
  public EphemeralVolumeSourceBuilder(EphemeralVolumeSourceFluent<?> fluent) {
    this(fluent, new EphemeralVolumeSource());
  }
  
  public EphemeralVolumeSourceBuilder(EphemeralVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EphemeralVolumeSourceBuilder(EphemeralVolumeSourceFluent<?> fluent,EphemeralVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EphemeralVolumeSource build() {
    EphemeralVolumeSource buildable = new EphemeralVolumeSource(fluent.buildVolumeClaimTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}