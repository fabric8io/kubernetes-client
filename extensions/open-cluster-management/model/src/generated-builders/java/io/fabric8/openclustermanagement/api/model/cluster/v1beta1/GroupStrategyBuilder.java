package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GroupStrategyBuilder extends GroupStrategyFluent<GroupStrategyBuilder> implements VisitableBuilder<GroupStrategy,GroupStrategyBuilder>{

  GroupStrategyFluent<?> fluent;

  public GroupStrategyBuilder() {
    this(new GroupStrategy());
  }
  
  public GroupStrategyBuilder(GroupStrategyFluent<?> fluent) {
    this(fluent, new GroupStrategy());
  }
  
  public GroupStrategyBuilder(GroupStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GroupStrategyBuilder(GroupStrategyFluent<?> fluent,GroupStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GroupStrategy build() {
    GroupStrategy buildable = new GroupStrategy(fluent.buildClustersPerDecisionGroup(), fluent.buildDecisionGroups());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}