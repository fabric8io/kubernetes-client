package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigurationSpecBuilder extends ConfigurationSpecFluent<ConfigurationSpecBuilder> implements VisitableBuilder<ConfigurationSpec,ConfigurationSpecBuilder>{

  ConfigurationSpecFluent<?> fluent;

  public ConfigurationSpecBuilder() {
    this(new ConfigurationSpec());
  }
  
  public ConfigurationSpecBuilder(ConfigurationSpecFluent<?> fluent) {
    this(fluent, new ConfigurationSpec());
  }
  
  public ConfigurationSpecBuilder(ConfigurationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigurationSpecBuilder(ConfigurationSpecFluent<?> fluent,ConfigurationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigurationSpec build() {
    ConfigurationSpec buildable = new ConfigurationSpec(fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}