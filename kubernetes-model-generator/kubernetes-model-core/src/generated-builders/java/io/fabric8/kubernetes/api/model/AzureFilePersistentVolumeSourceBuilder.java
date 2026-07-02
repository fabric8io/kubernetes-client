package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureFilePersistentVolumeSourceBuilder extends AzureFilePersistentVolumeSourceFluent<AzureFilePersistentVolumeSourceBuilder> implements VisitableBuilder<AzureFilePersistentVolumeSource,AzureFilePersistentVolumeSourceBuilder>{

  AzureFilePersistentVolumeSourceFluent<?> fluent;

  public AzureFilePersistentVolumeSourceBuilder() {
    this(new AzureFilePersistentVolumeSource());
  }
  
  public AzureFilePersistentVolumeSourceBuilder(AzureFilePersistentVolumeSourceFluent<?> fluent) {
    this(fluent, new AzureFilePersistentVolumeSource());
  }
  
  public AzureFilePersistentVolumeSourceBuilder(AzureFilePersistentVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureFilePersistentVolumeSourceBuilder(AzureFilePersistentVolumeSourceFluent<?> fluent,AzureFilePersistentVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureFilePersistentVolumeSource build() {
    AzureFilePersistentVolumeSource buildable = new AzureFilePersistentVolumeSource(fluent.getReadOnly(), fluent.getSecretName(), fluent.getSecretNamespace(), fluent.getShareName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}