package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigResourceConditionBuilder extends ConfigResourceConditionFluent<ConfigResourceConditionBuilder> implements VisitableBuilder<ConfigResourceCondition,ConfigResourceConditionBuilder>{

  ConfigResourceConditionFluent<?> fluent;

  public ConfigResourceConditionBuilder() {
    this(new ConfigResourceCondition());
  }
  
  public ConfigResourceConditionBuilder(ConfigResourceConditionFluent<?> fluent) {
    this(fluent, new ConfigResourceCondition());
  }
  
  public ConfigResourceConditionBuilder(ConfigResourceCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigResourceConditionBuilder(ConfigResourceConditionFluent<?> fluent,ConfigResourceCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigResourceCondition build() {
    ConfigResourceCondition buildable = new ConfigResourceCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getObservedGeneration(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}