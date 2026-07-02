package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigBuilder extends ConfigFluent<ConfigBuilder> implements VisitableBuilder<Config,ConfigBuilder>{

  ConfigFluent<?> fluent;

  public ConfigBuilder() {
    this(new Config());
  }
  
  public ConfigBuilder(ConfigFluent<?> fluent) {
    this(fluent, new Config());
  }
  
  public ConfigBuilder(Config instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigBuilder(ConfigFluent<?> fluent,Config instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Config build() {
    Config buildable = new Config(fluent.getApiVersion(), fluent.buildClusters(), fluent.buildContexts(), fluent.getCurrentContext(), fluent.buildExtensions(), fluent.getKind(), fluent.buildPreferences(), fluent.buildUsers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}