package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityLevelConfigurationStatusBuilder extends PriorityLevelConfigurationStatusFluent<PriorityLevelConfigurationStatusBuilder> implements VisitableBuilder<PriorityLevelConfigurationStatus,PriorityLevelConfigurationStatusBuilder>{

  PriorityLevelConfigurationStatusFluent<?> fluent;

  public PriorityLevelConfigurationStatusBuilder() {
    this(new PriorityLevelConfigurationStatus());
  }
  
  public PriorityLevelConfigurationStatusBuilder(PriorityLevelConfigurationStatusFluent<?> fluent) {
    this(fluent, new PriorityLevelConfigurationStatus());
  }
  
  public PriorityLevelConfigurationStatusBuilder(PriorityLevelConfigurationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityLevelConfigurationStatusBuilder(PriorityLevelConfigurationStatusFluent<?> fluent,PriorityLevelConfigurationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityLevelConfigurationStatus build() {
    PriorityLevelConfigurationStatus buildable = new PriorityLevelConfigurationStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}