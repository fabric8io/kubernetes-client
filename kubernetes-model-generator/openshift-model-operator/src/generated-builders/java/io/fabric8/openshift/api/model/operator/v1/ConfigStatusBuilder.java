package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigStatusBuilder extends ConfigStatusFluent<ConfigStatusBuilder> implements VisitableBuilder<ConfigStatus,ConfigStatusBuilder>{

  ConfigStatusFluent<?> fluent;

  public ConfigStatusBuilder() {
    this(new ConfigStatus());
  }
  
  public ConfigStatusBuilder(ConfigStatusFluent<?> fluent) {
    this(fluent, new ConfigStatus());
  }
  
  public ConfigStatusBuilder(ConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigStatusBuilder(ConfigStatusFluent<?> fluent,ConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigStatus build() {
    ConfigStatus buildable = new ConfigStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}