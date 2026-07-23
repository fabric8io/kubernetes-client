package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnPlacementScoreItemBuilder extends AddOnPlacementScoreItemFluent<AddOnPlacementScoreItemBuilder> implements VisitableBuilder<AddOnPlacementScoreItem,AddOnPlacementScoreItemBuilder>{

  AddOnPlacementScoreItemFluent<?> fluent;

  public AddOnPlacementScoreItemBuilder() {
    this(new AddOnPlacementScoreItem());
  }
  
  public AddOnPlacementScoreItemBuilder(AddOnPlacementScoreItemFluent<?> fluent) {
    this(fluent, new AddOnPlacementScoreItem());
  }
  
  public AddOnPlacementScoreItemBuilder(AddOnPlacementScoreItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnPlacementScoreItemBuilder(AddOnPlacementScoreItemFluent<?> fluent,AddOnPlacementScoreItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnPlacementScoreItem build() {
    AddOnPlacementScoreItem buildable = new AddOnPlacementScoreItem(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}