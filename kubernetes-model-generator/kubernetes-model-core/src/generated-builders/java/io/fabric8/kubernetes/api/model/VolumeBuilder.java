package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeBuilder extends VolumeFluent<VolumeBuilder> implements VisitableBuilder<Volume,VolumeBuilder>{

  VolumeFluent<?> fluent;

  public VolumeBuilder() {
    this(new Volume());
  }
  
  public VolumeBuilder(VolumeFluent<?> fluent) {
    this(fluent, new Volume());
  }
  
  public VolumeBuilder(Volume instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeBuilder(VolumeFluent<?> fluent,Volume instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Volume build() {
    Volume buildable = new Volume(fluent.buildAwsElasticBlockStore(), fluent.buildAzureDisk(), fluent.buildAzureFile(), fluent.buildCephfs(), fluent.buildCinder(), fluent.buildConfigMap(), fluent.buildCsi(), fluent.buildDownwardAPI(), fluent.buildEmptyDir(), fluent.buildEphemeral(), fluent.buildFc(), fluent.buildFlexVolume(), fluent.buildFlocker(), fluent.buildGcePersistentDisk(), fluent.buildGitRepo(), fluent.buildGlusterfs(), fluent.buildHostPath(), fluent.buildImage(), fluent.buildIscsi(), fluent.getName(), fluent.buildNfs(), fluent.buildPersistentVolumeClaim(), fluent.buildPhotonPersistentDisk(), fluent.buildPortworxVolume(), fluent.buildProjected(), fluent.buildQuobyte(), fluent.buildRbd(), fluent.buildScaleIO(), fluent.buildSecret(), fluent.buildStorageos(), fluent.buildVsphereVolume());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}