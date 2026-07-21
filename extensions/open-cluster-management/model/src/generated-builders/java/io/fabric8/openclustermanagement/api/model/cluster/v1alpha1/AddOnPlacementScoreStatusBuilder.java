package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnPlacementScoreStatusBuilder extends AddOnPlacementScoreStatusFluent<AddOnPlacementScoreStatusBuilder> implements VisitableBuilder<AddOnPlacementScoreStatus,AddOnPlacementScoreStatusBuilder>{

  AddOnPlacementScoreStatusFluent<?> fluent;

  public AddOnPlacementScoreStatusBuilder() {
    this(new AddOnPlacementScoreStatus());
  }
  
  public AddOnPlacementScoreStatusBuilder(AddOnPlacementScoreStatusFluent<?> fluent) {
    this(fluent, new AddOnPlacementScoreStatus());
  }
  
  public AddOnPlacementScoreStatusBuilder(AddOnPlacementScoreStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnPlacementScoreStatusBuilder(AddOnPlacementScoreStatusFluent<?> fluent,AddOnPlacementScoreStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnPlacementScoreStatus build() {
    AddOnPlacementScoreStatus buildable = new AddOnPlacementScoreStatus(fluent.getConditions(), fluent.buildScores(), fluent.getValidUntil());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}