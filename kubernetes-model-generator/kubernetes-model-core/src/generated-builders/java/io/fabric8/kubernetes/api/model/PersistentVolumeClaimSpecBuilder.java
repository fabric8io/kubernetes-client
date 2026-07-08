package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeClaimSpecBuilder extends PersistentVolumeClaimSpecFluent<PersistentVolumeClaimSpecBuilder> implements VisitableBuilder<PersistentVolumeClaimSpec,PersistentVolumeClaimSpecBuilder>{

  PersistentVolumeClaimSpecFluent<?> fluent;

  public PersistentVolumeClaimSpecBuilder() {
    this(new PersistentVolumeClaimSpec());
  }
  
  public PersistentVolumeClaimSpecBuilder(PersistentVolumeClaimSpecFluent<?> fluent) {
    this(fluent, new PersistentVolumeClaimSpec());
  }
  
  public PersistentVolumeClaimSpecBuilder(PersistentVolumeClaimSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeClaimSpecBuilder(PersistentVolumeClaimSpecFluent<?> fluent,PersistentVolumeClaimSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeClaimSpec build() {
    PersistentVolumeClaimSpec buildable = new PersistentVolumeClaimSpec(fluent.getAccessModes(), fluent.buildDataSource(), fluent.buildDataSourceRef(), fluent.buildResources(), fluent.buildSelector(), fluent.getStorageClassName(), fluent.getVolumeAttributesClassName(), fluent.getVolumeMode(), fluent.getVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}