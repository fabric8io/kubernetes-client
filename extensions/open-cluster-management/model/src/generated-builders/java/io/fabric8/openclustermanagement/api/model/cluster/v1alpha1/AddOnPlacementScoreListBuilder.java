package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnPlacementScoreListBuilder extends AddOnPlacementScoreListFluent<AddOnPlacementScoreListBuilder> implements VisitableBuilder<AddOnPlacementScoreList,AddOnPlacementScoreListBuilder>{

  AddOnPlacementScoreListFluent<?> fluent;

  public AddOnPlacementScoreListBuilder() {
    this(new AddOnPlacementScoreList());
  }
  
  public AddOnPlacementScoreListBuilder(AddOnPlacementScoreListFluent<?> fluent) {
    this(fluent, new AddOnPlacementScoreList());
  }
  
  public AddOnPlacementScoreListBuilder(AddOnPlacementScoreList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnPlacementScoreListBuilder(AddOnPlacementScoreListFluent<?> fluent,AddOnPlacementScoreList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnPlacementScoreList build() {
    AddOnPlacementScoreList buildable = new AddOnPlacementScoreList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}