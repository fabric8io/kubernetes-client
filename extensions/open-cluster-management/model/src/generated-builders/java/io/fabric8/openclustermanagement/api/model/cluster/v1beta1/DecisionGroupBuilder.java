package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DecisionGroupBuilder extends DecisionGroupFluent<DecisionGroupBuilder> implements VisitableBuilder<DecisionGroup,DecisionGroupBuilder>{

  DecisionGroupFluent<?> fluent;

  public DecisionGroupBuilder() {
    this(new DecisionGroup());
  }
  
  public DecisionGroupBuilder(DecisionGroupFluent<?> fluent) {
    this(fluent, new DecisionGroup());
  }
  
  public DecisionGroupBuilder(DecisionGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DecisionGroupBuilder(DecisionGroupFluent<?> fluent,DecisionGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DecisionGroup build() {
    DecisionGroup buildable = new DecisionGroup(fluent.buildGroupClusterSelector(), fluent.getGroupName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}