package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementRuleStatusBuilder extends PlacementRuleStatusFluent<PlacementRuleStatusBuilder> implements VisitableBuilder<PlacementRuleStatus,PlacementRuleStatusBuilder>{

  PlacementRuleStatusFluent<?> fluent;

  public PlacementRuleStatusBuilder() {
    this(new PlacementRuleStatus());
  }
  
  public PlacementRuleStatusBuilder(PlacementRuleStatusFluent<?> fluent) {
    this(fluent, new PlacementRuleStatus());
  }
  
  public PlacementRuleStatusBuilder(PlacementRuleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementRuleStatusBuilder(PlacementRuleStatusFluent<?> fluent,PlacementRuleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementRuleStatus build() {
    PlacementRuleStatus buildable = new PlacementRuleStatus(fluent.buildDecisions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}