package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentStatusBuilder extends ComponentStatusFluent<ComponentStatusBuilder> implements VisitableBuilder<ComponentStatus,ComponentStatusBuilder>{

  ComponentStatusFluent<?> fluent;

  public ComponentStatusBuilder() {
    this(new ComponentStatus());
  }
  
  public ComponentStatusBuilder(ComponentStatusFluent<?> fluent) {
    this(fluent, new ComponentStatus());
  }
  
  public ComponentStatusBuilder(ComponentStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentStatusBuilder(ComponentStatusFluent<?> fluent,ComponentStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentStatus build() {
    ComponentStatus buildable = new ComponentStatus(fluent.getApiVersion(), fluent.buildConditions(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}