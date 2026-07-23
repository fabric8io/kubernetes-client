package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetUpdateStrategyBuilder extends StatefulSetUpdateStrategyFluent<StatefulSetUpdateStrategyBuilder> implements VisitableBuilder<StatefulSetUpdateStrategy,StatefulSetUpdateStrategyBuilder>{

  StatefulSetUpdateStrategyFluent<?> fluent;

  public StatefulSetUpdateStrategyBuilder() {
    this(new StatefulSetUpdateStrategy());
  }
  
  public StatefulSetUpdateStrategyBuilder(StatefulSetUpdateStrategyFluent<?> fluent) {
    this(fluent, new StatefulSetUpdateStrategy());
  }
  
  public StatefulSetUpdateStrategyBuilder(StatefulSetUpdateStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetUpdateStrategyBuilder(StatefulSetUpdateStrategyFluent<?> fluent,StatefulSetUpdateStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetUpdateStrategy build() {
    StatefulSetUpdateStrategy buildable = new StatefulSetUpdateStrategy(fluent.buildRollingUpdate(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}