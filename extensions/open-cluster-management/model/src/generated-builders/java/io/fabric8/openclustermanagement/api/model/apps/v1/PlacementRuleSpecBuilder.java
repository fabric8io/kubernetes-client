package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementRuleSpecBuilder extends PlacementRuleSpecFluent<PlacementRuleSpecBuilder> implements VisitableBuilder<PlacementRuleSpec,PlacementRuleSpecBuilder>{

  PlacementRuleSpecFluent<?> fluent;

  public PlacementRuleSpecBuilder() {
    this(new PlacementRuleSpec());
  }
  
  public PlacementRuleSpecBuilder(PlacementRuleSpecFluent<?> fluent) {
    this(fluent, new PlacementRuleSpec());
  }
  
  public PlacementRuleSpecBuilder(PlacementRuleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementRuleSpecBuilder(PlacementRuleSpecFluent<?> fluent,PlacementRuleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementRuleSpec build() {
    PlacementRuleSpec buildable = new PlacementRuleSpec(fluent.buildClusterConditions(), fluent.getClusterReplicas(), fluent.buildClusterSelector(), fluent.buildClusters(), fluent.buildPolicies(), fluent.buildResourceHint(), fluent.getSchedulerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}