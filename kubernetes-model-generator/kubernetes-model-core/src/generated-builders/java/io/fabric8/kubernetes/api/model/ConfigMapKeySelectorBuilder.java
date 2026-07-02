package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapKeySelectorBuilder extends ConfigMapKeySelectorFluent<ConfigMapKeySelectorBuilder> implements VisitableBuilder<ConfigMapKeySelector,ConfigMapKeySelectorBuilder>{

  ConfigMapKeySelectorFluent<?> fluent;

  public ConfigMapKeySelectorBuilder() {
    this(new ConfigMapKeySelector());
  }
  
  public ConfigMapKeySelectorBuilder(ConfigMapKeySelectorFluent<?> fluent) {
    this(fluent, new ConfigMapKeySelector());
  }
  
  public ConfigMapKeySelectorBuilder(ConfigMapKeySelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapKeySelectorBuilder(ConfigMapKeySelectorFluent<?> fluent,ConfigMapKeySelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapKeySelector build() {
    ConfigMapKeySelector buildable = new ConfigMapKeySelector(fluent.getKey(), fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}