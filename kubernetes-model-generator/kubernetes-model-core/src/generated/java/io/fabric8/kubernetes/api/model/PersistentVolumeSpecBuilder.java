package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PersistentVolumeSpecBuilder extends PersistentVolumeSpecFluent<PersistentVolumeSpecBuilder> implements VisitableBuilder<PersistentVolumeSpec,PersistentVolumeSpecBuilder>{

  PersistentVolumeSpecFluent<?> fluent;

  public PersistentVolumeSpecBuilder() {
    this(new PersistentVolumeSpec());
  }
  
  public PersistentVolumeSpecBuilder(PersistentVolumeSpecFluent<?> fluent) {
    this(fluent, new PersistentVolumeSpec());
  }
  
  public PersistentVolumeSpecBuilder(PersistentVolumeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PersistentVolumeSpecBuilder(PersistentVolumeSpecFluent<?> fluent,PersistentVolumeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PersistentVolumeSpec build() {
    PersistentVolumeSpec buildable = new PersistentVolumeSpec(fluent.getAccessModes(), fluent.buildAwsElasticBlockStore(), fluent.buildAzureDisk(), fluent.buildAzureFile(), fluent.getCapacity(), fluent.buildCephfs(), fluent.buildCinder(), fluent.buildClaimRef(), fluent.buildCsi(), fluent.buildFc(), fluent.buildFlexVolume(), fluent.buildFlocker(), fluent.buildGcePersistentDisk(), fluent.buildGlusterfs(), fluent.buildHostPath(), fluent.buildIscsi(), fluent.buildLocal(), fluent.getMountOptions(), fluent.buildNfs(), fluent.buildNodeAffinity(), fluent.getPersistentVolumeReclaimPolicy(), fluent.buildPhotonPersistentDisk(), fluent.buildPortworxVolume(), fluent.buildQuobyte(), fluent.buildRbd(), fluent.buildScaleIO(), fluent.getStorageClassName(), fluent.buildStorageos(), fluent.getVolumeAttributesClassName(), fluent.getVolumeMode(), fluent.buildVsphereVolume());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}