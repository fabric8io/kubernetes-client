package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapNodeConfigSourceBuilder extends ConfigMapNodeConfigSourceFluent<ConfigMapNodeConfigSourceBuilder> implements VisitableBuilder<ConfigMapNodeConfigSource,ConfigMapNodeConfigSourceBuilder>{

  ConfigMapNodeConfigSourceFluent<?> fluent;

  public ConfigMapNodeConfigSourceBuilder() {
    this(new ConfigMapNodeConfigSource());
  }
  
  public ConfigMapNodeConfigSourceBuilder(ConfigMapNodeConfigSourceFluent<?> fluent) {
    this(fluent, new ConfigMapNodeConfigSource());
  }
  
  public ConfigMapNodeConfigSourceBuilder(ConfigMapNodeConfigSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapNodeConfigSourceBuilder(ConfigMapNodeConfigSourceFluent<?> fluent,ConfigMapNodeConfigSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapNodeConfigSource build() {
    ConfigMapNodeConfigSource buildable = new ConfigMapNodeConfigSource(fluent.getKubeletConfigKey(), fluent.getName(), fluent.getNamespace(), fluent.getResourceVersion(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}