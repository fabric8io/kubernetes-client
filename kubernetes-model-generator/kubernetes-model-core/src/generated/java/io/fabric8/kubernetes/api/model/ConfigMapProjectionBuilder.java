package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapProjectionBuilder extends ConfigMapProjectionFluent<ConfigMapProjectionBuilder> implements VisitableBuilder<ConfigMapProjection,ConfigMapProjectionBuilder>{

  ConfigMapProjectionFluent<?> fluent;

  public ConfigMapProjectionBuilder() {
    this(new ConfigMapProjection());
  }
  
  public ConfigMapProjectionBuilder(ConfigMapProjectionFluent<?> fluent) {
    this(fluent, new ConfigMapProjection());
  }
  
  public ConfigMapProjectionBuilder(ConfigMapProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapProjectionBuilder(ConfigMapProjectionFluent<?> fluent,ConfigMapProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapProjection build() {
    ConfigMapProjection buildable = new ConfigMapProjection(fluent.buildItems(), fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}