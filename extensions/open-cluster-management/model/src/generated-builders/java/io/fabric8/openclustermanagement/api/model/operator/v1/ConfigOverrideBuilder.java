package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigOverrideBuilder extends ConfigOverrideFluent<ConfigOverrideBuilder> implements VisitableBuilder<ConfigOverride,ConfigOverrideBuilder>{

  ConfigOverrideFluent<?> fluent;

  public ConfigOverrideBuilder() {
    this(new ConfigOverride());
  }
  
  public ConfigOverrideBuilder(ConfigOverrideFluent<?> fluent) {
    this(fluent, new ConfigOverride());
  }
  
  public ConfigOverrideBuilder(ConfigOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigOverrideBuilder(ConfigOverrideFluent<?> fluent,ConfigOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigOverride build() {
    ConfigOverride buildable = new ConfigOverride(fluent.buildDeployments());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}