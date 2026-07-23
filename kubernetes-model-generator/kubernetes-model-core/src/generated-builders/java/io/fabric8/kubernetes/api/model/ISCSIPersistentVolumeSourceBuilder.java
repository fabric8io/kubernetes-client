package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ISCSIPersistentVolumeSourceBuilder extends ISCSIPersistentVolumeSourceFluent<ISCSIPersistentVolumeSourceBuilder> implements VisitableBuilder<ISCSIPersistentVolumeSource,ISCSIPersistentVolumeSourceBuilder>{

  ISCSIPersistentVolumeSourceFluent<?> fluent;

  public ISCSIPersistentVolumeSourceBuilder() {
    this(new ISCSIPersistentVolumeSource());
  }
  
  public ISCSIPersistentVolumeSourceBuilder(ISCSIPersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new ISCSIPersistentVolumeSource());
  }
  
  public ISCSIPersistentVolumeSourceBuilder(ISCSIPersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ISCSIPersistentVolumeSourceBuilder(ISCSIPersistentVolumeSourceFluent<?> fluent,ISCSIPersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ISCSIPersistentVolumeSource build() {
    ISCSIPersistentVolumeSource buildable = new ISCSIPersistentVolumeSource(fluent.getChapAuthDiscovery(), fluent.getChapAuthSession(), fluent.getFsType(), fluent.getInitiatorName(), fluent.getIqn(), fluent.getIscsiInterface(), fluent.getLun(), fluent.getPortals(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getTargetPortal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}