package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentStatusListBuilder extends ComponentStatusListFluent<ComponentStatusListBuilder> implements VisitableBuilder<ComponentStatusList,ComponentStatusListBuilder>{

  ComponentStatusListFluent<?> fluent;

  public ComponentStatusListBuilder() {
    this(new ComponentStatusList());
  }
  
  public ComponentStatusListBuilder(ComponentStatusListFluent<?> fluent) {
    this(fluent, new ComponentStatusList());
  }
  
  public ComponentStatusListBuilder(ComponentStatusList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentStatusListBuilder(ComponentStatusListFluent<?> fluent,ComponentStatusList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentStatusList build() {
    ComponentStatusList buildable = new ComponentStatusList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}