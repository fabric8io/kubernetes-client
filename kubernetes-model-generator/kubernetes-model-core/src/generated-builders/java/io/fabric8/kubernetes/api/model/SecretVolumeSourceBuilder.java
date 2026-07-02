package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretVolumeSourceBuilder extends SecretVolumeSourceFluent<SecretVolumeSourceBuilder> implements VisitableBuilder<SecretVolumeSource,SecretVolumeSourceBuilder>{

  SecretVolumeSourceFluent<?> fluent;

  public SecretVolumeSourceBuilder() {
    this(new SecretVolumeSource());
  }
  
  public SecretVolumeSourceBuilder(SecretVolumeSourceFluent<?> fluent) {
    this(fluent, new SecretVolumeSource());
  }
  
  public SecretVolumeSourceBuilder(SecretVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretVolumeSourceBuilder(SecretVolumeSourceFluent<?> fluent,SecretVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretVolumeSource build() {
    SecretVolumeSource buildable = new SecretVolumeSource(fluent.getDefaultMode(), fluent.buildItems(), fluent.getOptional(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}