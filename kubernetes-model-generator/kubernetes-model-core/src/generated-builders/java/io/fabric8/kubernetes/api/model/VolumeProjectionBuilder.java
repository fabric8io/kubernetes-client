package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeProjectionBuilder extends VolumeProjectionFluent<VolumeProjectionBuilder> implements VisitableBuilder<VolumeProjection,VolumeProjectionBuilder>{

  VolumeProjectionFluent<?> fluent;

  public VolumeProjectionBuilder() {
    this(new VolumeProjection());
  }
  
  public VolumeProjectionBuilder(VolumeProjectionFluent<?> fluent) {
    this(fluent, new VolumeProjection());
  }
  
  public VolumeProjectionBuilder(VolumeProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeProjectionBuilder(VolumeProjectionFluent<?> fluent,VolumeProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeProjection build() {
    VolumeProjection buildable = new VolumeProjection(fluent.buildClusterTrustBundle(), fluent.buildConfigMap(), fluent.buildDownwardAPI(), fluent.buildPodCertificate(), fluent.buildSecret(), fluent.buildServiceAccountToken());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}