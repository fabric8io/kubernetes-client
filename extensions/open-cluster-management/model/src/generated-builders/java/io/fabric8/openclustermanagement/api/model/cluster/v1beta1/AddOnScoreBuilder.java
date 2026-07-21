package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnScoreBuilder extends AddOnScoreFluent<AddOnScoreBuilder> implements VisitableBuilder<AddOnScore,AddOnScoreBuilder>{

  AddOnScoreFluent<?> fluent;

  public AddOnScoreBuilder() {
    this(new AddOnScore());
  }
  
  public AddOnScoreBuilder(AddOnScoreFluent<?> fluent) {
    this(fluent, new AddOnScore());
  }
  
  public AddOnScoreBuilder(AddOnScore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnScoreBuilder(AddOnScoreFluent<?> fluent,AddOnScore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnScore build() {
    AddOnScore buildable = new AddOnScore(fluent.getResourceName(), fluent.getScoreName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}