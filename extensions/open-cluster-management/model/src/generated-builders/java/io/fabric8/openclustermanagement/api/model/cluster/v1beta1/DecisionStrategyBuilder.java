package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DecisionStrategyBuilder extends DecisionStrategyFluent<DecisionStrategyBuilder> implements VisitableBuilder<DecisionStrategy,DecisionStrategyBuilder>{

  DecisionStrategyFluent<?> fluent;

  public DecisionStrategyBuilder() {
    this(new DecisionStrategy());
  }
  
  public DecisionStrategyBuilder(DecisionStrategyFluent<?> fluent) {
    this(fluent, new DecisionStrategy());
  }
  
  public DecisionStrategyBuilder(DecisionStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DecisionStrategyBuilder(DecisionStrategyFluent<?> fluent,DecisionStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DecisionStrategy build() {
    DecisionStrategy buildable = new DecisionStrategy(fluent.buildGroupStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}