package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodVolumeHealthBuilder extends PodVolumeHealthFluent<PodVolumeHealthBuilder> implements VisitableBuilder<PodVolumeHealth,PodVolumeHealthBuilder>{

  PodVolumeHealthFluent<?> fluent;

  public PodVolumeHealthBuilder() {
    this(new PodVolumeHealth());
  }
  
  public PodVolumeHealthBuilder(PodVolumeHealthFluent<?> fluent) {
    this(fluent, new PodVolumeHealth());
  }
  
  public PodVolumeHealthBuilder(PodVolumeHealth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodVolumeHealthBuilder(PodVolumeHealthFluent<?> fluent,PodVolumeHealth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodVolumeHealth build() {
    PodVolumeHealth buildable = new PodVolumeHealth(fluent.buildHealthConditions(), fluent.getLastTransitionTime(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}