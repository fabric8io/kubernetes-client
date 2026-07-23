package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityLevelConfigurationSpecBuilder extends PriorityLevelConfigurationSpecFluent<PriorityLevelConfigurationSpecBuilder> implements VisitableBuilder<PriorityLevelConfigurationSpec,PriorityLevelConfigurationSpecBuilder>{

  PriorityLevelConfigurationSpecFluent<?> fluent;

  public PriorityLevelConfigurationSpecBuilder() {
    this(new PriorityLevelConfigurationSpec());
  }
  
  public PriorityLevelConfigurationSpecBuilder(PriorityLevelConfigurationSpecFluent<?> fluent) {
    this(fluent, new PriorityLevelConfigurationSpec());
  }
  
  public PriorityLevelConfigurationSpecBuilder(PriorityLevelConfigurationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityLevelConfigurationSpecBuilder(PriorityLevelConfigurationSpecFluent<?> fluent,PriorityLevelConfigurationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityLevelConfigurationSpec build() {
    PriorityLevelConfigurationSpec buildable = new PriorityLevelConfigurationSpec(fluent.buildLimited(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}