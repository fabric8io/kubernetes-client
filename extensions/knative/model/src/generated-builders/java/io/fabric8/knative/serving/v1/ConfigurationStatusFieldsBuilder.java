package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigurationStatusFieldsBuilder extends ConfigurationStatusFieldsFluent<ConfigurationStatusFieldsBuilder> implements VisitableBuilder<ConfigurationStatusFields,ConfigurationStatusFieldsBuilder>{

  ConfigurationStatusFieldsFluent<?> fluent;

  public ConfigurationStatusFieldsBuilder() {
    this(new ConfigurationStatusFields());
  }
  
  public ConfigurationStatusFieldsBuilder(ConfigurationStatusFieldsFluent<?> fluent) {
    this(fluent, new ConfigurationStatusFields());
  }
  
  public ConfigurationStatusFieldsBuilder(ConfigurationStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigurationStatusFieldsBuilder(ConfigurationStatusFieldsFluent<?> fluent,ConfigurationStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigurationStatusFields build() {
    ConfigurationStatusFields buildable = new ConfigurationStatusFields(fluent.getLatestCreatedRevisionName(), fluent.getLatestReadyRevisionName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}