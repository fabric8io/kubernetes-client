package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimReferenceBuilder extends PersistentVolumeClaimReferenceFluent<PersistentVolumeClaimReferenceBuilder> implements VisitableBuilder<PersistentVolumeClaimReference,PersistentVolumeClaimReferenceBuilder>{

  PersistentVolumeClaimReferenceFluent<?> fluent;

  public PersistentVolumeClaimReferenceBuilder() {
    this(new PersistentVolumeClaimReference());
  }
  
  public PersistentVolumeClaimReferenceBuilder(PersistentVolumeClaimReferenceFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimReference());
  }
  
  public PersistentVolumeClaimReferenceBuilder(PersistentVolumeClaimReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimReferenceBuilder(PersistentVolumeClaimReferenceFluent<?> fluent,PersistentVolumeClaimReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimReference build() {
    PersistentVolumeClaimReference buildable = new PersistentVolumeClaimReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}