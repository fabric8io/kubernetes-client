package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIPersistentVolumeSourceBuilder extends CSIPersistentVolumeSourceFluent<CSIPersistentVolumeSourceBuilder> implements VisitableBuilder<CSIPersistentVolumeSource,CSIPersistentVolumeSourceBuilder>{

  CSIPersistentVolumeSourceFluent<?> fluent;

  public CSIPersistentVolumeSourceBuilder() {
    this(new CSIPersistentVolumeSource());
  }
  
  public CSIPersistentVolumeSourceBuilder(CSIPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new CSIPersistentVolumeSource());
  }
  
  public CSIPersistentVolumeSourceBuilder(CSIPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIPersistentVolumeSourceBuilder(CSIPersistentVolumeSourceFluent<?> fluent,CSIPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIPersistentVolumeSource build() {
    CSIPersistentVolumeSource buildable = new CSIPersistentVolumeSource(fluent.buildControllerExpandSecretRef(), fluent.buildControllerPublishSecretRef(), fluent.getDriver(), fluent.getFsType(), fluent.buildNodeExpandSecretRef(), fluent.buildNodePublishSecretRef(), fluent.buildNodeStageSecretRef(), fluent.getReadOnly(), fluent.getVolumeAttributes(), fluent.getVolumeHandle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}