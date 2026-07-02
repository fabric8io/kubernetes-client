package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NFSVolumeSourceBuilder extends NFSVolumeSourceFluent<NFSVolumeSourceBuilder> implements VisitableBuilder<NFSVolumeSource,NFSVolumeSourceBuilder>{

  NFSVolumeSourceFluent<?> fluent;

  public NFSVolumeSourceBuilder() {
    this(new NFSVolumeSource());
  }
  
  public NFSVolumeSourceBuilder(NFSVolumeSourceFluent<?> fluent) {
    this(fluent, new NFSVolumeSource());
  }
  
  public NFSVolumeSourceBuilder(NFSVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NFSVolumeSourceBuilder(NFSVolumeSourceFluent<?> fluent,NFSVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NFSVolumeSource build() {
    NFSVolumeSource buildable = new NFSVolumeSource(fluent.getPath(), fluent.getReadOnly(), fluent.getServer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}