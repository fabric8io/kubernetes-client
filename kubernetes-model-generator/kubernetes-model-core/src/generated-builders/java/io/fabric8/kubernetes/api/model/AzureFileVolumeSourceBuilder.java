package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureFileVolumeSourceBuilder extends AzureFileVolumeSourceFluent<AzureFileVolumeSourceBuilder> implements VisitableBuilder<AzureFileVolumeSource,AzureFileVolumeSourceBuilder>{

  AzureFileVolumeSourceFluent<?> fluent;

  public AzureFileVolumeSourceBuilder() {
    this(new AzureFileVolumeSource());
  }
  
  public AzureFileVolumeSourceBuilder(AzureFileVolumeSourceFluent<?> fluent) {
    this(fluent, new AzureFileVolumeSource());
  }
  
  public AzureFileVolumeSourceBuilder(AzureFileVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureFileVolumeSourceBuilder(AzureFileVolumeSourceFluent<?> fluent,AzureFileVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureFileVolumeSource build() {
    AzureFileVolumeSource buildable = new AzureFileVolumeSource(fluent.getReadOnly(), fluent.getSecretName(), fluent.getShareName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}