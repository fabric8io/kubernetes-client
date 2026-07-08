package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimBuilder extends PersistentVolumeClaimFluent<PersistentVolumeClaimBuilder> implements VisitableBuilder<PersistentVolumeClaim,PersistentVolumeClaimBuilder>{

  PersistentVolumeClaimFluent<?> fluent;

  public PersistentVolumeClaimBuilder() {
    this(new PersistentVolumeClaim());
  }
  
  public PersistentVolumeClaimBuilder(PersistentVolumeClaimFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaim());
  }
  
  public PersistentVolumeClaimBuilder(PersistentVolumeClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimBuilder(PersistentVolumeClaimFluent<?> fluent,PersistentVolumeClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaim build() {
    PersistentVolumeClaim buildable = new PersistentVolumeClaim(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}