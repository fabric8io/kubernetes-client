package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigResourceStatusBuilder extends ConfigResourceStatusFluent<ConfigResourceStatusBuilder> implements VisitableBuilder<ConfigResourceStatus,ConfigResourceStatusBuilder>{

  ConfigResourceStatusFluent<?> fluent;

  public ConfigResourceStatusBuilder() {
    this(new ConfigResourceStatus());
  }
  
  public ConfigResourceStatusBuilder(ConfigResourceStatusFluent<?> fluent) {
    this(fluent, new ConfigResourceStatus());
  }
  
  public ConfigResourceStatusBuilder(ConfigResourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigResourceStatusBuilder(ConfigResourceStatusFluent<?> fluent,ConfigResourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigResourceStatus build() {
    ConfigResourceStatus buildable = new ConfigResourceStatus(fluent.buildBindings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}