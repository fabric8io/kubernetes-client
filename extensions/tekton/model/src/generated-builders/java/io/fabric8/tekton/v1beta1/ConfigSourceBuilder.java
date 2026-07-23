package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigSourceBuilder extends ConfigSourceFluent<ConfigSourceBuilder> implements VisitableBuilder<ConfigSource,ConfigSourceBuilder>{

  ConfigSourceFluent<?> fluent;

  public ConfigSourceBuilder() {
    this(new ConfigSource());
  }
  
  public ConfigSourceBuilder(ConfigSourceFluent<?> fluent) {
    this(fluent, new ConfigSource());
  }
  
  public ConfigSourceBuilder(ConfigSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigSourceBuilder(ConfigSourceFluent<?> fluent,ConfigSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigSource build() {
    ConfigSource buildable = new ConfigSource(fluent.getDigest(), fluent.getEntryPoint(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}