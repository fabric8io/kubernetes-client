package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlexPersistentVolumeSourceBuilder extends FlexPersistentVolumeSourceFluent<FlexPersistentVolumeSourceBuilder> implements VisitableBuilder<FlexPersistentVolumeSource,FlexPersistentVolumeSourceBuilder>{

  FlexPersistentVolumeSourceFluent<?> fluent;

  public FlexPersistentVolumeSourceBuilder() {
    this(new FlexPersistentVolumeSource());
  }
  
  public FlexPersistentVolumeSourceBuilder(FlexPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new FlexPersistentVolumeSource());
  }
  
  public FlexPersistentVolumeSourceBuilder(FlexPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlexPersistentVolumeSourceBuilder(FlexPersistentVolumeSourceFluent<?> fluent,FlexPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlexPersistentVolumeSource build() {
    FlexPersistentVolumeSource buildable = new FlexPersistentVolumeSource(fluent.getDriver(), fluent.getFsType(), fluent.getOptions(), fluent.getReadOnly(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}