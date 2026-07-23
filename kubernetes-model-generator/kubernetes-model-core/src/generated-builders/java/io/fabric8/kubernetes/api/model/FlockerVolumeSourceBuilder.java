package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FlockerVolumeSourceBuilder extends FlockerVolumeSourceFluent<FlockerVolumeSourceBuilder> implements VisitableBuilder<FlockerVolumeSource,FlockerVolumeSourceBuilder>{

  FlockerVolumeSourceFluent<?> fluent;

  public FlockerVolumeSourceBuilder() {
    this(new FlockerVolumeSource());
  }
  
  public FlockerVolumeSourceBuilder(FlockerVolumeSourceFluent<?> fluent) {
    this(fluent, new FlockerVolumeSource());
  }
  
  public FlockerVolumeSourceBuilder(FlockerVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FlockerVolumeSourceBuilder(FlockerVolumeSourceFluent<?> fluent,FlockerVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FlockerVolumeSource build() {
    FlockerVolumeSource buildable = new FlockerVolumeSource(fluent.getDatasetName(), fluent.getDatasetUUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}