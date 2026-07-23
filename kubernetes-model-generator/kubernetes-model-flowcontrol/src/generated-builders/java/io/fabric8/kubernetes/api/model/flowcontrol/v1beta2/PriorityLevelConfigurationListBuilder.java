package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityLevelConfigurationListBuilder extends PriorityLevelConfigurationListFluent<PriorityLevelConfigurationListBuilder> implements VisitableBuilder<PriorityLevelConfigurationList,PriorityLevelConfigurationListBuilder>{

  PriorityLevelConfigurationListFluent<?> fluent;

  public PriorityLevelConfigurationListBuilder() {
    this(new PriorityLevelConfigurationList());
  }
  
  public PriorityLevelConfigurationListBuilder(PriorityLevelConfigurationListFluent<?> fluent) {
    this(fluent, new PriorityLevelConfigurationList());
  }
  
  public PriorityLevelConfigurationListBuilder(PriorityLevelConfigurationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityLevelConfigurationListBuilder(PriorityLevelConfigurationListFluent<?> fluent,PriorityLevelConfigurationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityLevelConfigurationList build() {
    PriorityLevelConfigurationList buildable = new PriorityLevelConfigurationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}