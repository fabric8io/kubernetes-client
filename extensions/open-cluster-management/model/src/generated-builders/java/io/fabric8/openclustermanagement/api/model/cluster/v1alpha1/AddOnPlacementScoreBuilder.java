package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnPlacementScoreBuilder extends AddOnPlacementScoreFluent<AddOnPlacementScoreBuilder> implements VisitableBuilder<AddOnPlacementScore,AddOnPlacementScoreBuilder>{

  AddOnPlacementScoreFluent<?> fluent;

  public AddOnPlacementScoreBuilder() {
    this(new AddOnPlacementScore());
  }
  
  public AddOnPlacementScoreBuilder(AddOnPlacementScoreFluent<?> fluent) {
    this(fluent, new AddOnPlacementScore());
  }
  
  public AddOnPlacementScoreBuilder(AddOnPlacementScore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnPlacementScoreBuilder(AddOnPlacementScoreFluent<?> fluent,AddOnPlacementScore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnPlacementScore build() {
    AddOnPlacementScore buildable = new AddOnPlacementScore(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}