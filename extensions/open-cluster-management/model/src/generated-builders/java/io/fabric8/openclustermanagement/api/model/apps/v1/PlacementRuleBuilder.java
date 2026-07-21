package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementRuleBuilder extends PlacementRuleFluent<PlacementRuleBuilder> implements VisitableBuilder<PlacementRule,PlacementRuleBuilder>{

  PlacementRuleFluent<?> fluent;

  public PlacementRuleBuilder() {
    this(new PlacementRule());
  }
  
  public PlacementRuleBuilder(PlacementRuleFluent<?> fluent) {
    this(fluent, new PlacementRule());
  }
  
  public PlacementRuleBuilder(PlacementRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementRuleBuilder(PlacementRuleFluent<?> fluent,PlacementRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementRule build() {
    PlacementRule buildable = new PlacementRule(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}