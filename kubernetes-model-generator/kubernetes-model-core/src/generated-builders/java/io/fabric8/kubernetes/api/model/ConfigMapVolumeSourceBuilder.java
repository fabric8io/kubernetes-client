package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapVolumeSourceBuilder extends ConfigMapVolumeSourceFluent<ConfigMapVolumeSourceBuilder> implements VisitableBuilder<ConfigMapVolumeSource,ConfigMapVolumeSourceBuilder>{

  ConfigMapVolumeSourceFluent<?> fluent;

  public ConfigMapVolumeSourceBuilder() {
    this(new ConfigMapVolumeSource());
  }
  
  public ConfigMapVolumeSourceBuilder(ConfigMapVolumeSourceFluent<?> fluent) {
    this(fluent, new ConfigMapVolumeSource());
  }
  
  public ConfigMapVolumeSourceBuilder(ConfigMapVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapVolumeSourceBuilder(ConfigMapVolumeSourceFluent<?> fluent,ConfigMapVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapVolumeSource build() {
    ConfigMapVolumeSource buildable = new ConfigMapVolumeSource(fluent.getDefaultMode(), fluent.buildItems(), fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}