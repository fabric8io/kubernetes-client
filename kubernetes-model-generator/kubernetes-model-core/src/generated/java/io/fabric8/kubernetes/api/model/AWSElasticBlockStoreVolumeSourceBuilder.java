package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSElasticBlockStoreVolumeSourceBuilder extends AWSElasticBlockStoreVolumeSourceFluent<AWSElasticBlockStoreVolumeSourceBuilder> implements VisitableBuilder<AWSElasticBlockStoreVolumeSource,AWSElasticBlockStoreVolumeSourceBuilder>{

  AWSElasticBlockStoreVolumeSourceFluent<?> fluent;

  public AWSElasticBlockStoreVolumeSourceBuilder() {
    this(new AWSElasticBlockStoreVolumeSource());
  }
  
  public AWSElasticBlockStoreVolumeSourceBuilder(AWSElasticBlockStoreVolumeSourceFluent<?> fluent) {
    this(fluent, new AWSElasticBlockStoreVolumeSource());
  }
  
  public AWSElasticBlockStoreVolumeSourceBuilder(AWSElasticBlockStoreVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSElasticBlockStoreVolumeSourceBuilder(AWSElasticBlockStoreVolumeSourceFluent<?> fluent,AWSElasticBlockStoreVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSElasticBlockStoreVolumeSource build() {
    AWSElasticBlockStoreVolumeSource buildable = new AWSElasticBlockStoreVolumeSource(fluent.getFsType(), fluent.getPartition(), fluent.getReadOnly(), fluent.getVolumeID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}