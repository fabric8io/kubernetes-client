package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapBuildSourceBuilder extends ConfigMapBuildSourceFluent<ConfigMapBuildSourceBuilder> implements VisitableBuilder<ConfigMapBuildSource,ConfigMapBuildSourceBuilder>{

  ConfigMapBuildSourceFluent<?> fluent;

  public ConfigMapBuildSourceBuilder() {
    this(new ConfigMapBuildSource());
  }
  
  public ConfigMapBuildSourceBuilder(ConfigMapBuildSourceFluent<?> fluent) {
    this(fluent, new ConfigMapBuildSource());
  }
  
  public ConfigMapBuildSourceBuilder(ConfigMapBuildSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapBuildSourceBuilder(ConfigMapBuildSourceFluent<?> fluent,ConfigMapBuildSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapBuildSource build() {
    ConfigMapBuildSource buildable = new ConfigMapBuildSource(fluent.buildConfigMap(), fluent.getDestinationDir());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}