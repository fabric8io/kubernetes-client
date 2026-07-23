package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapEnvSourceBuilder extends ConfigMapEnvSourceFluent<ConfigMapEnvSourceBuilder> implements VisitableBuilder<ConfigMapEnvSource,ConfigMapEnvSourceBuilder>{

  ConfigMapEnvSourceFluent<?> fluent;

  public ConfigMapEnvSourceBuilder() {
    this(new ConfigMapEnvSource());
  }
  
  public ConfigMapEnvSourceBuilder(ConfigMapEnvSourceFluent<?> fluent) {
    this(fluent, new ConfigMapEnvSource());
  }
  
  public ConfigMapEnvSourceBuilder(ConfigMapEnvSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapEnvSourceBuilder(ConfigMapEnvSourceFluent<?> fluent,ConfigMapEnvSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapEnvSource build() {
    ConfigMapEnvSource buildable = new ConfigMapEnvSource(fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}