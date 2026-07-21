package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigurationStatusBuilder extends ConfigurationStatusFluent<ConfigurationStatusBuilder> implements VisitableBuilder<ConfigurationStatus,ConfigurationStatusBuilder>{

  ConfigurationStatusFluent<?> fluent;

  public ConfigurationStatusBuilder() {
    this(new ConfigurationStatus());
  }
  
  public ConfigurationStatusBuilder(ConfigurationStatusFluent<?> fluent) {
    this(fluent, new ConfigurationStatus());
  }
  
  public ConfigurationStatusBuilder(ConfigurationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigurationStatusBuilder(ConfigurationStatusFluent<?> fluent,ConfigurationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigurationStatus build() {
    ConfigurationStatus buildable = new ConfigurationStatus(fluent.getAnnotations(), fluent.buildConditions(), fluent.getLatestCreatedRevisionName(), fluent.getLatestReadyRevisionName(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}