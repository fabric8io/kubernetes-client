package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlexVolumeSourceBuilder extends FlexVolumeSourceFluent<FlexVolumeSourceBuilder> implements VisitableBuilder<FlexVolumeSource,FlexVolumeSourceBuilder>{

  FlexVolumeSourceFluent<?> fluent;

  public FlexVolumeSourceBuilder() {
    this(new FlexVolumeSource());
  }
  
  public FlexVolumeSourceBuilder(FlexVolumeSourceFluent<?> fluent) {
    this(fluent, new FlexVolumeSource());
  }
  
  public FlexVolumeSourceBuilder(FlexVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlexVolumeSourceBuilder(FlexVolumeSourceFluent<?> fluent,FlexVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlexVolumeSource build() {
    FlexVolumeSource buildable = new FlexVolumeSource(fluent.getDriver(), fluent.getFsType(), fluent.getOptions(), fluent.getReadOnly(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}