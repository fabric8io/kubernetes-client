package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ISCSIVolumeSourceBuilder extends ISCSIVolumeSourceFluent<ISCSIVolumeSourceBuilder> implements VisitableBuilder<ISCSIVolumeSource,ISCSIVolumeSourceBuilder>{

  ISCSIVolumeSourceFluent<?> fluent;

  public ISCSIVolumeSourceBuilder() {
    this(new ISCSIVolumeSource());
  }
  
  public ISCSIVolumeSourceBuilder(ISCSIVolumeSourceFluent<?> fluent) {
    this(fluent, new ISCSIVolumeSource());
  }
  
  public ISCSIVolumeSourceBuilder(ISCSIVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ISCSIVolumeSourceBuilder(ISCSIVolumeSourceFluent<?> fluent,ISCSIVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ISCSIVolumeSource build() {
    ISCSIVolumeSource buildable = new ISCSIVolumeSource(fluent.getChapAuthDiscovery(), fluent.getChapAuthSession(), fluent.getFsType(), fluent.getInitiatorName(), fluent.getIqn(), fluent.getIscsiInterface(), fluent.getLun(), fluent.getPortals(), fluent.getReadOnly(), fluent.buildSecretRef(), fluent.getTargetPortal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}