package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementRuleListBuilder extends PlacementRuleListFluent<PlacementRuleListBuilder> implements VisitableBuilder<PlacementRuleList,PlacementRuleListBuilder>{

  PlacementRuleListFluent<?> fluent;

  public PlacementRuleListBuilder() {
    this(new PlacementRuleList());
  }
  
  public PlacementRuleListBuilder(PlacementRuleListFluent<?> fluent) {
    this(fluent, new PlacementRuleList());
  }
  
  public PlacementRuleListBuilder(PlacementRuleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementRuleListBuilder(PlacementRuleListFluent<?> fluent,PlacementRuleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementRuleList build() {
    PlacementRuleList buildable = new PlacementRuleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}